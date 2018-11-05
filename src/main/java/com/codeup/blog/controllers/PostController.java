package com.codeup.blog.controllers;

import com.codeup.blog.models.Post;
import com.codeup.blog.models.User;
import com.codeup.blog.repositories.UserRepository;
import com.codeup.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(userDao.findOne(loggedInUser.getId()));
        postService.save(post);
        return "redirect:/posts";
    }
    @GetMapping("/posts/{id}/edit")
    public String editPost(@PathVariable long id, Model model){ ;
        if(postService.findOne(id) != null) {
            model.addAttribute("post", postService.findOne(id));
            return "posts/edit";
        } else {
            return "redirect:/";
        }
    }
    @PostMapping("/posts/{id}/edit")
    public String submitEdit(@ModelAttribute Post post, @PathVariable long id) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (postService.findOne(id).getUser().getId() == loggedInUser.getId()) {
            post.setUser(userDao.findByUsername(loggedInUser.getUsername()));
            postService.edit(post);
            return "redirect:/posts";
        } else {
            return "redirect:/";
        }
    }
    @PostMapping("/posts/{id}/delete")
    public String deletePost(@ModelAttribute Post post){
        postService.delete(post);
        return "redirect:/posts";

    }
}
