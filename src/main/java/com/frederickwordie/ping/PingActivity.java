package com.frederickwordie.ping;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PingActivity implements Callable<PingData> {
	private static final Logger log = LoggerFactory.getLogger(PingActivity.class);
	private String ipAddress;
	private Integer id; 
	private String link;
	
	private Integer returnVal = 2;

	
	public PingActivity(String ipAddress, Integer id, String link) {
		this.ipAddress = ipAddress;
		this.id = id;
		this.link = link;
	}



	@Override
	public PingData call() throws Exception {
		try {
			InetAddress address = InetAddress.getByName(ipAddress);
			boolean reachable = address.isReachable(5000);
			if (reachable){
				returnVal = 0; 
			}
			else{
				returnVal = 1; 
			}		
		} catch(UnknownHostException e){
			log.error(e.getMessage());
		  }catch (Exception e) {
			  e.printStackTrace();
		}
		return new PingData(ipAddress,id,returnVal,link);
				
	}

}
