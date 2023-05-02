package com.example.Test;

import org.junit.Test;
import static org.junit.Assert.*;

public class AddPencilsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	FirstDayAtSchool school = new FirstDayAtSchool();

	String[] bag = { "Books", "Notebooks", "Pens", "Pencils" };

	@Test
	public void testAddPencils() {

		System.out.println("Inside testAddPencils()");
		assertArrayEquals(bag, school.addPencils());

	}
	
}
