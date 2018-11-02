package com.codeup.blog.controllers;

import com.codeup.blog.models.Post;
import com.codeup.blog.services.PostService;
import com.codeup.blog.services.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {
    private final PostService postService;
    @Autowired
    private UserRepository userDao;
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
        post.setUser(userDao.findOne(1L));
        postService.save(post);
        return "redirect:/posts";
    }
    @GetMapping("/posts/{id}/edit")
    public String editPost(@PathVariable String id, Model model){
        model.addAttribute("post",postService.findOne(Integer.parseInt(id)));
        return "posts/edit";
    }
    @PostMapping("/posts/{id}/edit")
    public String submitEdit(@ModelAttribute Post post){
        postService.edit(post);
        return "redirect:/posts";
    }
    @PostMapping("/posts/{id}/delete")
    public String deletePost(@ModelAttribute Post post){
        postService.delete(post);
        return "redirect:/posts";

    }
}
