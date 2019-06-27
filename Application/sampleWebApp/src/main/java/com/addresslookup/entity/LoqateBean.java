package com.addresslookup.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.ws.rs.FormParam;

@Entity
@Table(name="loqate")
public class LoqateBean {
	
	@FormParam("loqateID")
	public Long loqateID;
	
	@FormParam("Key")
	public String key;
	
	@FormParam("Postcode")
	public String postcode;
	
	@FormParam("Countries")
	public String countries;
	
	@FormParam("IsMiddleware")
	public String isMiddleware;
	
	@FormParam("Container")
	public String container;
	
	@FormParam("Id")
	public String Id;

	@Id
	@GeneratedValue
	public Long getLoqateID() {
		return loqateID;
	}

	public void setLoqateID(Long loqateID) {
		this.loqateID = loqateID;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getCountries() {
		return countries;
	}

	public void setCountries(String countries) {
		this.countries = countries;
	}

	public String getContainer() {
		return container;
	}

	public void setContainer(String container) {
		this.container = container;
	}

	public String getId() {
		return Id;
	}

	public void setId(String Id) {
		this.Id = Id;
	}

	public String getIsMiddleware() {
		return isMiddleware;
	}

	public void setIsMiddleware(String isMiddleware) {
		this.isMiddleware = isMiddleware;
	}
	
	

}
