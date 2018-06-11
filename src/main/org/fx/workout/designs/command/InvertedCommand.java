package org.fx.workout.designs.command;

import org.fx.utils.CommonUtils;

public class InvertedCommand implements Command{
	
	private double amount;
	private String base, term;
	private double value;
	
	/**
	 * @param amount
	 * @param base
	 * @param term
	 */
	public InvertedCommand(String base, String term, double amount) {
		this.base = base;
		this.term = term;
		this.amount = amount;
	}

	@Override
	public void execute() {
		double value = Double.valueOf(CommonUtils.getCurrencyRate(getTerm() + getBase()));
		setValue((1 / value) * amount);
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

}
