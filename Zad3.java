package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

class Gui extends JFrame {
    JTextField
            nazwa  = new JTextField(20),
            pierwsza = new JTextField(20),
            druga = new JTextField(20),
            trzecia = new JTextField(20),
            ktory = new JTextField(20);
    JButton
            dodaj = new JButton("Dodaj"),
            wyswietl = new JButton("Wyswietl");
    L l = new L();

    Gui(){
        setTitle("Gui do liczb");
        Container con = getContentPane();
        con.setLayout(new GridLayout(2,4,10,10)) ;
        con.add(nazwa);
        con.add(pierwsza);
        con.add(druga);
        con.add(trzecia);
        con.add(dodaj);
        con.add(ktory);
        con.add(wyswietl);
        ktory.setText("Ktory element:");

        dodaj.addActionListener(new Dodaj());
        wyswietl.addActionListener(new Wyswietl());
    }

    class Dodaj implements ActionListener {
        public void actionPerformed(ActionEvent e){
            String s;
            int x,y,z;
            s = nazwa.getText();
            x = Integer.valueOf(pierwsza.getText());
            y = Integer.valueOf(druga.getText());
            z = Integer.valueOf(trzecia.getText());

            l.lista.add(new T3(s,x,y,z));
            ktory.setText("dodano");
            nazwa.setText("");
            pierwsza.setText("");
            druga.setText("");
            trzecia.setText("");
        }
    }
    class Wyswietl implements ActionListener {
        public void actionPerformed(ActionEvent e){
            T3 A = new T3("sample",1,1,1);
            int k;
            k = Integer.valueOf(ktory.getText());   //nie ma sprawdzenia czy element jest tekstem czy liczba

            if(k<l.lista.size() && k>=0){
                A = l.lista.get(k);
                nazwa.setText(A.s);
                pierwsza.setText(String.valueOf(A.tab[0]));
                druga.setText(String.valueOf(A.tab[1]));
                trzecia.setText(String.valueOf(A.tab[2]));
            }
            else{
                ktory.setText("Podany element nie istnieje");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        JFrame gi = new Gui();
        gi.setSize(200,200);
        gi.setVisible(true);
    }
}
