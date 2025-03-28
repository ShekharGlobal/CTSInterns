package com.example.exception;

import java.io.FileWriter;
import java.io.IOException;

public class CheckedExceptions {

	public static void main(String[] args) {

		FileWriter fw = null;
		try {
			fw = new FileWriter("d:/test.txt");
			fw.write("Welcome to All");
			System.out.println("success");
		} catch (IOException e) {
			System.out.println("exception");
		}

		finally {

			try {
				if (fw != null)
				fw.close();
			} catch (IOException e) {
				System.out.println("exception");
			}
		}

	}

}
