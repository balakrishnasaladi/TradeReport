package co.uk.jpmc.report;

import co.uk.jpmc.entity.Entity;


public interface TradeReport
{
	public void generateReport();

	public void save(final Entity entity);
}
