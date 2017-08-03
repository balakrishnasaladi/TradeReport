package co.uk.jpmc.entity;

public class TradeFactory
{
	public static Trade getTrade(final String name)
	{
		Trade trade;

		if (TradeType.BUY.toString().equalsIgnoreCase(name))
		{
			trade = new OutTrade();
		}
		else
		{
			trade = new InTrade();
		}
		return trade;
	}
}
