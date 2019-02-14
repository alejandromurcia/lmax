package com.uniandes.lmax.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.uniandes.lmax.events.ProcessorEvent;
import com.uniandes.lmax.services.ReceptionerService;

/**
 * This controller provides the access for the receiver end point
 *
 */
@Controller
@EnableAutoConfiguration
public class ReceiverController {
		
	@Autowired
	private ReceptionerService receptionerService;
		
	/**
	 *
	 * @param message the message
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
    @RequestMapping(value = "/receiver", method = RequestMethod.POST)
    @ResponseBody
    ProcessorEvent encode(@RequestBody ProcessorEvent trace) throws JsonParseException, JsonMappingException, IOException {
    	
    	this.receptionerService.recepcionerTrace(trace);
    	
    	return trace;
    }
}