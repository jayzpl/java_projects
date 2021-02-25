package com.company;

import java.util.*;
class XXXException extends Exception{}

class A {
    static String m(String s) throws XXXException{
        if (s.equals("XXX"))
            throw new XXXException();
        else
            return s+"M";
    }
    static void f(ArrayList<String> l) throws XXXException {
        for (String s : l) {
            System.out.print(m(s) + " ");
        }
        System.out.println(" [wydruk metody f]");
    }

    static void h(ArrayList<String> l){
        for (String s : l) {
            System.out.print(s.charAt(0) + " ");
        }
        System.out.println("[wydruk metody h]");
    }
    static void g(ArrayList<String> l) {
        System.out.println(l.size()+" [wydruk metody g]");
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<String> lista = new ArrayList<String>();
        lista.add("aaa");
        lista.add("bb");
        //    lista.add("XXX");    // odkomentowanie tego spowoduje wyjatek
        lista.add("cccc");
        try{
            A.f(lista);
            A.h(lista);
            A.g(lista);
        } catch (XXXException e) {
            A.g(lista);
        }
    }
}
