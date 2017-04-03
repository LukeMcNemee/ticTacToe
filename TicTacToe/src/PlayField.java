/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lukemcnemee
 */
public class PlayField {

    private final int size = 3;
    private char currentSymbol;
    private char[][] field;
    private int count = 0;
    private boolean played;

    public int getSize() {
        return size;
    }

    public boolean isPlayed() {
        return played;
    }

    public PlayField() {
        field = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                field[j][i] = '_';
            }
        }
        currentSymbol = 'X';
        played = false;
    }

    public char getCurrentSymbol() {
        return currentSymbol;
    }

    public void next(){
        played = false;
    }
    
    public int play(int x, int y) {
        if(played){
            return 1;
        }
        if (x < 0 || x >= size) {
            return 1;
        }
        if (y < 0 || y >= size) {
            return 1;
        }
        if (field[x][y] == '_') {
            field[x][y] = currentSymbol;
            switchSymbol();
            count++;
            return 0;
        } else {

        }
        return 1;
    }

    private void switchSymbol() {
        if (currentSymbol == 'X') {
            currentSymbol = 'O';
        } else {
            currentSymbol = 'X';
        }
        played = true;
    }

    public char getPosition(int x, int y) {
        return field[x][y];
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print("===");
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("[" + field[j][i] + "]");
            }
            System.out.println();
        }
    }

    public char matchEnd() {
        

        for (int i = 0; i < size; i++) {
            if (field[i][0] == field[i][1] && field[i][0] == field[i][2] && field[i][0] != '_') {
                return field[i][0];
            }
            if (field[0][i] == field[1][i] && field[0][i] == field[2][i] && field[0][i] != '_') {
                return field[i][0];
            }
        }
        if (field[0][0] == field[1][1] && field[0][0] == field[2][2] && field[0][0] != '_') {
            return field[0][0];
        }
        if (field[2][0] == field[1][1] && field[2][0] == field[0][2] && field[2][0] != '_') {
            return field[2][0];
        }

        if (count == size * size) {
            return 'D';
        }
        
        return '_';
    }
}
