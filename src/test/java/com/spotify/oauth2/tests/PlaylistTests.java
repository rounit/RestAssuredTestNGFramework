package com.spotify.oauth2.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.spotify.oauth2.api.applicationApi.PlaylistApi;
import com.spotify.oauth2.pojo.Playlist;
import com.spotify.oauth2.utils.DataLoader;

import io.qameta.allure.Description;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static org.hamcrest.MatcherAssert.*;
import static com.spotify.oauth2.api.SpecBuilder.*;
import static com.spotify.oauth2.utils.FakerUtils.*;
public class PlaylistTests 
{
	RequestSpecification reqSpecification;
	ResponseSpecification resSpecification;
	
	public Playlist playlistBuilder(String name,String description,boolean _public)
	{
		Playlist playlist = new Playlist();
		playlist.setName(name);
		playlist.setDescription(description);
		playlist.set_public(_public);
		return playlist;
	}
	
	@Description("This is the description")
	@Test(description = "should be able to create a  playlist")
	public void ShouldBeAbleToCreateAPIPlaylist()
	{
		Playlist requestPlaylist = playlistBuilder(generateName(), generateDescription(),false);
		
		Response response = PlaylistApi.post(requestPlaylist);
		assertThat(response.statusCode(),equalTo(201));
		
		Playlist responsePlaylist = response.as(Playlist.class);
		 
		  assertThat(responsePlaylist.getName(), equalTo(responsePlaylist.getName()));
		  assertThat(responsePlaylist.getDescription(), equalTo(responsePlaylist.getDescription()));
	}
	
	@Test
	public void ShouldBeAbleTogetAPIPlaylist()
	{
		Playlist requestPlaylist = playlistBuilder("New Playlist","New Playlist Description",false);
		
		Response response = PlaylistApi.get(DataLoader.getInstance().getGetPlaylistId());
		assertThat(response.statusCode(),equalTo(200));
		
		Playlist responsePlaylist = response.as(Playlist.class);
		 assertThat(responsePlaylist.getName(), equalTo(responsePlaylist.getName()));
		  assertThat(responsePlaylist.getDescription(), equalTo(responsePlaylist.getDescription()));
	}
	
	@Test
	public void ShouldBeAbleToUpdateAPIPlaylist()
	{
		Playlist requestPlaylist = playlistBuilder(generateName(), generateDescription(),false);
		
		Response response = PlaylistApi.update(DataLoader.getInstance().getUpdatePlaylistId(), requestPlaylist);
		assertThat(response.statusCode(),equalTo(200));
		
		
	}
}
