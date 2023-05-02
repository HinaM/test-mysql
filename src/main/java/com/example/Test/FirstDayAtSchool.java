package com.example.Test;

import java.util.Arrays;

public class FirstDayAtSchool {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String[] prepareMyBag() {
		String[] schoolbag = { "Books", "Notebooks", "Pens" };
		System.out.println("My school bag contains: "
				+ Arrays.toString(schoolbag));
		return schoolbag;
	}

	public String[] addPencils() {
		String[] schoolbag = { "Books", "Notebooks", "Pens", "Pencils" };
		System.out.println("Now my school bag contains: "
				+ Arrays.toString(schoolbag));
		return schoolbag;
	}
	
}
