package com.topspin.loadtestservice.service;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoadTestService {
	private static final Logger LOGGER=LoggerFactory.getLogger(LoadTestService.class);
	private final long SECOND = 1000l;
	private final long CPU_LOAD_TIME = 30*SECOND;
	private final long RAM_LOAD_TIME = 10*SECOND;
	private final int LEN_100MB = 100*1024*1024;
	
	@Autowired
	private DateTimeService dtSvc;
	
	public String addCpuLoad(String requestNum) {
		long startTime = System.currentTimeMillis();
		LOGGER.info(String.format("Request#%s received", requestNum));
		
		while (true) {
			if ( (System.currentTimeMillis()-startTime) > CPU_LOAD_TIME) {
				break;
			}
		}
		
		long endTime = System.currentTimeMillis();
		LOGGER.info(String.format("Request#%s responded", requestNum));
				
		return String.format("request#%s responded at %s duration %.4f ms", 
				requestNum, dtSvc.formatEpochMilli(endTime), (endTime-startTime)/1000d);
	}
	
	public String addRamLoad(String requestNum) {
		long startTime = System.currentTimeMillis();
		LOGGER.info(String.format("Request#%s received", requestNum));
		
		char[] str100mb = new char[LEN_100MB];
		Arrays.fill(str100mb, 'a');
		
		try {
			Thread.sleep(RAM_LOAD_TIME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		str100mb = null;
		long endTime = System.currentTimeMillis();
		LOGGER.info(String.format("Request#%s responded", requestNum));
		return String.format("request#%s responded at %s duration %.4f ms", 
				requestNum, dtSvc.formatEpochMilli(endTime), (endTime-startTime)/1000d);
	}
}
