package com.address.addressapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

@Entity
@Table(name="Address_table")
@XmlRootElement
//@RestController
public class Address {
	

	@FormParam("addressID")
	int addressID;
	@FormParam("postcode")
	String postcode;
	@FormParam("house")
	String house_number_name;
	@FormParam("api-key")
	String api_key;
	
	private final String ADDRESS_API_URL = "https://api.getAddress.io/find/";
//	@Value("${user.properties.finalUrl}")
//	private String ADDRESS_API_URL;	
	
	@Id
	@GeneratedValue
	public int getAddressID() {
		return addressID;
	}

	public void setAddressID(int addressID) {
		this.addressID = addressID;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getHouse_number_name() {
		return house_number_name;
	}

	public void setHouse_number_name(String house_number_name) {
		this.house_number_name = house_number_name;
	}

	public String getApi_key() {
		return api_key;
	}

	public void setApi_key(String api_key) {
		this.api_key = api_key;
	}
	
	private static String readAll(Reader rd) throws IOException {
	    StringBuilder sb = new StringBuilder();
	    int cp;
	    while ((cp = rd.read()) != -1) {
	      sb.append((char) cp);
	    }
	    return sb.toString();
	  }

	  public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
	    InputStream is = new URL(url).openStream();
	    try {
	    	//BufferReader reading the text from the InputStream (is)
	    	//InputStreamReader decoding bytes into characters using the specified charset
	    	BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	    	String jsonText = readAll(rd);
	    	JSONObject json = new JSONObject(jsonText);
	      return json;
	    } finally {
	      is.close();
	    }
	  }
	
	  //post code request, passing params
	  public org.json.JSONObject postcodeRequeset() throws Exception {
			String url = ADDRESS_API_URL+this.postcode+"?api-key="+this.api_key;  
			org.json.JSONObject jsonResponse = readJsonFromUrl(url);
			System.out.print(jsonResponse);
			return jsonResponse;
		  }
	  
	  //post code request, passing params
	  public org.json.JSONObject postcodeAndHouseRequeset() throws Exception {
			String url = ADDRESS_API_URL+this.postcode+"/"+this.house_number_name+"?api-key="+this.api_key;  
			org.json.JSONObject jsonResponse = readJsonFromUrl(url);
			System.out.print(jsonResponse);
			return jsonResponse;
		  }
	  	  
}
	 

	
	
	

