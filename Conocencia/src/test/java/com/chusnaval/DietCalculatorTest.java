package com.chusnaval;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test for MenuCalculator business.
 * @author Chus
 *
 */
public class DietCalculatorTest {

	private DietCalculator calculator;
	private Rule rule;
	private DateWrapper initialDay;
	
	@Before
	public void setUp(){
		initialDay = new DateWrapper();
		calculator = new DietCalculator(initialDay);
		rule = new DailyRule(Rule.FIVEDAY_FOOD_INTAKE);
	}
	
	@Test
	public void testAddRules(){
		assertTrue(calculator.hasRules());
		calculator.addRule(rule);
		assertFalse(calculator.hasRules());
	}
	
	@Test
	public void testHasFiveIntakesPerDay(){
		final int numIntakes = 5;
		
		calculator.addRule(rule);
		Diet diet = calculator.run();

		for(DailyMenu menu : diet.getMenus())
		{
			assertTrue(menu.countIntakes()==numIntakes);
		}
		
	}
}
