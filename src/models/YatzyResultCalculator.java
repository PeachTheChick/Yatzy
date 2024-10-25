package models;

/**
 * Used to calculate the score of throws with 5 dice
 */
public class YatzyResultCalculator {
    private Die[] dice;
    private int[] countRolled = new int[6];

    /**
     *
     * @param dice
     */
    public YatzyResultCalculator(Die[] dice) {
        //TODO: implement YatzyResultCalculator constructor.
        this.dice=dice;
        for (Die die : dice) {
            countRolled[die.getEyes()-1] ++;

        }
    }

    /**
     * Calculates the score for Yatzy uppersection
     * @param eyes eye value to calculate score for. eyes should be between 1 and 6
     * @return the score for specified eye value
     */
    public int upperSectionScore(int eyes) {
        //TODO: Implement upperSectionScore method.
        return countRolled[eyes-1]*eyes;
    }

    public int onePairScore() {
        //TODO: implement onePairScore method.
        for (int i = 5; i >= 0; i--) {
            if (countRolled[i] >= 2) {
                return (i+1)*2;
            }
        }
        return 0;
    }

    public int twoPairScore() {
        //TODO: implement twoPairScore method.
        return 0;
    }

    public int threeOfAKindScore() {
        //TODO: implement threeOfAKindScore method.
        return 0;
    }

    public int fourOfAKindScore() {
        //TODO: implement fourOfAKindScore method.
        return 0;
    }

    public int smallStraightScore() {
        //TODO: implement smallStraightScore method.
        return 0;
    }

    public int largeStraightScore() {
        //TODO: implement largeStraightScore method.
        return 0;
    }

    public int fullHouseScore() {
        //TODO: implement fullHouseScore method.
        return 0;
    }

    public int chanceScore() {
        //TODO: implement chanceScore method.
        return 0;
    }

    public int yatzyScore() {
        //TODO: implement yatzyScore method.
        return 0;
    }
}
