package bcc.imagewall.controllers;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.coobird.thumbnailator.Thumbnails;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import bcc.imagewall.domain.Image;
import bcc.imagewall.repository.TagRepository;
import bcc.imagewall.repository.ImageRepostiory;

@Controller
@RequestMapping("image")
public class ImageController {

	// ovaj dio bi mozda trebao ici u servisni dio, ali posto nikakva dodatna
	// sigurnost nije potrebna
	// onda je to stavljeno ovdje.. ali da je bilo i sgurnosnih/validacijsih
	// zahzjeva, postavili
	// bi ova sučelja u servisni sloj i onda pozivali samo servise
	@Autowired
	TagRepository tagRepo;
	@Autowired
	ImageRepostiory imageRepo;
	@Autowired
	HttpSession session;

	private static final Logger log = Logger.getLogger(ImageController.class);
	String resourcePath = "D:/ImageWall/images/";
	String imageUrl = "";
	String thumbnailUrl = "";

	@RequestMapping(method = RequestMethod.POST)
	public String postImage(ImageUploadData imageData, Model model) {
		
		//spremanje slike i postavljanje image i thumbnail URL-ova
		saveImage(imageData.getTag(), imageData.getImage());

		Image imageToSave = new Image();
		imageToSave.setTag(tagRepo.getTagByName(imageData.getTag()));
		imageToSave.setImageUrl(imageUrl);
		imageToSave.setFullImageUrl(resourcePath + imageUrl);
		imageToSave.setThumbnailUrl(resourcePath + thumbnailUrl);
		imageToSave.setAddedDate(new Date());
		Image imageSaved = imageRepo.save(imageToSave);
		model.addAttribute("imageId", imageSaved.getId());
		return "afterPost";

	}

	@RequestMapping(method = RequestMethod.GET)
	public String getForm(Model model) {
		ImageUploadData data = new ImageUploadData();
		model.addAttribute("data", data);

		return "indexForm";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getImagePage(@PathVariable Long id, Model model) {
		model.addAttribute("id", id);
		return "image";
	}

	@RequestMapping(value = "/getthumbnail/{id}", method = RequestMethod.GET, produces = "image/jpeg")
	public void getThumbnail(@PathVariable Long id, HttpServletResponse response) {
		try {
			Image image = imageRepo.findOne(id);
			File file = new File(image.getThumbnailUrl());
			response.getOutputStream().write(FileUtils.readFileToByteArray(file));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping(value = "/getimage/{id}", method = RequestMethod.GET, produces = "image/jpeg")
	public void getImage(@PathVariable Long id, HttpServletResponse response) {
		try {
			Image image = imageRepo.findOne(id);
			File file = new File(image.getFullImageUrl());
			response.getOutputStream().write(FileUtils.readFileToByteArray(file));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void saveImage(String tag, MultipartFile image) {
		imageUrl = tag + getRandom() + ".jpg";
		thumbnailUrl = tag + getRandom() + "thumbnail" + ".jpg";

		try {
			File file = new File(resourcePath + imageUrl);
			FileUtils.writeByteArrayToFile(file, image.getBytes());
			
			Thumbnails.of(resourcePath + imageUrl)
			.size(100, 100)
			.toFile(resourcePath + thumbnailUrl);
		} catch (IOException e) {
			log.debug(e.getStackTrace());
		}


	}

	private String getRandom() {
		SecureRandom random = new SecureRandom();
		return new BigInteger(130, random).toString(32);
	}

}
