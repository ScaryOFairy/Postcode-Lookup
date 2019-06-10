package com.address.addressapp;

import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Provider
@Component
public class ServiceConfig extends ResourceConfig{
	
	public ServiceConfig() {
		        register(CORSFilter.class);
		        register(AddressAccessAPI.class);		        
	}
}


