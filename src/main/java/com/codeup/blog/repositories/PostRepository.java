package com.codeup.blog.repositories;

import com.codeup.blog.models.Post;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;


@Repository
public interface PostRepository extends CrudRepository<Post,Long> {
}
