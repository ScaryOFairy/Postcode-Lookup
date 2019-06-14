package com.addresslookup.entity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.ws.rs.FormParam;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.addresslookup.dao.AddressDAO;

import lombok.Getter;	//lombok provides the getter and setters for us
import lombok.Setter;

@Entity
@Table(name="address")
public class AddressBean {
	
	@FormParam("addressID")
	public Long addressId;
	
	@FormParam("postcode")
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
