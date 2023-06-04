package com.spotify.oauth2.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static com.spotify.oauth2.api.TokenManager.*;

public class SpecBuilder 
{
	//static String access_token = "BQB5wGLXC2VR0hK6lbzDJJZu8gn497_Sh07iw7e9hAuaqeLpnys_DLrvknoG_9MlzaWPuJvfALMSMnfgJwaMCpEjUSckm0Nm3AKvL5ANfd5MIJ_UJXpGJwMoxMxtrTABBr3dIbLv3R7nRjQEcZFcfzZTiyBhSq9JNi-Dy2u2ly8Cm7nZuUrAGeJjCMhdKECxaWwaQdj--fuE39CJYwVl1KD91PCGSMl-ZOFZIY02kdKzbb5_pSsV0GiGZQzFyOb9poZWE_fCYdEVkkUC";
   public static RequestSpecification getRequestSpec()
   {
	   return new RequestSpecBuilder().
				setBaseUri("https://api.spotify.com").
				setBasePath("/v1").
				addHeader("Authorization","Bearer " + getToken()).
				setContentType(ContentType.JSON).
				log(LogDetail.ALL).build();
		
		
   }
   
   public static RequestSpecification getAccountRequestSpec()
   {
	   return new RequestSpecBuilder().
			   setBaseUri("https://accounts.spotify.com").
			   setContentType(ContentType.URLENC).log(LogDetail.ALL).build();
   }
   
   public static ResponseSpecification getResponseSpec()
   {
	   return new ResponseSpecBuilder().
				
				log(LogDetail.ALL).build();
		
   }
}
