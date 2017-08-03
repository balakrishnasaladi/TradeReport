package co.uk.jpmc.entity;

import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import co.uk.jpmc.report.InTradeRatingReportGenerator;
import co.uk.jpmc.report.util.AEDCountry;
import co.uk.jpmc.report.util.DateUtil;
import co.uk.jpmc.report.util.GBCountry;


public class InTradeRatingReportGeneratorTest
{
	@Test
	public void testInTradeRatingForSellWith2Users()
	{
		try
		{
			/* Load sample data */
			final InTradeRatingReportGenerator generator = new InTradeRatingReportGenerator();
			final List<Entity> list = new ArrayList<Entity>();
			/* First Customer */
			final Entity entity = new Entity();
			entity.setName("foo");
			entity.setTrade(TradeFactory.getTrade("S"));
			entity.setAgreedFx(0.50);
			entity.setPricePerUnits(100);
			entity.setUnits(200);
			entity.setInstructionDate(DateUtil.convertDate("03 Aug 2017"));
			entity.setCountry(new GBCountry());
			assertTrue(entity.tradeCalculation() == 10000);
			list.add(entity);

			/* Second Customer */
			final Entity entity1 = new Entity();
			entity1.setName("bar");
			entity1.setTrade(TradeFactory.getTrade("S"));
			entity1.setAgreedFx(0.20);
			entity1.setPricePerUnits(100);
			entity1.setUnits(200);
			entity1.setCountry(new GBCountry());
			entity1.setInstructionDate(DateUtil.convertDate("03 Aug 2017"));
			assertTrue(entity1.tradeCalculation() == 4000);
			list.add(entity1);

			/* Thrid Customer */
			final Entity entity2 = new Entity();
			entity2.setName("foo");
			entity2.setTrade(TradeFactory.getTrade("S"));
			entity2.setAgreedFx(0.20);
			entity2.setPricePerUnits(100);
			entity2.setUnits(200);
			entity2.setCountry(new GBCountry());
			entity2.setInstructionDate(DateUtil.convertDate("03 Aug 2017"));
			assertTrue(entity2.tradeCalculation() == 4000);
			entity.setCountry(new AEDCountry());
			list.add(entity2);

			generator.execute(list);

			assertTrue(generator.getInTradeRating().containsKey("foo"));
			assertTrue(generator.getInTradeRating().get("foo") == 14000);
			assertTrue(generator.getInTradeRating().containsKey("bar"));
			assertTrue(generator.getInTradeRating().get("bar") == 4000);
			final String[] rating = generator.getInTradeRating().keySet().toArray(new String[2]);
			assertTrue(rating[0].equals("foo"));
			assertTrue(rating[1].equals("bar"));
		}
		catch (final ParseException e)
		{
			e.printStackTrace();
		}

	}

	@Test
	public void testInTradeRatingForSellBuyWith2Users()
	{
		try
		{
			/* Load sample data */
			final InTradeRatingReportGenerator generator = new InTradeRatingReportGenerator();
			final List<Entity> list = new ArrayList<Entity>();
			/* First Customer */
			final Entity entity = new Entity();
			entity.setName("foo");
			entity.setTrade(TradeFactory.getTrade("S"));
			entity.setAgreedFx(0.50);
			entity.setPricePerUnits(100);
			entity.setUnits(200);
			entity.setInstructionDate(DateUtil.convertDate("03 Aug 2017"));
			entity.setCountry(new GBCountry());
			assertTrue(entity.tradeCalculation() == 10000);
			list.add(entity);

			/* Second Customer */
			final Entity entity1 = new Entity();
			entity1.setName("foo");
			entity1.setTrade(TradeFactory.getTrade("B"));
			entity1.setAgreedFx(0.20);
			entity1.setPricePerUnits(100);
			entity1.setUnits(200);
			entity1.setCountry(new GBCountry());
			entity1.setInstructionDate(DateUtil.convertDate("03 Aug 2017"));
			assertTrue(entity1.tradeCalculation() == 4000);
			list.add(entity1);

			/* Second Customer */
			final Entity entity2 = new Entity();
			entity2.setName("bar");
			entity2.setTrade(TradeFactory.getTrade("S"));
			entity2.setAgreedFx(0.20);
			entity2.setPricePerUnits(100);
			entity2.setUnits(200);
			entity2.setCountry(new GBCountry());
			entity2.setInstructionDate(DateUtil.convertDate("03 Aug 2017"));
			assertTrue(entity2.tradeCalculation() == 4000);
			list.add(entity2);

			generator.execute(list);

			assertTrue(generator.getInTradeRating().containsKey("foo"));
			assertTrue(generator.getInTradeRating().get("foo") == 10000);
			assertTrue(generator.getInTradeRating().containsKey("bar"));
			assertTrue(generator.getInTradeRating().get("bar") == 4000);
			final String[] rating = generator.getInTradeRating().keySet().toArray(new String[2]);
			assertTrue(rating[0].equals("foo"));
			assertTrue(rating[1].equals("bar"));

		}
		catch (final ParseException e)
		{
			e.printStackTrace();
		}

	}


}
