package com.example.basic;
class TestProgramFor {
    public static void main(String[] args) { 
        DisplayMessage message = new DisplayMessage(); 
        int num = 5;
        
        for (int i = 1; i <= num; i++) { 
            message.printMessage(); 
        }
    }
}