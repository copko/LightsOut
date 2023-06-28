package sk.spseke.copko.lightsout;

import sk.spseke.copko.lightsout.consoleui.ConsoleUI;
import sk.spseke.copko.lightsout.core.GameField;

public class Main {
    public static void main(String[] args) {
        var gameField = new GameField(6, 6, 2);
        ConsoleUI game = new ConsoleUI(gameField);

        game.play();

    }
}
