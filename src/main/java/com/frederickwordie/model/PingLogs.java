package com.frederickwordie.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_pinglogs")
public class PingLogs implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="logId")
	private Integer logId;
	
	@ManyToOne
	@JoinColumn(name = "linkId", referencedColumnName = "linkId")
	private Links linkId;
	@Column(name="downtime")
	private LocalDateTime downtime;
	@Column(name="uptime")
	private LocalDateTime uptime;
	@Column(name="duration")
	private Integer duration;
	
	
	public PingLogs() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public PingLogs(Links linkId, LocalDateTime uptime) {
		super();
		this.linkId = linkId;
		this.uptime = uptime;
	}


	public PingLogs(Links linkId, LocalDateTime downtime, LocalDateTime uptime, Integer duration) {
	
		this.linkId = linkId;
		this.downtime = downtime;
		this.uptime = uptime;
		this.duration = duration;
	}


	public Integer getLogId() {
		return logId;
	}
	public void setLogId(Integer logId) {
		this.logId = logId;
	}
	public Links getLinkId() {
		return linkId;
	}
	public void setLinkId(Links linkId) {
		this.linkId = linkId;
	}
	public LocalDateTime getDowntime() {
		return downtime;
	}
	public void setDowntime(LocalDateTime downtime) {
		this.downtime = downtime;
	}
	public LocalDateTime getUptime() {
		return uptime;
	}
	public void setUptime(LocalDateTime uptime) {
		this.uptime = uptime;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	
	
	
}
