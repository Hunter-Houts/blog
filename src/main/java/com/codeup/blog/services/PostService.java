package com.codeup.blog.services;

import com.codeup.blog.models.Post;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    private PostRepository postsDao;

    public PostService(PostRepository postsDao) {
        this.postsDao = postsDao;
    }

    public Iterable<Post> findAll() {
        return postsDao.findAll();
    }

    public Post save(Post post) {
        return postsDao.save(post);

    }

    public Post findOne(long id) {
        return postsDao.findOne(id);
    }
    public Post edit(Post post){
        return postsDao.save(post);
    }
    public void delete(Post post){
        postsDao.delete(post);
    }
}

