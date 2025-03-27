package com.example.basic;

class TestProgram {
	public static void main(String[] args) {
		int count = 5;
		WelcomeMessage message = new WelcomeMessage();

		while (count > 0) {
			message.printMessage();
			count--;
		}
	}
}
