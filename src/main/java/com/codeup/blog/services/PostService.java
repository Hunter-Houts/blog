package com.codeup.blog.services;

import com.codeup.blog.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private List<Post> posts;

    public PostService() {
        this.posts = new ArrayList<>();
        createPosts();
    }

    public List<Post> findAll() {
        return posts;
    }

    public Post save(Post post) {
        post.setId(posts.size() + 1);
        posts.add(post);
        return post;
    }

    public Post findOne(long id) {
        return posts.get((int)id - 1);
    }
    public Post edit(Post post){
        posts.set((int) post.getId() -1,post);
        return post;
    }
    public Post delete(Post post){
        if(posts.size() > 1) {
            for (Post p : posts.subList(1, posts.size())) {
                p.setId(p.getId() - 1);
            }
            posts.remove((int) post.getId() - 1);
        } else {
            posts.remove((int) post.getId() - 1);
        }
        return post;
    }
    private void createPosts() {
        save(new Post(1,"first post","This is my first post"));
        save(new Post(2,"Second Post","Second Post for blog"));
        save(new Post(3,"Test Post","Please Ignore"));
    }
}

