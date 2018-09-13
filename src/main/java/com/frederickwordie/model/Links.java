package com.frederickwordie.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_link")
public class Links implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="linkid")
	private Integer linkId;
	@Column(name="linkname")
	private String linkName;
	@Column(name="ipaddress")
	private String ipAddress;
	@Column(name="description")
	private String description;
	@Column(name="linkupdown")
	private String linkUpDown;

	public Links() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Links(Integer linkId) {
		super();
		this.linkId = linkId;
	}


	public Integer getLinkId() {
		return linkId;
	}

	public void setLinkId(Integer linkId) {
		this.linkId = linkId;
	}

	public String getLinkName() {
		return linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getLinkUpDown() {
		return linkUpDown;
	}

	public void setLinkUpDown(String linkUpDown) {
		this.linkUpDown = linkUpDown;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
