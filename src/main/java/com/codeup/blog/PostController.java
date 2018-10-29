package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {
    @GetMapping("/posts")
    @ResponseBody
    public String posts(){
        return "Here are all the posts";
    }
    @GetMapping("/posts/{id}")
    @ResponseBody
    public String individualPost(@PathVariable int id){
        return "Here is the post with id number: " + id;
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
