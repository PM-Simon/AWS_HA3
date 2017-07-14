package de.tub.ise.anwsys.clients;

import java.io.IOException;

import org.json.JSONArray;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class TestClient {

	public static void main(String[] args) throws IOException, UnirestException {
		
		HttpResponse<JsonNode> responseMeters = Unirest.get("http://localhost:7878/meters").asJson();
		JSONArray a = responseMeters.getBody().getObject().getJSONArray("meters");
		String meter1 = (String) a.get(0);
		String meter2 = (String) a.get(1);
		String meter3 = (String) a.get(2);
		HttpResponse<JsonNode> data = Unirest.get("http://localhost:7878/meters/"+meter1+"/data").asJson();
		String metriken1 = data.getBody().getObject().getJSONArray("measurements").toString();
		HttpResponse<JsonNode> data2 = Unirest.get("http://localhost:7878/meters/"+meter2+"/data").asJson();
		String metriken2 = data2.getBody().getObject().getJSONArray("measurements").toString();
		HttpResponse<JsonNode> data3 = Unirest.get("http://localhost:7878/meters/"+meter2+"/data").asJson();
		String metriken3 = data3.getBody().getObject().getJSONArray("measurements").toString();	
		
		for(int i=0;i<=1000;i++){
		Unirest.post("http://localhost:8080/smartMeter").queryString(meter1, metriken1)
		.field(meter2, metriken2)
		.field(meter3, metriken3)
		.asJson();
		}
		
	}
}
