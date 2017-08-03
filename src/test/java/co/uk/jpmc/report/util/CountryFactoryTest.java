package co.uk.jpmc.report.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class CountryFactoryTest
{
	@Test
	public void testCountryGBP()
	{
		assertEquals(CountryFactory.getCountry("GBP").getCurrency().toString(), "GBP");
	}

	@Test
	public void testCountryAED()
	{
		assertEquals(CountryFactory.getCountry("AED").getCurrency().toString(), "AED");
	}

	@Test
	public void testCountryUSD()
	{
		assertEquals(CountryFactory.getCountry("USD").getCurrency().toString(), "USD");
	}


}
