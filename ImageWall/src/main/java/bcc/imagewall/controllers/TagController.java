package bcc.imagewall.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import bcc.imagewall.domain.Image;
import bcc.imagewall.domain.Tag;
import bcc.imagewall.repository.ImageRepostiory;
import bcc.imagewall.repository.TagRepository;

@Controller
@RequestMapping(value = {"/", "tag"})
public class TagController {

	@Autowired
	TagRepository tagRepo;
	@Autowired
	ImageRepostiory imageRepo;

	@RequestMapping(value = {"/", "home"}, method = RequestMethod.GET)
	public String getTags(Model model) {
		List<Tag> tags = (List<Tag>) tagRepo.findAll();
		model.addAttribute("tags", tags);
		return "home";
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody
	Tag postTag(@RequestBody Tag tag) {

		return tagRepo.save(tag);
	}

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String getPicturesFromTag(@PathVariable String name, Model model) {

		PageRequest pageR = new PageRequest(0, 5);
		Tag hashTag = tagRepo.getTagByName(name);
		List<Image> images = imageRepo.findByTag(hashTag, pageR);

		model.addAttribute("images", images);
		model.addAttribute("hashTag", hashTag);
		return "listImages";
	}

}
