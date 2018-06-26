/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame;

import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author jarek
 */
class Player {
    String name;
    int points ;
    int result;
    Vector<Integer> karty;
    Player(String name,Vector karty){
        this.name = name;
        this.karty = karty;
    }
    public void showCards(){
        System.out.print(name);
        for(int i = 0 ;i<karty.size();i++){
        System.out.print(" ["+i+"]="+karty.elementAt(i)+" ");}
        System.out.print("\n");
    }
    public int chooseCard(){
        Scanner in = new Scanner(System.in);
        System.out.println("Wybierz karte:");
        int i = in.nextInt();
       
       try{ if(i>karty.size()){
            System.out.println("daj inna");
            System.out.println("Wybierz karte:");
            i = in.nextInt();
       }
       else{
            System.out.println("usuwam : "+i);
            i =  karty.remove(i);
            
            
        }
       }
       
       catch(Exception e){}
       
       
            
        return i;
    }

    public int getPoints() {
        return points;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vector<Integer> getKarty() {
        return karty;
    }

    public void setKarty(Vector<Integer> karty) {
        this.karty = karty;
    }

    
    public void addPoints(Player one, Player two)
    {   
        if(one.getResult()>two.getResult())
            one.points+=2;
        else if(one.getResult()<two.getResult())
            two.points+=2;
        else{
            one.points+=1;
            two.points+=1;
        }
    }
    
}
