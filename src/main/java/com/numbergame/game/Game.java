package com.numbergame.game;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Game extends Generator {
	
    private int generatedNumber;
    private String response;
    private int counter;

    @GetMapping(path = "/game")
    public String game(Model model){
        Home home = new Home();
        String boundText = "Guess the number from 1 to "+ home.getPlayerBound();
        if (home.startTheGame == 0){
        	home.startTheGame = 1;
           generatedNumber = generate(home.getPlayerBound());
           counter = 0;
        }
        int limit = home.getLimitOfTries() - counter;
        String limitText = "You have "+limit+" tries";
        model.addAttribute("limitText", limitText);        
        model.addAttribute("generatedNumber",generatedNumber);
        model.addAttribute("boundText", boundText);
        model.addAttribute("response", response);
        if (limit<=0) {
        	return "lose";
        }
        return "game";
    }
    @PostMapping(path = "/game")
    public String response(@RequestParam String playerNumber, @RequestParam String generatedNumber, Model model){
        Home home = new Home();
        model.addAttribute("number",generatedNumber);
      
        int playerNumberToInt = Integer.parseInt(playerNumber);
        int generatedNumberToInt = Integer.parseInt(generatedNumber);
        if (playerNumberToInt == generatedNumberToInt){
            counter = 0;
            return "win";
        } else if (playerNumberToInt > generatedNumberToInt){
            counter ++;
            response = "Your number is to high";
        } else if (playerNumberToInt < generatedNumberToInt){
            counter ++;
            response = "Your number is to low";
        }
        
        return "redirect:game";}
}
