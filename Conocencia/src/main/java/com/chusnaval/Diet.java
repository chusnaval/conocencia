package com.chusnaval;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Diet{ 

	private DateWrapper firstDay;
	private Set<DailyMenu> menus;
	
	public Diet(final DateWrapper _firstDay){
		firstDay = _firstDay;
		menus = new HashSet<DailyMenu>();
		initMenusForFirstWeek();
	}
	
	/**
	 * Creates menus list for the first week
	 */
	private void initMenusForFirstWeek() {
		DailyMenu menu;
		DateWrapper menuDate = (DateWrapper) firstDay.clone();
		do{
			menu = new DailyMenu(menuDate);
			menus.add(menu);
			menuDate = menuDate.nextDay();
		}while(menu.isLastForWeek());
	}

	public Set<DailyMenu> getMenus() {
		return menus;
	}

	// TODO we can't apply rules for all menus, that's inefficient
	// we must apply rule to a set of days, there are weekly rules,
	// monthly rules, diary rules, etc...
	// can exist a pattern or a data structure to solve this
	public void applyRule(final Rule rule, final Period period) {
		
		Set<DailyMenu> weeklyMenu = obtainFutureWeeklyMenus();
	}

	/**
	 * Obtain menus for all days for the present week.
	 * @return
	 */
	private Set<DailyMenu> obtainFutureWeeklyMenus() {
		
		final Set<DailyMenu> result = new HashSet<DailyMenu>();
		final Iterator<DailyMenu> menusIterator = menus.iterator();
		boolean isTheEndOfWeek = false;
		
		while(menusIterator.hasNext() && !isTheEndOfWeek){
			DailyMenu menu = menusIterator.next();
			isTheEndOfWeek = menu.isLastForWeek();
			result.add(menu);
		}
		return result;
	}



}
