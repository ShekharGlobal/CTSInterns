package com.cts.checkstyle;

class helloCheckstyle { // class name should be PascalCase

    String msg; // field should be private

    helloCheckstyle(String m){msg=m;} // poor formatting

    void Print(){ // method name should be camelCase
        if(msg!="") // use equals(), not ==
        System.out.println("Msg: "+msg); // missing braces
    }

    public static void main(String[] args){
        helloCheckstyle h = new helloCheckstyle("Bad Style!");
        h.Print();
    }
}
