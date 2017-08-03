package co.uk.jpmc.report.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import co.uk.jpmc.entity.Entity;
import co.uk.jpmc.report.InTradeRatingReportGenerator;
import co.uk.jpmc.report.IncomingReportGenerator;
import co.uk.jpmc.report.OutTradeRatingReportGenerator;
import co.uk.jpmc.report.OutgoingReportGenerator;
import co.uk.jpmc.report.TradeReport;


/*
 * Class TradeReportImpl used to generated report based on customer need
 */
public class TradeReportImpl implements TradeReport
{
	private static final Logger LOG = Logger.getLogger(TradeReportImpl.class);

	private final List<Entity> list = new ArrayList<Entity>();

	private IncomingReportGenerator inTrade;

	private OutgoingReportGenerator outTrade;

	private InTradeRatingReportGenerator inTradeRating;

	private OutTradeRatingReportGenerator outTradeRating;

	public void generateReport()
	{
		// generate report
		inTrade.execute(list);
		outTrade.execute(list);
		inTradeRating.execute(list);
		outTradeRating.execute(list);
	}

	public void save(final Entity entity)
	{
		// generate report
		list.add(entity);
		LOG.debug(entity);
	}


	public OutTradeRatingReportGenerator getOutTradeRating()
	{
		return outTradeRating;
	}

	public void setOutTradeRating(final OutTradeRatingReportGenerator outTradeRating)
	{
		this.outTradeRating = outTradeRating;
	}

	public IncomingReportGenerator getInTrade()
	{
		return inTrade;
	}

	public void setInTrade(final IncomingReportGenerator inTrade)
	{
		this.inTrade = inTrade;
	}

	public OutgoingReportGenerator getOutTrade()
	{
		return outTrade;
	}

	public void setOutTrade(final OutgoingReportGenerator outTrade)
	{
		this.outTrade = outTrade;
	}

	public InTradeRatingReportGenerator getInTradeRating()
	{
		return inTradeRating;
	}

	public void setInTradeRating(final InTradeRatingReportGenerator inTradeRating)
	{
		this.inTradeRating = inTradeRating;
	}

}
