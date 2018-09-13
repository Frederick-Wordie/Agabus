package com.frederickwordie.ping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolExecutorFactoryBean;
import org.springframework.stereotype.Component;

import com.frederickwordie.model.Links;
import com.frederickwordie.model.PingLogs;
import com.frederickwordie.service.LinkService;

@Component
public class PingingJob {
	private static final Logger log = LoggerFactory.getLogger(PingingJob.class);
	@Autowired
	private ThreadPoolExecutorFactoryBean executeTask;
	
	@Autowired
	private LinkService linkservice;
	
	private Map<Integer, List<String>> linksMap;
	private List<PingLogs> downlinks = new ArrayList<>();
	private List<PingLogs> uplinks = new ArrayList<>();
	
	@Scheduled(initialDelay = 60000, fixedDelay = 60000)
	public synchronized void pingLinkIps() {
		linksMap = linkservice.getIpOfActiveLinks();
		List<Future<PingData>> list = new ArrayList<Future<PingData>>();
		Callable<PingData> callable = null;
		ExecutorService executor = executeTask.getObject();
		int i = 0;
		if (!linksMap.isEmpty()) {
			for (Entry<Integer, List<String>> entry : linksMap.entrySet()) {
				if (entry != null) {
					Integer key = entry.getKey();
					String value = entry.getValue().get(0);
					String link = entry.getValue().get(1);
					callable = new PingActivity(value, key, link);; 
					Future<PingData> future = executor.submit(callable);
					list.add(future);
				}

			}
			for (Future<PingData> fut : list) {
				i++;
				try {
					if (fut.get().getResultCode() == 0) {
						List<String> itemList = new ArrayList<>();
						itemList.add(0, fut.get().getIpAddress());
						itemList.add(1, fut.get().getLink());
						uplinks.add(new PingLogs(new Links (fut.get().getId()),LocalDateTime.now()));
					} else {
						downlinks.add(new PingLogs(new Links (fut.get().getId()),LocalDateTime.now()));
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(!downlinks.isEmpty()){
				linkservice.processDownlinks(downlinks);
				log.info("NUMBER DOWN: {}", downlinks.size());
				downlinks.clear();
			}
			if(!uplinks.isEmpty()){
				linkservice.processUplinks(uplinks);
			//	downtimeUpdatesService.updateLinkUpDevices(upDeviceData);
				log.info("NUMBER UP: {}", uplinks.size());
				uplinks.clear();
			}
			
			log.info("Finished processing {} threads\n", i);
			
		}
	}
}
