/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame;

import java.util.Objects;
import java.util.Random;
import java.util.Vector;

/**
 *
 * @author jarek
 */
public class Cards {
    Vector<Integer> karty = new Vector();
    Cards(){
        Random rand = new Random();
        for(int i=0;i<10;i++){
            karty.add(rand.nextInt(10)+1);
        }
        
        
    }

    public Vector<Integer> getKarty() {
        return karty;
    }

    public void setKarty(Vector<Integer> karty) {
        this.karty = karty;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.karty);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cards other = (Cards) obj;
        if (!Objects.equals(this.karty, other.karty)) {
            return false;
        }
        return true;
    }
    
}
