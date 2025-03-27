package com.example.arrays;

public class ArrayEx {

	public static void main(String[] args) {
		//option 1
		int[] empId;
		empId= new int[3];
		
	    empId[0] = 101;
        empId[1] = 102;
        empId[2] = 103;
        
        for(int x:empId) {
			System.out.println(x);
		}
		
        
        //option 2
        int[] id= {101,102,103};
		
		for(int x:id) {
			System.out.println(x);
		}

	}

}
