package com.addresslookup.controller;


import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import com.addresslookup.dao.LoqateDAO;
import com.addresslookup.entity.LoqateBean;

@RestController	
@Component
@Path("/address")
public class LoqateController {
	
	@Autowired
	LoqateDAO newLoqate;
	
	// to return the list
	@Path("/getAddress")
	@POST
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String firstFind(@BeanParam LoqateBean loqateBean) throws Exception {
		
		return (newLoqate.findFirst(loqateBean)).toString();
		
	}
		
	// to find specific address
	@Path("/retrieve")
	@POST
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String retrieve(@BeanParam LoqateBean loqateBean) throws Exception {
		
		JSONObject js = new JSONObject();
		js.put("Items", newLoqate.retrieve(loqateBean));
		return js.toString();
		
	}

}
