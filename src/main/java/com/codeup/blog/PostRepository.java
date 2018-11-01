package com.codeup.blog;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;


@Repository
public interface PostRepository extends CrudRepository<Post,Long> {
}
