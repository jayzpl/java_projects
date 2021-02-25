package com.company;

import java.util.*;

class T3{
    String s;
    int[] tab = new int[3];
    T3(String s, int x, int y, int z){
        this.s=s; tab[0]=x; tab[1]=y; tab[2]=z;
    }
    public String toString(){
        return s + ": "+tab[0]+" "+tab[1]+" "+tab[2];
    }
}

class L {
    ArrayList<T3> lista = new ArrayList<T3>();
    void drukuj() {
        for (T3 t: lista)
            System.out.println(t);
    }

    void zmiana(){
        T3 A = new T3("sample", 1,1,1);
        for(int i=0; i<lista.size(); i++){
            A = lista.get(i);
            A.tab[1] = A.tab[0];
            A.tab[2] = A.tab[0];
        }
        System.out.println("zmiana dokonana");
    }
}

public class Main {
    public static void main(String[] args) {
        L l = new L();
        l.lista.add(new T3("jeden",1,2,3));
        l.lista.add(new T3("dwa",11,12,13));
        l.lista.add(new T3("trzy",111,112,113));
        l.drukuj();
        l.zmiana();
        l.drukuj();
    }
}