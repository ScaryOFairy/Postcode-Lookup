package com.addresslookup.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.addresslookup.dao.AddressDAO;
import com.addresslookup.entity.AddressBean;



@Component
@Service
@Primary
public class AddressDAOImpl implements AddressDAO{
	
	
	private String ADDRESS_API_URL = "https://api.getAddress.io/find/";
	
	@Autowired
	public AddressDAO addressDAO;
	
	@Override
	public String readAll(Reader rd) {
	    StringBuilder sb = new StringBuilder();
	    int cp;
	    try {
			while ((cp = rd.read()) != -1) {
			  sb.append((char) cp);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	    return sb.toString();
	}

	@Override
	public JSONObject readJsonFromUrl(String url) throws IOException, JSONException  {
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

	@Override
	public JSONObject postcodeRequest(AddressBean addressBean) throws JSONException, IOException {

		addressBean.apiKey = "DX43spncdEWTAYhxt7NO2w19879";

		String url = ADDRESS_API_URL+ addressBean.postcode +"?api-key="+addressBean.apiKey;

		JSONObject jsonResponse = readJsonFromUrl(url);
	    JSONArray arr = (JSONArray) jsonResponse.get("addresses");

	    System.out.println(arr);
	    JSONObject addresses = new JSONObject();

	    addresses.put("addresses", arr);		

		return addresses;

	}

	@Override
	public JSONObject postcodeAndHouseRequest(AddressBean addressBean) throws Exception {
		String url = ADDRESS_API_URL+addressBean.postcode+"/"+addressBean.houseNameOrNumber+"?api-key="+addressBean.apiKey; 
		JSONObject jsonResponse = readJsonFromUrl(url);
		
		return jsonResponse;
	}

	public AddressDAO getAddressDAO() {
		return addressDAO;
	}

	public void setAddressDAO(AddressDAO addressDAO) {
		this.addressDAO = addressDAO;
	}


}