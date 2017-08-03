package co.uk.jpmc.report.util;

import java.util.Arrays;
import java.util.List;

import co.uk.jpmc.entity.Currency;


public class USCountry implements Country
{
	private final Currency currency = Currency.USD;
	/*
	 * days of week represents 1 to 7 with 1 = Sunday and 7 = Saturday
	 */
	private final List<Integer> weekends = Arrays.asList(new Integer[]
	{ 0, 7 });

	public boolean contains(final Integer day)
	{
		return !weekends.contains(day);
	}

	public boolean isWeekDay(final Integer day)
	{
		return !weekends.contains(day);
	}

	public Currency getCurrency()
	{
		return currency;
	}

}
