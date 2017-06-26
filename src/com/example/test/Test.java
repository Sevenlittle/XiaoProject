package com.example.test;

import static org.junit.Assert.*;

import org.junit.Before;

public class Test {

	public static MainActivity T1=new MainActivity();
	@Before
	public void setUp() throws Exception {
	}

	@org.junit.Test
	public void testTestCaseImpl() {
		T1.TestCaseImpl(1,1);
		assertEquals(2,T1.getResult());
	}

}
