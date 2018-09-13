package com.frederickwordie.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.frederickwordie.model.Links;
import com.frederickwordie.model.PingLogs;
import com.frederickwordie.repository.LinkRepository;

@Service
@Transactional
public class LinkService {

	@Autowired
	private LinkRepository linkrepository;

	public void saveLinks(Links link) {
		linkrepository.save(link);
	}

	public List<Links> getAllLinks() {
		return linkrepository.findAll();
	}
	
	public void updateLinksDown(List<Integer> linkIds) {
		linkrepository.updateLinksDown(linkIds);
	}

	public void updateLinksUp(List<Integer> linkIds) {
		linkrepository.updateLinksUp(linkIds);
	}
	public Map<Integer, List<String>> getIpOfActiveLinks() {

		List<Links> activeDevices = linkrepository.findAll();
		Map<Integer, List<String>> linkMap = new HashMap<>();
		if (activeDevices.size() > 0) {
			for (Links d : activeDevices) {
				if (d.getIpAddress() != null && !d.getIpAddress().isEmpty()) {
					List<String> stringlist = new ArrayList<String>();
					stringlist.add(0, d.getIpAddress().trim());
					stringlist.add(1, d.getLinkName());
					linkMap.put(d.getLinkId(), stringlist);
				}
			}
		}
		return linkMap;
	}
	
	public void processUplinks(List<PingLogs> logs) {
		if(!logs.isEmpty()) {
			List<Integer> plogs = new ArrayList<>();
			for (PingLogs p : logs) {
				plogs.add(p.getLinkId().getLinkId());
			}
			linkrepository.updateLinksUp(plogs);
		}
	}
	
	public void processDownlinks(List<PingLogs> logs) {
		if(!logs.isEmpty()) {
			List<Integer> plogs = new ArrayList<>();
			for (PingLogs p : logs) {
				plogs.add(p.getLinkId().getLinkId());
			}
			linkrepository.updateLinksDown(plogs);
		}
	}
	
}
