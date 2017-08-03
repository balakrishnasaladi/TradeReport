package co.uk.jpmc.report.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class GBCountryTest
{
	private final GBCountry gbCountry = new GBCountry();

	@Test
	public void testSunday()
	{
		assertFalse(gbCountry.isWeekDay(1));
	}

	@Test
	public void testMonday()
	{
		assertTrue(gbCountry.isWeekDay(2));
	}

	@Test
	public void testTuesday()
	{
		assertTrue(gbCountry.isWeekDay(3));
	}

	@Test
	public void testWednesday()
	{
		assertTrue(gbCountry.isWeekDay(4));
	}

	@Test
	public void testThursday()
	{
		assertTrue(gbCountry.isWeekDay(5));
	}

	@Test
	public void testFriday()
	{
		assertTrue(gbCountry.isWeekDay(6));
	}

	@Test
	public void testSaturday()
	{
		assertFalse(gbCountry.isWeekDay(7));
	}
}
