/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lukemcnemee
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PlayField p = new PlayField();
        AI ai1 = new Human();
        ai1.setPlayfield(p);
        AI ai2 = new SimpleAI();
        ai2.setPlayfield(p);
        
        while(p.matchEnd() == '_'){
            p.next();
            while(!p.isPlayed()){            
                ai1.move();
            }
            p.print();
            if( p.matchEnd() != '_'){
                break;
            }
            p.next();
            while(!p.isPlayed()){
                ai2.move();
            }
            p.print();
        }
        System.out.println("/////////////");
        System.out.println("Winner is: " + p.matchEnd());
        System.out.println("/////////////");
    }
    
}
