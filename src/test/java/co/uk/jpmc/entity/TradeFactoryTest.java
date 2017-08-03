package co.uk.jpmc.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class TradeFactoryTest
{

	@Test
	public void testBuyTrade()
	{

		assertEquals(TradeFactory.getTrade("B").getType().toString(), "B");
	}

	@Test
	public void testSellTrade()
	{
		assertEquals(TradeFactory.getTrade("S").getType().toString(), "S");
	}
}
