package co.uk.jpmc.report.util;

import co.uk.jpmc.entity.Currency;


public class CountryFactory
{

	public static Country getCountry(final String name)
	{
		Country country = null;
		if (Currency.GBP.toString().equalsIgnoreCase(name))
		{
			country = new GBCountry();
		}
		else if (Currency.USD.toString().equalsIgnoreCase(name))
		{
			country = new USCountry();
		}
		else if (Currency.AED.toString().equalsIgnoreCase(name))
		{
			country = new AEDCountry();
		}
		return country;
	}
}
