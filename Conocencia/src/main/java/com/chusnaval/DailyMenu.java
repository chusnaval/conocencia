package com.chusnaval;

import java.util.HashSet;
import java.util.Set;

public class DailyMenu {

	private DateWrapper date;
	private Set<Intake> intakes;
	
	/**
	 * Default constructor that set menu's date.
	 * @param menuDate
	 */
	public DailyMenu(final DateWrapper menuDate) {
		date = menuDate;
		intakes = new HashSet<Intake>();
	}

	public int countIntakes() {
		return intakes.size();
	}

	public int getWeek() {
		return date.getWeek();
	}

	public boolean isLastForWeek() {
		return date.isLastDayOfWeek();
	}



}
