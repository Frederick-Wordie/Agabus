package com.frederickwordie.ping;

public class PingData {

	private String ipAddress;
	private Integer id;
	private int resultCode;
	private String link;

	
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getResultCode() {
		return resultCode;
	}
	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	public PingData() {
		// TODO Auto-generated constructor stub
	}
	
	
	 public PingData(String ipAddress, Integer id, int resultCode) {
		super();
		this.ipAddress = ipAddress;
		this.id = id;
		this.resultCode = resultCode;
	}
	public PingData(String ipAddress, Integer id, int resultCode, String link) {
		this.ipAddress = ipAddress;
		this.id = id;
		this.resultCode = resultCode;
		this.link = link;
		
	}
	public String toString() {
		    return "IpAddress :: "+ ipAddress + " Result Code : "+ resultCode + " ID : "+ id;
		  }
}
