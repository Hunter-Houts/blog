package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RollDiceController {
    int randomNum;
    @GetMapping("/roll-dice")
    public String rollDice(){
        this.randomNum = (int) Math.floor(Math.random() * 6) + 1;
        return "roll-dice";
    }
    @GetMapping("/roll-dice/{n}")
    public String Guess(@PathVariable int n, Model model){
        model.addAttribute("n",n);
        model.addAttribute("randomNum",randomNum);
        return "roll-diceGuess";
    }

}
