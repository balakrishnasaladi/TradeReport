package co.uk.jpmc.entity;

import java.util.Date;

import co.uk.jpmc.report.util.Country;
import co.uk.jpmc.report.util.WorkDay;


public class Entity
{
	private Trade trade;
	private Country country;
	private double agreedFx;
	private Date instructionDate;
	private Date settlementDate;
	private String name;
	private final WorkDay workday = new WorkDay();
	private int units;
	private double pricePerUnits;
	private Date tradeDate;
	private String id;

	public String getName()
	{
		return name;
	}

	public void setName(final String name)
	{
		this.name = name;
	}

	public Trade getTrade()
	{
		return trade;
	}

	public void setTrade(final Trade trade)
	{
		this.trade = trade;
	}

	public Country getCountry()
	{
		return country;
	}

	public void setCountry(final Country country)
	{
		this.country = country;
	}

	public double getAgreedFx()
	{
		return agreedFx;
	}

	public void setAgreedFx(final double agreedFx)
	{
		this.agreedFx = agreedFx;
	}

	public Date getInstructionDate()
	{
		return instructionDate;
	}

	public void setInstructionDate(final Date instractionDate)
	{
		this.instructionDate = instractionDate;
	}

	public Date getSettlementDate()
	{
		return settlementDate;
	}

	public void setSettlementDate(final Date settlementDate)
	{
		this.settlementDate = settlementDate;
	}

	public int getUnits()
	{
		return units;
	}

	public void setUnits(final int units)
	{
		this.units = units;
	}


	public double getPricePerUnits()
	{
		return pricePerUnits;
	}

	public void setPricePerUnits(final double pricePerUnits)
	{
		this.pricePerUnits = pricePerUnits;
	}

	public double tradeCalculation()
	{
		return pricePerUnits * units * agreedFx;
	}


	public Date getTradeDate()
	{
		if (tradeDate == null)
		{
			setTradeDate();
		}
		return tradeDate;
	}

	public void setTradeDate()
	{
		this.tradeDate = workday.getWorkingDay(country, instructionDate);
	}

	@Override
	public String toString()
	{
		// TODO Auto-generated method stub
		return this.name + "," + this.trade.getType() + "," + this.getInstructionDate() + "," + this.getSettlementDate() + ","
				+ this.getCountry() + "," + tradeCalculation();
	}
}
