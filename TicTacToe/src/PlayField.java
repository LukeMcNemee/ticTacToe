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

    public int getSize() {
        return size;
    }

    public PlayField() {
        field = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                field[j][i] = '_';
            }
        }
        currentSymbol = 'X';
    }

    public char getCurrentSymbol() {
        return currentSymbol;
    }

    public int play(int x, int y) {
        if (x < 0 || x >= size) {
            return 1;
        }
        if (y < 0 || y >= size) {
            return 1;
        }
        if (field[x][y] == '_') {
            field[x][y] = currentSymbol;
            switchSymbol();
            count ++;
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
    
    public char matchEnd(){
        if(count == size*size){
            return 'D';
        }
        return '_';
    }
}
