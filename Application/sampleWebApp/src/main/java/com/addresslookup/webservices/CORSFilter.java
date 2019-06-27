package com.addresslookup.webservices;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Component;

//Passes access headers for GET/POST/DELETE Requests

@Provider //to ensure the filter applied for the web service environment
@Component // to ensure the filter is managed by spring application context
public class CORSFilter implements ContainerResponseFilter{

		@Override
		public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
				throws IOException {
			responseContext.getHeaders().add("Access-Control-Allow-Origin", "*");
			responseContext.getHeaders().add("Access-Control-Allow-Headers",
				    "Origin, X-Requested-With, Content-Type, Content-Length, Accept");
			responseContext.getHeaders().add("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE");
			
			
		}
	
		
	
}