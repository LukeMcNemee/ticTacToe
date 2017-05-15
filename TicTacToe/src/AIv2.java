/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lukemcnemee
 */
public class AIv2 implements AI {

    private PlayField p;

    private void checkAndPlay(int x1, int y1, int x2, int y2, int x3, int y3) {
        if (check(p.getPosition(x1, y1), p.getPosition(x2, y2), p.getPosition(x3, y3))) {
            if (p.getPosition(x1, y1) == '_') {
                p.play(x1, y1);
            }
            if (p.getPosition(x2, y2) == '_') {
                p.play(x2, y2);
            }
            if (p.getPosition(x3, y3) == '_') {
                p.play(x3, y3);
            }
        }
    }

    //XX_
    //X_X
    //_XX
    private boolean check(char a, char b, char c) {
        if ((a == '_' && b == '_') || (b == '_' && c == '_')
                || (a == '_' && c == '_')) {
            return false;
        }
        if (a == b && c == '_') {
            return true;
        } else if (a == c && b == '_') {
            return true;
        } else if (b == c && a == '_') {
            return true;
        }
        return false;
    }

    @Override
    public void move() {
        //I.
        if (p.getPosition(1, 1) == '_') {
            p.play(1, 1);
            return;
        }

        //II.
        checkAndPlay(0, 0, 1, 1, 2, 2);
        checkAndPlay(2, 0, 1, 1, 0, 2);

        for (int i = 0; i < p.getSize(); i++) {
            checkAndPlay(i, 0, i, 1, i, 2);
            checkAndPlay(0, i, 1, i, 2, i);
        }
        
        //IV random
        for(int i = 0; i < p.getSize(); i++){
            for(int j = 0; j < p.getSize(); j++){
                if(p.getPosition(j, i) == '_'){
                    p.play(j, i);
                    return;
                }
            }
        }
    }

    @Override
    public void setPlayfield(PlayField field) {
        p = field;
    }

}
