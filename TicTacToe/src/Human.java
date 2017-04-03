
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lukemcnemee
 */
public class Human implements AI{
    private PlayField p;
    
    @Override
    public void move() {
        
        Scanner s = new Scanner(System.in);
        
        System.out.println("Zadejte sloupec 0,1,2");
        int sloupec = s.nextInt();
        
        System.out.println("Zadejte radu 0,1,2");
        int rada = s.nextInt();
        
        int res = p.play(sloupec, rada);
        if(res != 0){
            System.out.println("Spatny vyber, znovu");
            p.print();
        }
    }

    @Override
    public void setPlayfield(PlayField field) {
        p = field;
    }
    
}
