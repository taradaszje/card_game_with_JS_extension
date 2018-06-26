/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 *
 * @author jarek
 */
public class CardGame {
    static int wynik1,wynik2;
    static boolean ktoZaczyna= true;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ScriptException, NoSuchMethodException {
        Cards karty = new Cards();
        Vector<Integer> drugie = (Vector<Integer>) karty.getKarty().clone();
        Player gracz = new Player("Gracz",karty.getKarty());
        Player komputer = new Player("Komp",drugie);
        while(gracz.getKarty().size()!=0){
        gracz.showCards();
        komputer.showCards();
        if(ktoZaczyna == true){
        gracz.setResult(gracz.chooseCard());
        komputer.setResult(chooseStrategy("madry",komputer,gracz));
        ktoZaczyna=false;
        }
        else{
            komputer.setResult(chooseStrategy("madry",komputer,gracz));
            gracz.setResult(gracz.chooseCard());
            ktoZaczyna =true;
        }
        gracz.addPoints(gracz, komputer);
        showPoints(gracz,komputer);
        }
        
       
        
        
    }
    
    
    
   static void showPoints(Player gracz1, Player gracz2){
        System.out.print("Pkt gracz: "+gracz1.getPoints()+". Pkt komputer: "+gracz2.getPoints()+"\n");
    }
   static int chooseStrategy(String name, Player komputer,Player gracz) throws ScriptException, NoSuchMethodException{
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        Object result;
        try {
            engine.eval(new FileReader("js\\"+name+".js"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CardGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        Invocable invocable = (Invocable) engine;
        
        if(name.equals("madry")){
            result = invocable.invokeFunction(name,gracz.getKarty(),komputer.getKarty(),gracz.result);
            komputer.getKarty().remove(result);
            return (int)result;
        }else{
            result = invocable.invokeFunction(name, komputer.karty);
            
        
        
        Double d = (Double)result;
        int i= Integer.valueOf(d.intValue());
        komputer.karty.remove(i);
        return i;
       // System.out.print("Result: "+result);
        }
          
        
    }
    
}
