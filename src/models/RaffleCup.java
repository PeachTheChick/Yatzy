package models;

import gui.YatzyGui;

public class RaffleCup {
    private  YatzyGui[] yatzyGui = new YatzyGui[5];
    private Die[] dice = new Die[5];

    public RaffleCup() {
        for (int i = 0; i < dice.length; i++) {
            dice[i] = new Die();
        }
    }

    public void throwDice() {
        for (Die die : dice) {
                die.roll();
        }

    }

    public Die[] getDice() {
        return dice;
    }
    public void switchDice(int index){
        dice[index].switchHold();
    }
    public void unHoldDice(int index){
        dice[index].unhold();
    }
}
