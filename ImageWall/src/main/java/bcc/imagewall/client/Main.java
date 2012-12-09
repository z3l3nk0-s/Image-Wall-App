package bcc.imagewall.client;

import bcc.imagewall.domain.Tag;

public class Main {

	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		TagClient tagClient = new TagClient();
		
		Tag tag = new Tag();
		tag.setGeoLatitude(53.21212);
		tag.setGeoLongitude(34.232323);
		tag.setName("tag1");
		 tagClient.tagPost(tag);
		
	}

}
