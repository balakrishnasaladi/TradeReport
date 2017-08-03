package co.uk.jpmc.report;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import co.uk.jpmc.entity.Entity;
import co.uk.jpmc.entity.TradeType;


public class OutTradeRatingReportGenerator
{
	private static final Logger LOG = Logger.getLogger(OutTradeRatingReportGenerator.class);
	private final Map<String, Double> outTradeRating = new LinkedHashMap<String, Double>();

	public void execute(final List<Entity> list)
	{
		final List<Entity> outTradeRatingList = list.stream().filter(p -> TradeType.BUY.equals(p.getTrade().getType()))
				.collect(Collectors.toList());
		final Map<String, Double> outTradeByName = outTradeRatingList.stream()
				.collect(Collectors.toMap(x -> x.getName(), x -> x.tradeCalculation(), (oldValue, newValue) -> oldValue + newValue));

		outTradeByName.entrySet().stream().sorted(Map.Entry.<String, Double> comparingByValue().reversed())
				.forEachOrdered(x -> outTradeRating.put(x.getKey(), x.getValue()));

		LOG.info("************Ranking of entities based on outgoing amount************** ");
		LOG.info(outTradeRating.keySet());
		LOG.info(outTradeRating);
	}

	public Map<String, Double> getOutTradeRating()
	{
		return outTradeRating;
	}

}
