package com.example.exception;

import java.io.FileWriter;
import java.io.IOException;

public class CheckedException {

	public static void main(String[] args) {
		FileWriter fw = null;
		try {
			fw = new FileWriter("e://Mphasis//july24.txt");
			fw.write("Welcome To Checked Exception");
		} catch (IOException e) {
			System.out.println("Exception");
		}

		finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("success");
	}

}
