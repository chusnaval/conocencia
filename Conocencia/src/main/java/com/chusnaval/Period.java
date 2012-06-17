package com.chusnaval;

public final class Period {

	private final DateWrapper initialDay;
	private final DateWrapper finalDay;

	public Period(final DateWrapper ini, final DateWrapper fin) {
		initialDay = ini;
		finalDay = fin;
	}

	public DateWrapper getInitialDay() {
		return initialDay;
	}

	public DateWrapper getFinalDay() {
		return finalDay;
	}
}
