package co.uk.jpmc.report.util;

import co.uk.jpmc.entity.Currency;


public interface Country
{
	boolean isWeekDay(final Integer day);

	Currency getCurrency();
}
