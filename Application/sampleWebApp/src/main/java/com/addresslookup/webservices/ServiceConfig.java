package com.addresslookup.webservices;

import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.addresslookup.controller.AddressController;
import com.addresslookup.controller.LoqateController;
import com.addresslookup.dao.AddressDAOImpl;
import com.addresslookup.dao.LoqateDAO;
import com.addresslookup.dao.LoqateDAOImpl;

@Provider
@Component
public class ServiceConfig extends ResourceConfig{
	
	public ServiceConfig() {
		register(CORSFilter.class);

		register(AddressDAOImpl.class);
		register(AddressController.class);
//		register(LoqateDAOImpl.class);
//		register(LoqateController.class);

	}

}
