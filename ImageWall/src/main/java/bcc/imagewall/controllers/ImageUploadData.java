package bcc.imagewall.controllers;

import org.springframework.web.multipart.MultipartFile;

public class ImageUploadData {

	String tag;
	Double geoLongitude;
	Double geoLatitude;
	MultipartFile image;

	public ImageUploadData() {
	}
	
	public ImageUploadData(String tag, Double geoLongitude,
			Double geoLatitude, MultipartFile image) {
		this.tag = tag;
		this.geoLongitude = geoLongitude;
		this.geoLatitude = geoLatitude;
		this.image = image;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Double getGeoLongitude() {
		return geoLongitude;
	}

	public void setGeoLongitude(Double geoLongitude) {
		this.geoLongitude = geoLongitude;
	}

	public Double getGeoLatitude() {
		return geoLatitude;
	}

	public void setGeoLatitude(Double geoLatitude) {
		this.geoLatitude = geoLatitude;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

}
