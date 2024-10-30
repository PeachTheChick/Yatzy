package models;

/**
 * Used to calculate the score of throws with 5 dice
 */
public class YatzyResultCalculator {
    private Die[] dice;
    private int[] countRolled = new int[6];

    /**
     * @param dice
     */
    public YatzyResultCalculator(Die[] dice) {
        //TODO: implement YatzyResultCalculator constructor.
        this.dice = dice;
        for (Die die : dice) {
            countRolled[die.getEyes() - 1]++;

        }
    }

    /**
     * Calculates the score for Yatzy uppersection
     *
     * @param eyes eye value to calculate score for. eyes should be between 1 and 6
     * @return the score for specified eye value
     */
    public int upperSectionScore(int eyes) {
        //TODO: Implement upperSectionScore method.
        return countRolled[eyes - 1] * eyes;
    }

    public int onePairScore() {
        //TODO: implement onePairScore method.
        for (int i = 5; i >= 0; i--) {
            if (countRolled[i] >= 2) {
                return (i + 1) * 2;
            }
        }
        return 0;
    }

    public int twoPairScore() {
        //TODO: implement twoPairScore method.
        for (int i = 5; i >= 0; i--) {
            if (countRolled[i] >= 2) {
                for (int u = 5; u >= 0; u--)
                    if (countRolled[u] >= 2) {
                        if (u != i)
                            return (u + 1) * 2 + (i + 1) * 2;
                    }
            }
        }
        return 0;
    }

    public int threeOfAKindScore() {
        //TODO: implement threeOfAKindScore method.
        for (int i = 5; i >= 0; i--) {
            if (countRolled[i] >= 3) {
                return (i + 1) * 3;
            }

        }

        return 0;
    }

    public int fourOfAKindScore() {
        //TODO: implement fourOfAKindScore method.
        for (int i = 5; i >= 0; i--) {
            if (countRolled[i] >= 4) {
                return (i + 1) * 4;
            }

        }
        return 0;
    }

    public int smallStraightScore() {
        //TODO: implement smallStraightScore method.
        for (int i = 0; i <= 4; i++)
            if (countRolled[i] != 1) {
                return 0;
            }
        return 15;
    }

    public int largeStraightScore() {
        //TODO: implement largeStraightScore method.
        for (int i = 1; i <= 5; i++)
            if (countRolled[i] != 1) {
                return 0;
            }

        return 20;

    }


    public int fullHouseScore() {
        //TODO: implement fullHouseScore method.
        for (int i = 5; i >= 0; i--) {
            if (countRolled[i] >= 3) {
                for (int u = 5; u >= 0; u--)
                    if (countRolled[u] >= 2) {
                        if (u != i)
                            return (u + 1) * 2 + (i + 1) * 3;
                    }
            }
        }
        return 0;
    }

    public int chanceScore() {
        //TODO: implement chanceScore method.

        return (countRolled[0] * 1) + (countRolled[1] * 2) + (countRolled[2] * 3) + (countRolled[3] * 4) + (countRolled[4] * 5) + (countRolled[5] * 6);
    }

    public int yatzyScore() {
        //TODO: implement yatzyScore method.
        for (int i = 5; i >= 0; i--) {
            if (countRolled[i] >= 5) {
                return 50;
            }

        }
        return 0;
    }
}
