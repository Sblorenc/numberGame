package com.numbergame.game;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Home{
    public static int playerBound;
    public static int limitOfTries;
    public static int startTheGame;
    
    
    

    public int getLimitOfTries() {
        return limitOfTries;
    }


    public int getPlayerBound() {
        return playerBound;
    }





    @GetMapping(path = "/home")
    public String home(){
    	startTheGame = 0;
    	
        return "home";
    }
    @PostMapping(path = "home")
    public String home(@RequestParam String bound, @RequestParam String limit){
    	
        limitOfTries = Integer.parseInt(limit);
         playerBound = Integer.parseInt(bound);
        return "redirect:game";
    }
}
