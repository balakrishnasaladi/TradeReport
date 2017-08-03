package co.uk.jpmc.report.util;

import java.util.Calendar;
import java.util.Date;


public class WorkDay
{

	public boolean isWorkingDay(final Country country)
	{
		//if work days exists between Mon to Fri
		final Calendar calender = Calendar.getInstance();
		calender.setTime(new Date());
		calender.get(Calendar.DAY_OF_WEEK);
		return country.isWeekDay(calender.get(Calendar.DAY_OF_WEEK));
	}

	public Date getWorkingDay(final Country country, final Date date)
	{
		final Calendar calender = Calendar.getInstance();
		calender.setTime(date);
		calender.get(Calendar.DAY_OF_WEEK);
		if (country.isWeekDay(calender.get(Calendar.DAY_OF_WEEK)))
		{
			return date;
		}
		calender.add(Calendar.DATE, 1);
		if (country.isWeekDay(calender.get(Calendar.DAY_OF_WEEK)))
		{
			return calender.getTime();
		}
		calender.add(Calendar.DATE, 1);
		if (country.isWeekDay(calender.get(Calendar.DAY_OF_WEEK)))
		{
			return calender.getTime();
		}
		return null;
	}

}
