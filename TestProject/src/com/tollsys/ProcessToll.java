package com.tollsys;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.tollsys.dal.entities.Commuter;
import com.tollsys.dal.entities.SmartCard;
import com.tollsys.dal.entities.TollGate;

public class ProcessToll {
	
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date entryDateTime;
	Date exitDateTime;
	Commuter commuter;
	
	public ProcessToll() {
		commuter = new Commuter();
		entryDateTime = new Date();
	}
	
	public void addEntry(SmartCard sCard, TollGate entry) {
		//ProcessToll process = new ProcessToll();
		this.entryDateTime = new Date();
	}
	
	public void addExit(String smartCardId) {
		
	}
	
	public SmartCard getSmartCard(String smartCardId) {
		return new SmartCard(smartCardId);
	}
	
	public int getTollDistance(TollGate entry, TollGate exit) {
		Map<String, Integer> tollDistanceMap = new HashMap<String, Integer>();
		tollDistanceMap.put("TG1-TG2", 55);
		tollDistanceMap.put("TG2-TG3", 40);
		tollDistanceMap.put("TG3-TG4", 50);
		tollDistanceMap.put("TG4-TG1", 60);
		
		tollDistanceMap.put("TG1-TG3", 95);
		tollDistanceMap.put("TG2-TG4", 90);
		Integer distance = 0;
		String key = entry.name() + "-" +exit.name();
		if(tollDistanceMap.containsKey(key))
			distance = tollDistanceMap.get(key);
		else {
			key = exit.name() + "-" +entry.name();
			distance = tollDistanceMap.get(key);
		}
		return distance;
	}
}
