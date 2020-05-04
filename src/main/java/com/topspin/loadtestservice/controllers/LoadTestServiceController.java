package com.topspin.loadtestservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.topspin.loadtestservice.service.LoadTestService;

@RestController
public class LoadTestServiceController {
	
	@Autowired
	private LoadTestService ltSvc;
	
    @RequestMapping("/loadcpu")
    public String loadCpu(@RequestParam(name="request") String requestNum) {
        return ltSvc.addCpuLoad(requestNum);
    }
    
    @RequestMapping("loadram")
    public String loadRam(@RequestParam(name="request") String requestNum) {
        return ltSvc.addRamLoad(requestNum);
    }
}
