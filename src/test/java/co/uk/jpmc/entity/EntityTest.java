package co.uk.jpmc.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import co.uk.jpmc.report.util.Country;
import co.uk.jpmc.report.util.GBCountry;


public class EntityTest
{
	@Test
	public void testGBGetTradeDate()
	{
		try
		{
			final SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
			final String dateInString = "02-08-2017";
			final Date date = sdf.parse(dateInString);

			final Entity entity = new Entity();

			entity.setInstructionDate(date);
			final Country country = new GBCountry();
			entity.setCountry(country);
			assertEquals(entity.getTradeDate(), date);
		}
		catch (final ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testSaturdayGBGetTradeDate()
	{
		try
		{
			final SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
			final String dateInString = "29-07-2017";
			final Date date = sdf.parse(dateInString);

			final Entity entity = new Entity();

			entity.setInstructionDate(date);
			final Country country = new GBCountry();
			entity.setCountry(country);
			assertEquals(entity.getTradeDate(), sdf.parse("31-07-2017"));
		}
		catch (final ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testSundayGBGetTradeDate()
	{
		try
		{
			final SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
			final String dateInString = "30-07-2017";
			final Date date = sdf.parse(dateInString);

			final Entity entity = new Entity();

			entity.setInstructionDate(date);
			final Country country = new GBCountry();
			entity.setCountry(country);
			assertEquals(entity.getTradeDate(), sdf.parse("31-07-2017"));
		}
		catch (final ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testCalculation()
	{
		final Entity entity = new Entity();
		entity.setAgreedFx(0.50);
		entity.setPricePerUnits(100);
		entity.setUnits(200);
		assertTrue(entity.tradeCalculation() == 10000);
	}
}
