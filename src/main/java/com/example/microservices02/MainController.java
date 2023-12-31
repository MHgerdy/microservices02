package com.example.microservices02;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//https://www.baeldung.com/spring-boot-start
//https://stackoverflow.com/questions/64625603/simple-spring-boot-application-not-works

@RestController
@RequestMapping("/api")
public class MainController {
    @Value("${spring.application.name}")
    String appName;

    
    @GetMapping("/test")
    public String getTest() {
    	System.out.println("Get:getTest");
        return "Testing...123";
    }
    
  @GetMapping(path = "/api1", produces=MediaType.APPLICATION_JSON_VALUE)
  public String  getJSONTest()
  {
	  System.out.println("Get:getJSONTest");
	  //List<JSONObject> entities = new ArrayList<JSONObject>();
	  JSONObject entity = new JSONObject();
	  try {
		  entity.put("STA", "123");
		  entity.put("MEL", "456");
		  entity.put("LEI", "789");
		  entity.put("ZVK", "012");
	  } catch (JSONException e) {
		  e.printStackTrace();
	  }
	  //entities.add(entity);
      System.out.println("Get:getJSONTest: "+entity.toString());
	  return entity.toString();
  }	

  @GetMapping(path = "/api2", produces=MediaType.APPLICATION_JSON_VALUE)
  public String  getTime()
  {
	  System.out.println("Get:getTime");

      DateTimeFormatter dtfDate = DateTimeFormatter.ofPattern("dd.MM.yyyy");
      DateTimeFormatter dtfTime = DateTimeFormatter.ofPattern("HH:mm:ss");
      String lAktDate=dtfDate.format(LocalDateTime.now());
      String lAktTime=dtfTime.format(LocalDateTime.now());


      
	  JSONObject entity = new JSONObject();
	  try {
		  entity.put("DATUM", lAktDate);
		  entity.put("ZEIT", lAktTime);
	  } catch (JSONException e) {
		  e.printStackTrace();
	  }
      System.out.println("Get:getTime: "+entity.toString());
	  return entity.toString();
  }	
  
  
}
