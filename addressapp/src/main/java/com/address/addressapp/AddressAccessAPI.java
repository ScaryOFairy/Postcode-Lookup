package com.address.addressapp;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import org.json.JSONObject;
import org.springframework.stereotype.Component;


@Component
@Path("/address_lookup")  //http://localhost:9900/address_lookup
public class AddressAccessAPI {
	
	//simple get request testing (--Will Remove--)
	@Path("/testing")
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Map<String,String> testingLocalApi() {
		
		HashMap<String, String> map = new HashMap<>();
		
		map.put("address_url", "https://api.getaddress.io/find/%20yo179aq?api-key=LFG96MdGnUu6ZU9Y9_ZPQQ19108%20");
		return map;
	}
	
	@Path("/listpostcode")
	@POST
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String returnPostcodeURL(@BeanParam Address newAddress) throws Exception {
	
		JSONObject js = new JSONObject();
		js.put("addresses", newAddress.postcodeRequeset());
		return js.toString();
	
	}
	
	@Path("/housenumber")
	@POST
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String returnPostcodeURLOneHouse(@BeanParam Address newAddress) throws Exception {
	
		JSONObject js = new JSONObject();
		js.put("addresses", newAddress.postcodeAndHouseRequeset());
		return js.toString();
	
	}
	
	
		
}