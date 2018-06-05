package org.fx.constants;

import org.fx.utils.LookupUtil;

/**
 * 
 * @author 617150
 *
 */
public enum Currency {


    AUD("AUD"),
	CAD("CAD"),
	CNY("CNY"),
	CZK("CZK"),
	DKK("DKK"),
	EUR("EUR"),
	GBP("GBP"),
	JPY("JPY"),
	NOK("NOK"),
	NZD("NZD"),
	USD("USD"),
	INVALID("INVALID");
    
    private Currency(String currency) {
		this.currency = currency;
	}

	private String currency;

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public static Currency lookup(String id) {
		return LookupUtil.lookup(Currency.class, id);
	}
	
}
