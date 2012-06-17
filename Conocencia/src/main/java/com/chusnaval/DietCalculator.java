package com.chusnaval;

import java.util.HashSet;
import java.util.Set;

/**
 * Calculate diary menu based in a set of nutrition rules.
 * 
 * @author Chus
 * 
 */
public class DietCalculator {

	/**
	 * Contains all nutrition rules.
	 */
	private Set<Rule> rules;
	private Diet diet;

	public DietCalculator(DateWrapper _firstDay) {
		diet = new Diet(_firstDay);
		rules = new HashSet<Rule>();
	}

	/**
	 * Adds new rules to the calculator.
	 * 
	 * @param _rule
	 */
	public void addRule(Rule _rule) {
		rules.add(_rule);
	}

	/**
	 * See if calculator has almost one rule.
	 * 
	 * @return
	 */
	public boolean hasRules() {
		return rules.isEmpty();
	}

	/**
	 * Obtain diet based on nutrition rules to a determinate period.
	 * 
	 * @return
	 */
	public Diet run(Period period) {
		for (Rule rule : rules) {
			diet.applyRule(rule, period);
		}
		return diet;
	}

}
