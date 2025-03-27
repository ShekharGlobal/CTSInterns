package com.cts.oops;

public class MOverloading {

	public int sum(int x, int y) {
		int z = x + y;
		return z;
	}

	public int sum(int x, int y, int z) {
		int z1 = x + y + z;
		return z1;
	}

	protected float sum(float f1, float f2) {
		float f3 = f1 + f2;
		return f3;

	}

	protected double sum(double d1, double d2) {
		double d3 = d1 + d2;
		return d3;

	}

	public String sum(String s1, double d4) {

		String s2 = s1 + d4;
		return s2;
	}

	public String sum(double d5, String s5) {

		String s6 = d5 + s5;
		return s6;
	}
	
	
}
