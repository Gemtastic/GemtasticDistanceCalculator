package com.gemtastic.GemtasticDistanceCalculator;

/**
 * This is the logic class for distance calculations.
 *
 * Created by Gemtastic on 2015-04-18.
 */
public class Calculations {

    // These are magic numbers the mathematicians made up for our formulas
    private final int kmToM = 36;
    private final int reactionTime = 10;
    private final int magicEquationNumber = 2500;
    private final int ten = 10;


    /**
     * Calculates the distance you go ona a slippery road before you come to a full stop
     * from the point where you detect that you need to slam the breaks.
     *
     * @param speed
     * @return
     */
    public int slippery(int speed){
        int result = 0;
        int friction = 3;
        int calcSpeed = speed * ten;

        int reactionDistance = ((calcSpeed * reactionTime)/ kmToM)/ten;
        int breakingDistance = (calcSpeed * calcSpeed)/(magicEquationNumber * friction);

        result = (reactionDistance + breakingDistance);

        return result;
    }

    /**
     * Calculates the distance you go on a dry road before you come to a full stop
     * from the point where you detect that you need to slam the breaks.
     *
     * @param speed
     * @return
     */
    public int dry(int speed){
        int result = 0;
        int friction = 8;

        int calcSpeed = speed * ten;

        int reactionDistance = ((calcSpeed * reactionTime)/ kmToM)/ten;
        int breakingDistance = (calcSpeed * calcSpeed)/(magicEquationNumber * friction);

        result = (reactionDistance + breakingDistance);

        return result;
    }

    /**
     * This calculates how far you go before coming to a full stop on
     * a dry road when you are tired.
     *
     * This method is to be implemented in the application.
     *
     * @param speed
     * @return
     */
    public int tired(int speed){
        int result = 0;
        int friction = 8;
        int tiredReaction = 35;

        int calcSpeed = speed * ten;

        int reactionDistance = ((calcSpeed * tiredReaction)/ kmToM)/ten;
        int breakingDistance = (calcSpeed * calcSpeed)/(magicEquationNumber * friction);

        result = (reactionDistance + breakingDistance);

        return result;
    }

    /**
     * Calculates the distance you travel during 3 seconds.
     *
     * @param speed
     * @return
     */
    public int howFarYouGo(int speed){
        int result = 0;
        int calcSpeed = speed * ten;

        int secondsTimesTen = 30;
        int distance = (calcSpeed * secondsTimesTen)/kmToM;

        result = distance/ten;

        return result;
    }
}
