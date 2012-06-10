package com.chusnaval;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateWrapper implements Cloneable {

	private GregorianCalendar date;

	public DateWrapper() {
		date = new GregorianCalendar();
	}

	private DateWrapper(final GregorianCalendar _date) {
		date = (GregorianCalendar) _date.clone();
	}

	public Date getDate() {
		return date.getTime();
	}

	public int getWeek() {
		return date.get(Calendar.WEEK_OF_YEAR);
	}

	public boolean isLastDayOfWeek() {
		return date.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY;
	}

	public Object clone() {
		return new DateWrapper(this.date);

	}

	/**
	 * Obtain nextDay from actual date.
	 * 
	 * @return
	 */
	public DateWrapper nextDay() {
		GregorianCalendar tomorrow = (GregorianCalendar) this.date.clone();
		tomorrow.add(Calendar.HOUR, 24);
		return new DateWrapper(tomorrow);
	}

	@Override
	public String toString() {
		final int day = date.get(Calendar.DAY_OF_MONTH);
		final int month = date.get(Calendar.MONTH) + 1;
		final int year = date.get(Calendar.YEAR);

		return "DateWrapper [date=" + day + "/" + month + "/" + year + "]";
	}

}
