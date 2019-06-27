package com.addresslookup.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.LinkedList;
import java.util.List;


import org.json.JSONException;
import org.json.JSONObject;

import com.addresslookup.entity.AddressBean;

public interface AddressDAO{

	public String readAll(Reader rd);
	public JSONObject readJsonFromUrl(String url) throws IOException, JSONException;
	public JSONObject postcodeRequest(AddressBean addressBean) throws IOException, JSONException;
	public JSONObject postcodeAndHouseRequest(AddressBean addressBean) throws Exception;
	
}
