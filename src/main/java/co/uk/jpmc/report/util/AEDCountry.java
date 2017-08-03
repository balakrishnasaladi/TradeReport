package co.uk.jpmc.report.util;

import java.util.Arrays;
import java.util.List;

import co.uk.jpmc.entity.Currency;


public class AEDCountry implements Country
{
	private final Currency currency = Currency.AED;
	/*
	 * days of week represents 1 to 7 with 1 = Sunday and 7 = Saturday
	 */
	private final List<Integer> weekends = Arrays.asList(new Integer[]
	{ 6, 7 });

	public boolean isWeekDay(final Integer day)
	{
		return !weekends.contains(day);
	}

	public Currency getCurrency()
	{
		return currency;
	}
}
