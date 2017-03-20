/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lukemcnemee
 */
public class SimpleAI implements AI{
    private PlayField p;
    
    @Override
    public void move() {
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
