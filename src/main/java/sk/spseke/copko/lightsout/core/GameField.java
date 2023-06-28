package sk.spseke.copko.lightsout.core;

import java.util.Random;

public class GameField {
    private int rowCount;
    private int columnCount;

    private boolean playing;

    private Light[][] lights;

    public GameField(int rowCount, int columnCount, int difficulty) {
        this.rowCount = rowCount;
        this.columnCount = columnCount;
        this.lights = new Light[rowCount][columnCount];
        generate(difficulty);
    }

    private void generate(int moves){
        for (var row = 0; row<rowCount; row++){
            for (var column = 0; column<columnCount; column++){
                lights[row][column] = new Light();
            }
        }

        Random random = new Random();

        for (var move = 0; move<moves;move++){
            var row = random.nextInt(rowCount);
            var column = random.nextInt(columnCount);
            toggleLights(row,column);
        }
    }

    public void toggleLights(int row, int column) {
        this.lights[row][column].toggle();
        if (row>0)
            this.lights[row-1][column].toggle();
        if (row<this.rowCount-1)
            this.lights[row+1][column].toggle();
        if (column>0)
            this.lights[row][column-1].toggle();
        if (column<this.columnCount-1)
            lights[row][column+1].toggle();
    }

    public boolean isSolved() {
        for (var row=0; row<this.columnCount; row++){
            for (var column=0; column<this.columnCount;column++){
                if(lights[row][column].isOn())
                    return false;
            }
        }
        return true;
    }

    public int getColumnCount() {
        return this.columnCount;
    }

    public int getRowCount() {
        return this.rowCount;
    }

    public Light getLight(int row, int column) {
        return this.lights[row][column];
    }
}
