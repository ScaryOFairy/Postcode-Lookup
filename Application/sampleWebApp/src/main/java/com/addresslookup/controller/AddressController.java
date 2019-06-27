package com.addresslookup.controller;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.addresslookup.dao.AddressDAO;

import com.addresslookup.entity.AddressBean;


//rest apis
@RestController
@Component
@Path("/address")
public class AddressController {
	
	@Autowired //to inject the implementation of the service into the controller
	AddressDAO newAddress;
	
//	 @Path("/")
//	 @GET
//	 @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//	    public String index() {
//	        return "index.html";
//	    }
			
	@Path("/getAddress")
	@POST
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String returnDao(@BeanParam AddressBean addressBean) throws Exception {
	
		return (newAddress.postcodeRequest(addressBean)).toString();

		
	}

	@Path("/onehouse")
	@POST
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String returnOneHouse(@BeanParam AddressBean addressBean) throws Exception {
		try {	
		return newAddress.postcodeAndHouseRequest(addressBean).toString();
		} catch(Exception e) {
			e.printStackTrace();
			return "Incorrect postcode or house number/name request, check api-key validation";
		}
		
	}
	
	@GetMapping("/get")
	public @ResponseBody ResponseEntity<String> get() {
	    return new ResponseEntity<String>("GET Response", HttpStatus.OK);
	}
	
}
