package bcc.imagewall.client;

import org.springframework.web.client.RestTemplate;

import bcc.imagewall.controllers.ImageUploadData;
import bcc.imagewall.domain.Image;


public class ImageClient {
	
	String BASE_URL = "http://localhost:8080/ImageWall/image";

	public Image imagePost(ImageUploadData imageData){
		RestTemplate template = new RestTemplate();
		return template.postForObject(BASE_URL, imageData, Image.class);
	}
}
