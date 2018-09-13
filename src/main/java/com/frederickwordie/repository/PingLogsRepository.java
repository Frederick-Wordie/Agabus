package com.frederickwordie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.frederickwordie.model.Links;
import com.frederickwordie.model.PingLogs;

public interface PingLogsRepository extends JpaRepository<PingLogs, Integer>{

	public List<PingLogs> findByLinkId(Links LinkId);
}
