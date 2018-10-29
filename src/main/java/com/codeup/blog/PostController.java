package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    @GetMapping("/posts")
    public String posts(Model model){
        List<Post> posts = new ArrayList<>();
        posts.add(new Post("First Post","This is my first post"));
        posts.add(new Post("Second Post","This is my second post"));
        model.addAttribute("posts",posts);
        return "posts/index";
    }
    @GetMapping("/posts/{id}")
    public String individualPost(@PathVariable int id, Model model){
        Post post = new Post("Individual Post","this is an individual post");
        model.addAttribute("Post",post);
        return "posts/show";
    }
    @GetMapping("/posts/create")
    @ResponseBody
    public String createPostIndex(){
        return "Create a post here!";
    }
    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost(){
        return "Post created!";
    }
}
