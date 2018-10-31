package com.codeup.blog.controllers;

import com.codeup.blog.Post;
import com.codeup.blog.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String createPostIndex(Model model){
        model.addAttribute("post",new Post());
        return "posts/create";
    }
    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post){
        postService.save(post);
        return "redirect:/posts";
    }
    @GetMapping("/posts/{id}/edit")
    public String editPost(@PathVariable String id, Model model){
        model.addAttribute("post",postService.findOne(Integer.parseInt(id)));
        return "posts/edit";
    }
    @PostMapping("/posts/{id}/edit")
    public String submitEdit(@PathVariable String id, Model model){
        model.addAttribute("post",postService.findOne(Integer.parseInt(id)));
        return "redirect:/posts";
    }
}
