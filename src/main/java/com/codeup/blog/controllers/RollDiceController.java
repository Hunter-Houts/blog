package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RollDiceController {
    @GetMapping("/roll-dice")
    public String rollDice(){
        return "roll-dice";
    }
    @GetMapping("/roll-dice/{n}")
    public String Guess(@PathVariable int n, Model model){
        int randomNum = (int) Math.floor(Math.random() * 6) + 1;
        model.addAttribute("n",n);
        model.addAttribute("randomNum",randomNum);
        return "roll-diceGuess";
    }

}
