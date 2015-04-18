package com.gemtastic.GemtasticDistanceCalculator;

/**
 * Created by Gemtastic on 2015-04-18.
 */
public class Calculations {

    // These are magic numbers the mathematicians made up for our formulas
    private final int kmToM = 36;
    private final int reactionTime = 10;
    private final int magicEquationNumber = 2500;
    private final int ten = 10;


    public int slippery(int speed){
        int result = 0;
        int friction = 3;
        int calcSpeed = speed * ten;

        int reactionDistance = ((calcSpeed * reactionTime)/ kmToM)/ten;
        int breakingDistance = (calcSpeed * calcSpeed)/(magicEquationNumber * friction);

        result = (reactionDistance + breakingDistance);

        return result;
    }

    public int dry(int speed){
        int result = 0;
        int friction = 8;

        int calcSpeed = speed * ten;

        int reactionDistance = ((calcSpeed * reactionTime)/ kmToM)/ten;
        int breakingDistance = (calcSpeed * calcSpeed)/(magicEquationNumber * friction);

        System.out.println(reactionDistance);
        System.out.println(breakingDistance);

        result = (reactionDistance + breakingDistance);

        return result;
    }

    public int tired(int speed){
        int result = 0;
        int friction = 8;
        int tiredReaction = 35;

        int calcSpeed = speed * ten;

        int reactionDistance = ((calcSpeed * tiredReaction)/ kmToM);
        int breakingDistance = (calcSpeed * calcSpeed)/(magicEquationNumber * friction);

        result = (reactionDistance + breakingDistance);

        return result;
    }

    public int howFarYouGo(int speed){
        int result = 0;
        int calcSpeed = speed * ten;

        int secondsTimesTen = 30;
        int distance = (calcSpeed * secondsTimesTen)/kmToM;

        result = distance/ten;

        return result;
    }
}
