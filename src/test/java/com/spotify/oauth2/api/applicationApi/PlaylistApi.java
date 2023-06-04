package com.spotify.oauth2.api.applicationApi;

import static com.spotify.oauth2.api.SpecBuilder.getRequestSpec;
import static com.spotify.oauth2.api.SpecBuilder.getResponseSpec;
import static io.restassured.RestAssured.given;

import com.spotify.oauth2.api.RestResource;
import com.spotify.oauth2.pojo.Playlist;
import com.spotify.oauth2.utils.ConfigLoader;

import static com.spotify.oauth2.api.TokenManager.*;

import io.restassured.response.Response;

public class PlaylistApi 
{
	//static String access_token = "BQB5wGLXC2VR0hK6lbzDJJZu8gn497_Sh07iw7e9hAuaqeLpnys_DLrvknoG_9MlzaWPuJvfALMSMnfgJwaMCpEjUSckm0Nm3AKvL5ANfd5MIJ_UJXpGJwMoxMxtrTABBr3dIbLv3R7nRjQEcZFcfzZTiyBhSq9JNi-Dy2u2ly8Cm7nZuUrAGeJjCMhdKECxaWwaQdj--fuE39CJYwVl1KD91PCGSMl-ZOFZIY02kdKzbb5_pSsV0GiGZQzFyOb9poZWE_fCYdEVkkUC";
	public static Response post(Playlist requestPlaylist)
	{
		return RestResource.post("/users/"+ConfigLoader.getInstance().getUserId()+"/playlists", getToken(), requestPlaylist);
	}
	
	public static Response get(String playlistId)
	{
		return RestResource.get("/playlists/" + playlistId, getToken());	
	}
	
	public static Response update(String playlistId,Playlist requestPlaylist)
	{
		return RestResource.update("/playlists/" + playlistId, getToken(), requestPlaylist);
		
		  
	}

}
