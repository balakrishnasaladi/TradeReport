package co.uk.jpmc.report.util;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;


public class WorkDayTest
{

	@Test
	public void testGBGetTradeDate()
	{
		try
		{
			final SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
			final String dateInString = "02-08-2017";
			final Date date = sdf.parse(dateInString);

			final WorkDay workday = new WorkDay();
			final Country country = new GBCountry();
			assertEquals(workday.getWorkingDay(country, date), date);
		}
		catch (final ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
