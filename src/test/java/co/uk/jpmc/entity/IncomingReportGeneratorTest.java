package co.uk.jpmc.entity;

import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import co.uk.jpmc.report.IncomingReportGenerator;
import co.uk.jpmc.report.util.AEDCountry;
import co.uk.jpmc.report.util.DateUtil;
import co.uk.jpmc.report.util.GBCountry;


public class IncomingReportGeneratorTest
{

	@Test
	public void testInTradeWith2Sells()
	{
		try
		{
			/* Load sample data */
			final IncomingReportGenerator generator = new IncomingReportGenerator();
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
			entity.setCountry(new AEDCountry());
			list.add(entity1);

			generator.execute(list);
			assertTrue(generator.getDayInTrade().containsKey("03-08-2017"));
			assertTrue(generator.getDayInTrade().get("03-08-2017") == 14000);

		}
		catch (final ParseException e)
		{
			e.printStackTrace();
		}

	}

	@Test
	public void testInTradeWithSellBuy()
	{
		try
		{
			/* Load sample data */
			final IncomingReportGenerator generator = new IncomingReportGenerator();
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
			entity1.setTrade(TradeFactory.getTrade("B"));
			entity1.setAgreedFx(0.20);
			entity1.setPricePerUnits(100);
			entity1.setUnits(200);
			entity1.setCountry(new GBCountry());
			entity1.setInstructionDate(DateUtil.convertDate("03 Aug 2017"));
			assertTrue(entity1.tradeCalculation() == 4000);
			entity.setCountry(new AEDCountry());
			list.add(entity1);

			generator.execute(list);
			assertTrue(generator.getDayInTrade().containsKey("03-08-2017"));
			assertTrue(generator.getDayInTrade().get("03-08-2017") == 10000);

		}
		catch (final ParseException e)
		{
			e.printStackTrace();
		}

	}

	@Test
	public void testInTradeWithSellWithDiffDates()
	{
		try
		{
			/* Load sample data */
			final IncomingReportGenerator generator = new IncomingReportGenerator();
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
			entity1.setInstructionDate(DateUtil.convertDate("02 Aug 2017"));
			assertTrue(entity1.tradeCalculation() == 4000);
			entity.setCountry(new AEDCountry());
			list.add(entity1);

			generator.execute(list);
			assertTrue(generator.getDayInTrade().containsKey("03-08-2017"));
			assertTrue(generator.getDayInTrade().get("03-08-2017") == 10000);
			assertTrue(generator.getDayInTrade().containsKey("02-08-2017"));
			assertTrue(generator.getDayInTrade().get("02-08-2017") == 4000);
		}
		catch (final ParseException e)
		{
			e.printStackTrace();
		}

	}
}
