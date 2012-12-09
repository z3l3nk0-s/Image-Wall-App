package bcc.imagewall.repository;

import org.springframework.data.repository.CrudRepository;

import bcc.imagewall.domain.Tag;

public interface TagRepository extends CrudRepository<Tag, Long> {

	Tag getTagByName(String name);
	
}
