package com.cts.pmd;
public class PmdViolationExample {

    // Unused private field (violates 'UnusedPrivateField')
    private int unusedValue;

    public void doSomething() {
        int a;
        int b;
        String str=null;// Unused local variable (violates 'UnusedLocalVariable')
    }

    public void emptyMethod() {
        // Empty method body (violates 'EmptyMethodBody')
    }

    public void longMethod() {
        // Violates 'ExcessiveMethodLength'
        for (int i = 0; i < 100; i++) {
            System.out.println("Line: " + i);
        }
    }

    public void avoidPrintln() {
        System.out.println("This should use a logger"); // Violates 'SystemPrintln'
    }
}
