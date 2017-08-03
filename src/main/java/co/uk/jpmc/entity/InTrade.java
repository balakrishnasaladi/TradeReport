package co.uk.jpmc.entity;

public class InTrade implements Trade
{
	private static final TradeType type = TradeType.SELL;

	public TradeType getType()
	{
		return type;
	}
}
