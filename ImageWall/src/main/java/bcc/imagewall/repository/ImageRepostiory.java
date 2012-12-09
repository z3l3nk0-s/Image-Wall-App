package bcc.imagewall.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import bcc.imagewall.domain.Tag;
import bcc.imagewall.domain.Image;

public interface ImageRepostiory extends CrudRepository<Image, Long> {
	
	List<Image> findByTag(Tag tag, Pageable page);

}
