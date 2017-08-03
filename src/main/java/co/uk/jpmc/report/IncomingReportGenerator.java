package co.uk.jpmc.report;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import co.uk.jpmc.entity.Entity;
import co.uk.jpmc.entity.TradeType;
import co.uk.jpmc.report.util.DateUtil;


public class IncomingReportGenerator
{
	private static final Logger LOG = Logger.getLogger(IncomingReportGenerator.class);
	private final Map<String, Double> dayInTrade = new ConcurrentHashMap<String, Double>();


	public void execute(final List<Entity> list)
	{
		try
		{
			final List<Entity> inTradeList = list.stream().filter(p -> TradeType.SELL.equals(p.getTrade().getType()))
					.collect(Collectors.toList());
			for (final Entity entity : inTradeList)
			{
				final String date = DateUtil.dateAsString(entity.getTradeDate());
				if (dayInTrade.containsKey(date))
				{
					final double prev = dayInTrade.get(date);
					final double newval = prev + entity.tradeCalculation();
					dayInTrade.put(date, newval);
				}
				else
				{
					dayInTrade.put(date, entity.tradeCalculation());
				}
			}
		}
		catch (final Exception e)
		{
			LOG.error(e.getMessage(), e);
		}
		LOG.info("************Amount in USD settled incoming everyday ************** ");
		LOG.info(dayInTrade);

	}

	public Map<String, Double> getDayInTrade()
	{
		return dayInTrade;
	}
}
