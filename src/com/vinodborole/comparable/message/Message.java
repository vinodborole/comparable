package com.vinodborole.comparable.message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vinodborole.comparable.app.MyComparable;

public class Message extends MyComparable{
 
	private Protocol protocol;
	private Long ownerId;
    private String serialNumber;
    private String ipAddr;
    private String macAddr;
    private String deviceFamily;
    private List<String> serverList=new ArrayList<String>();
    private Map<String,String> netMap = new HashMap<String,String>();
    
   public Message(Protocol protocol, Long ownerId, String serialNumber, String ipAddr, String macAddr, String deviceFamily){
        this.protocol=protocol;
        this.ownerId=ownerId;
        this.serialNumber=serialNumber;
        this.ipAddr=ipAddr;
        this.macAddr=macAddr;
        this.deviceFamily=deviceFamily;
    }
    
    
    public Message(){
    	this.protocol = Protocol.SSH;
    	this.ownerId = 1l;
    	this.serialNumber = "adasdasd";
    	this.ipAddr="10.10.10.10";
    	this.macAddr = "MC:KJ:ER:WE";
    	this.deviceFamily = "DELL";
    } 
    
	public Message(Protocol protocol, Long ownerId, String serialNumber, String ipAddr, String macAddr) {
	    this.protocol=protocol;
        this.ownerId=ownerId;
        this.serialNumber=serialNumber;
        this.ipAddr=ipAddr;
        this.macAddr=macAddr;
    }


    public Map<String, String> getNetMap() {
        return netMap;
    }


    public void setNetMap(Map<String, String> netMap) {
        this.netMap = netMap;
    }


    public List<String> getServerList() {
        return serverList;
    }


    public void setServerList(List<String> serverList) {
        this.serverList = serverList;
    }


    public Protocol getProtocol() {
		return protocol;
	}
	public void setProtocol(Protocol protocol) {
		this.protocol = protocol;
	}
	public Long getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getIpAddr() {
		return ipAddr;
	}
	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}
	public String getMacAddr() {
		return macAddr;
	}
	public void setMacAddr(String macAddr) {
		this.macAddr = macAddr;
	}
	public String getDeviceFamily() {
		return deviceFamily;
	}
	public void setDeviceFamily(String deviceFamily) {
		this.deviceFamily = deviceFamily;
	}

	@Override
	public int compareTo(Object o) {
		
		return 0;
	}

    
}
