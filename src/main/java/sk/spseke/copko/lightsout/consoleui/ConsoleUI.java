package sk.spseke.copko.lightsout.consoleui;

import sk.spseke.copko.lightsout.core.GameField;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class ConsoleUI {
    private GameField gameField;
    private Scanner scanner;
    private boolean isPlaying;
    private final char decimalSeparator;

    public ConsoleUI(GameField gameField) {
        this.gameField = gameField;
        this.scanner = new Scanner(System.in);
        this.decimalSeparator = ((DecimalFormat) DecimalFormat.getInstance()).getDecimalFormatSymbols().getDecimalSeparator();
    }

    public void play() {
        isPlaying = true;
        while (!gameField.isSolved() && this.isPlaying) {
            renderField();
            processInput();
        }
        renderField();
    }

    private void processInput() {

        System.out.print("Zadaj prikaz: ");
        String[] input = scanner.nextLine().trim().toLowerCase().split(String.valueOf(this.decimalSeparator));
        System.out.printf("Zadal si %d vstupov: %s\n", input.length, input[0]);
        if (Objects.equals(input[0], "koniec")) {
            this.isPlaying = false;
        } else {
            if (input.length == 2) {
                var row = Integer.parseInt(input[0]);
                var column = Integer.parseInt(input[1]);
                if (row < 0 || row >= gameField.getRowCount()) {
                    System.out.println("Nesprávny parameter riadku");
                    return;
                }
                if (column < 0 || column >= gameField.getColumnCount()) {
                    System.out.println("Nesprávny parameter stĺpca");
                    return;
                }
                gameField.toggleLights(row, column);
            } else {
                System.out.println("Nesprávny formát vstupu.");
                return;
            }
        }
    }

    private void renderField() {
        //System.out.println(gameField.isSolved());

        System.out.print("   ");
        for (var column = 0; column < gameField.getColumnCount(); column++) {
            System.out.print(column + "  ");
        }
        System.out.println();

        for (var row = 0; row < gameField.getRowCount(); row++) {
            System.out.print(row + " ");
            for (var column = 0; column < gameField.getColumnCount(); column++) {
                var light = gameField.getLight(row, column);
                System.out.print(light.isOn() ? "📀 " : "💿 ");
            }
            System.out.println();
        }

    }
}
