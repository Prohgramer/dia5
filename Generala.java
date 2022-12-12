import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;

public class Generala{
    String jugada(String dados)
    {
        try {
            Integer.parseInt(dados);
        }catch (NumberFormatException nfe){
            return "invalido";
        }
        if(generala(dados)){
            return "GENERALA";
        } else if (poker(dados)){
            return "POKER";
        } else if (escalera(dados)) {
            return "ESCALERA";
        } else if (full(dados)) {
            return "FULL";
        }

        return "NADA";
    }
    public boolean escalera(String dados){
        char[] numeros = dados.toCharArray();
        int[] array=new int[5];
        //pasar de array de char a array de enteros :)
        for (int i = 0; i < numeros.length; i++) {
            array[i]=Integer.parseInt(String.valueOf(numeros[i]));
        }
        //si array[4]=1 va comparar igual si es escalera pero una posicion menos y quedaria 3456 y como el ultimo puesto es 1 entonces 34561
        if(array[4]==1){
            for (int j = 0; j < 2; j++) {
                if (array[j] < array[j + 1]) {

                } else return false;
            }
            return true;
        }else { //comparar si esta en escalera.
            for (int i = 0; i < 4; i++) {
                if(array[i] < array[i + 1]) {

                } else return false;
            }
        }
        return true;
    }
    public boolean generala(String dados){
        for(int i=0;i<dados.length();i++){
            if(dados.charAt(i)!=dados.charAt(0)){
                return false;
            }
        }
        return true;
    }
    public boolean poker(String dados){
        int canti_repe;
        for(int i=0;i<dados.length();i++){
           canti_repe=0;                          //reseteo e contador
           for (int j=0;j<dados.length();j++){
              if(dados.charAt(i)==dados.charAt(j)){
                  canti_repe+=1;
              }
           }
           if(canti_repe==4){  //si el contador llega a 4 queire decir que hay 4 numeros iguales xd.
               return true;
          }
        }
        return false;
    }
    public boolean full(String dados){
        int canti_repe2=0,canti_repe1=0;
        for(int i=0;i<dados.length();i++){
            for (int j=0;j<dados.length();j++){
                if(dados.charAt(i)==dados.charAt(j)){ //si son iguales
                    if(dados.charAt(i)!=dados.charAt(0)){ //si es diferente al primer numero entonces va a activar otro contador
                        canti_repe2+=1;
                    }else canti_repe1+=1; //si es igual al primer posicion seguira aumentando el contador 1
                }
            }
        }
        if(canti_repe2==4 && canti_repe1==9){ //si hay 9 en el contador 1 y 4 en el contador 2 entonces pasa
            return true;                      //explicacion: si hay 3 iguales 3*3=9 si hay 2 iguales 2*2=4 :)
        }
        return false;
    }
    public static void main(String[] args){
        String numero="";
        Generala g = new Generala();

        for(int i=0;i<5;i++){
            numero+=(int)(Math.random() * ((6 - 1) + 1)) + 1;  //creo 5 numeros por separado y los uno en un string.
        }
        System.out.println("El numero generado automaticamente es: "+ numero);
        System.out.println(g.jugada("34561"));
    }
}
