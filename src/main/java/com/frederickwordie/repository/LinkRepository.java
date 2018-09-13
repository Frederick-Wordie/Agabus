package com.frederickwordie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.frederickwordie.model.Links;

public interface LinkRepository extends JpaRepository<Links, Integer>{
	
	@Modifying
	@Query("update Links set linkUpDown = 'DOWN' where linkId in :LinkId")
	public void updateLinksDown(@Param("LinkId") List<Integer> linkIds);
	
	@Modifying
	@Query("update Links set linkUpDown = 'UP' where linkId in :LinkId")
	public void updateLinksUp(@Param("LinkId") List<Integer> linkIds);

}
