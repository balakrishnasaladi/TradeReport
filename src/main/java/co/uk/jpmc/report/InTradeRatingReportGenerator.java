package co.uk.jpmc.report;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import co.uk.jpmc.entity.Entity;
import co.uk.jpmc.entity.TradeType;


public class InTradeRatingReportGenerator
{
	private static final Logger LOG = Logger.getLogger(InTradeRatingReportGenerator.class);
	private final Map<String, Double> inTradeRating = new LinkedHashMap<String, Double>();

	public void execute(final List<Entity> list)
	{
		final List<Entity> inTradeRatingList = list.stream().filter(p -> TradeType.SELL.equals(p.getTrade().getType()))
				.collect(Collectors.toList());
		final Map<String, Double> inTradeByName = inTradeRatingList.stream()
				.collect(Collectors.toMap(x -> x.getName(), x -> x.tradeCalculation(), (oldValue, newValue) -> oldValue + newValue));

		inTradeByName.entrySet().stream().sorted(Map.Entry.<String, Double> comparingByValue().reversed())
				.forEachOrdered(x -> inTradeRating.put(x.getKey(), x.getValue()));

		LOG.info("************Ranking of entities based on incoming amount************** ");
		LOG.info(inTradeRating.keySet());
		LOG.info(inTradeRating);
	}

	public Map<String, Double> getInTradeRating()
	{
		return inTradeRating;
	}

}
