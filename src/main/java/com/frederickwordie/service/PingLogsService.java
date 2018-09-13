package com.frederickwordie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.frederickwordie.model.Links;
import com.frederickwordie.model.PingLogs;
import com.frederickwordie.repository.PingLogsRepository;

@Service
@Transactional
public class PingLogsService {

	@Autowired
	private PingLogsRepository pingrepository;

	public void savePingLogs(PingLogs pings) {
		pingrepository.save(pings);
	}
	
	public List<PingLogs> findAllpings(){
		return pingrepository.findAll();
	}
	
	public List<PingLogs> findAllByLinkId(Links LinkId){
		return pingrepository.findByLinkId(LinkId);
		
	}
}
