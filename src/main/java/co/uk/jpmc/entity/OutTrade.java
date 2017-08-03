package co.uk.jpmc.entity;

public class OutTrade implements Trade
{
	private static final TradeType type = TradeType.BUY;

	public TradeType getType()
	{
		return type;
	}
}
