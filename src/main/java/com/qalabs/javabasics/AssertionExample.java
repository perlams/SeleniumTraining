package com.qalabs.javabasics;


public class AssertionExample {


    public int subtract(){

        int iNumA = 2;
        int iNumB = 4;

        return (iNumA-iNumB);


    }
    public static void main (String[] args) {
        int age = 5;
        String strName1="Perla";
        String strName2="Lalo";

       //assert.subtract();
        strName1.equals( strName2);


        assert age >= 20 && age <= 1;
        assert age >= 18;
        assert  1 > 5: "Un minuto no menos 5 minutos";


    }
}



