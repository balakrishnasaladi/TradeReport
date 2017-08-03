package co.uk.jpmc.entity;

/*
 * Class represents Trade type
 * dev@bsaladi
 */
public enum TradeType
{
	BUY("B"), SELL("S");

	String str;

	TradeType(final String str)
	{
		this.str = str;
	}

	@Override
	public String toString()
	{
		// TODO Auto-generated method stub
		return str;
	}
}
