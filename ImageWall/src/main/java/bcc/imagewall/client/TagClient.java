package bcc.imagewall.client;

import org.springframework.web.client.RestTemplate;

import bcc.imagewall.domain.Tag;

public class TagClient {

	String BASE_URL = "http://localhost:8080/ImageWall/tag";

	public Tag tagPost(Tag tag){
		RestTemplate template = new RestTemplate();
		return template.postForObject(BASE_URL, tag, Tag.class);
	}
	
}
