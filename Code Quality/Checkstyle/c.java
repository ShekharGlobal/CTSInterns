package com.cts.checkstyle;
//It’s a static analysis tool — it only detects problems, 
//it doesn't change the code.
class c {
    int a;

    public c(int b) {
        a = b;
    }

    void p() {
        System.out.println("Value: " + a);
    }

    public static void main(String[] args) {
        c obj = new c(10);  // creating an object with value 10
        obj.p();            // calling the p() method to print the value
    }
}
