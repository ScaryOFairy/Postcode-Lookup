package com.addresslookup.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.addresslookup.entity.LoqateBean;

@Component
@Service
public class LoqateDAOImpl extends AddressDAOImpl implements LoqateDAO {
	
	private String LOQATE_API_URL = "https://api.addressy.com/Capture/Interactive/";
	
	@Autowired
	public LoqateDAO loqateDAO;
	
	@Override
	public JSONObject findFirst(LoqateBean loqateBean) throws IOException, JSONException {
		loqateBean.key = "AN81-BY77-CX62-KE28";
		loqateBean.countries = "GB";
		loqateBean.isMiddleware = "True";
		
	    String url = LOQATE_API_URL+"Find/v1.1/json3.ws?Key="+loqateBean.key+"&text="+loqateBean.postcode+"&isMiddleware="+loqateBean.isMiddleware+"&countries="+loqateBean.countries;
	    JSONObject jsonResponse = readJsonFromUrl(url);
	    JSONArray arr = (JSONArray) jsonResponse.get("Items");
	    JSONObject object = arr.getJSONObject(0);
	    String findId = object.getString("Id");
	    
	    String url2electricBoogaloo = LOQATE_API_URL+"/Find/v1.1/json3.ws?Key="+loqateBean.key+"&text="+loqateBean.postcode +
	            "&countries="+loqateBean.countries+"&isMiddleware="+loqateBean.isMiddleware+"&container="+ findId;
	    JSONObject step2response = readJsonFromUrl(url2electricBoogaloo);	    
	    
	    //trying to get the text and desc	    
	    List<String> results = new ArrayList<>();
	    JSONArray arr2 = (JSONArray) step2response.get("Items");
	    JSONObject addresses = new JSONObject();
	       
        for (int i = 0; i < arr2.length(); i++) {
            JSONObject object2 = arr2.getJSONObject(i);
            System.out.println(object2.getString("Text") + 
            		 	       	object2.getString("Description"));

            String textAndDesc = (object2.getString("Text") + " " + object2.getString("Description"));
            results.add(textAndDesc);
            
            
        }
        addresses.put("addresses", results);
        
        System.out.println("the full objects: " + results);        
        
	    return addresses;
	}
	
	
	@Override
	public JSONObject retrieve(LoqateBean loqateBean) throws IOException, JSONException {
		String url = LOQATE_API_URL+"/Retrieve/v1.00/json3.ws?Key="+loqateBean.key+"&Id="+loqateBean.Id;
		JSONObject jsonResponse = readJsonFromUrl(url);
		return jsonResponse;
	}
	
		
	}
	


