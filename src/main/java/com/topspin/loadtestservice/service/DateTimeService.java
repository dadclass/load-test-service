package com.topspin.loadtestservice.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

@Service
public class DateTimeService {
	
	public String formatEpochMilli(long ms) {
		LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(ms), ZoneId.systemDefault());
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
		return fmt.format(localDateTime);
	}
}
