package co.uk.jpmc.report;

import java.text.ParseException;

import org.apache.log4j.Logger;

import co.uk.jpmc.entity.Entity;
import co.uk.jpmc.entity.TradeFactory;
import co.uk.jpmc.report.exception.InvalidDataException;
import co.uk.jpmc.report.util.CountryFactory;
import co.uk.jpmc.report.util.DateUtil;


public class EntityParser
{
	private static final Logger LOG = Logger.getLogger(EntityParser.class);

	public Entity parse(final String data) throws ParseException, InvalidDataException
	{
		LOG.info("start parsing input");
		final Entity entity = new Entity();
		final String values[] = data.split(",");
		if (values.length < 7)
		{
			throw new InvalidDataException("Invalid input data for record:" + data);
		}
		else
		{
			entity.setName(values[0]);
			entity.setTrade(TradeFactory.getTrade(values[1]));
			entity.setAgreedFx(new Double(values[2]));
			entity.setCountry(CountryFactory.getCountry(values[3]));
			entity.setInstructionDate(DateUtil.convertDate(values[4]));
			entity.setSettlementDate(DateUtil.convertDate(values[4]));
			entity.setUnits(new Integer(values[6]));
			entity.setPricePerUnits(new Double(values[7]));
		}
		return entity;
	}
}
