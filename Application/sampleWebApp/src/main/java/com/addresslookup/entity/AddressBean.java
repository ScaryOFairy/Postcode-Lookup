package com.addresslookup.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
;

@Entity
@Table(name="address")
public class AddressBean {
	
	@FormParam("addressID")
	public Long addressId;
	
	@FormParam("Postcode")
	public String postcode;
	
	@FormParam("house")
	public String houseNameOrNumber;
	
	@FormParam("api-key")
	public String apiKey;
	
	
	@Id
	@GeneratedValue
	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getHouseNameOrNumber() {
		return houseNameOrNumber;
	}

	public void setHouseNameOrNumber(String houseNameOrNumber) {
		this.houseNameOrNumber = houseNameOrNumber;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	
	

}
