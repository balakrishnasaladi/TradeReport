package co.uk.jpmc.report.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class AEDCountryTest
{
	private final AEDCountry aedCountry = new AEDCountry();

	@Test
	public void testSunday()
	{
		assertTrue(aedCountry.isWeekDay(1));
	}

	@Test
	public void testMonday()
	{
		assertTrue(aedCountry.isWeekDay(2));
	}

	@Test
	public void testTuesday()
	{
		assertTrue(aedCountry.isWeekDay(3));
	}

	@Test
	public void testWednesday()
	{
		assertTrue(aedCountry.isWeekDay(4));
	}

	@Test
	public void testThursday()
	{
		assertTrue(aedCountry.isWeekDay(5));
	}

	@Test
	public void testFriday()
	{
		assertFalse(aedCountry.isWeekDay(6));
	}

	@Test
	public void testSaturday()
	{
		assertFalse(aedCountry.isWeekDay(7));
	}
}
