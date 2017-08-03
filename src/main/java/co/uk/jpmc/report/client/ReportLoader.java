package co.uk.jpmc.report.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import co.uk.jpmc.report.LoadEntity;
import co.uk.jpmc.report.TradeReport;


/**
 *
 */
public class ReportLoader
{
	public static void main(final String[] args)
	{
		final ApplicationContext context = new ClassPathXmlApplicationContext("spring-report.xml");
		final LoadEntity loader = (LoadEntity) context.getBean("loader");
		loader.load();
		final TradeReport report = (TradeReport) context.getBean("tradeReport");
		report.generateReport();
	}
}
