package com.numbergame.game;
import java.util.Random;

public class Generator {
 public int generate(int bound){
     Random random = new Random();
     int generatedNumber = random.nextInt(bound);
 return generatedNumber;}
}
