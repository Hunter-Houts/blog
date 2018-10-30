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
    private final PostService postService;
    public PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping("/posts")
    public String posts(Model model){
        model.addAttribute("posts",postService.findAll());
        return "posts/index";
    }
    @GetMapping("/posts/{id}")
    public String individualPost(@PathVariable String id, Model model){
        model.addAttribute("Post",postService.findOne(Integer.parseInt(id)));
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
