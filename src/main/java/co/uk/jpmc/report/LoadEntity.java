package co.uk.jpmc.report;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import co.uk.jpmc.entity.Entity;


public class LoadEntity
{
	private static final Logger LOG = Logger.getLogger(LoadEntity.class);
	private final static String inputFile = "src/resource/input/sample.csv";

	private EntityParser entityParser;
	private TradeReport report;

	public EntityParser getEntityParser()
	{
		return entityParser;
	}

	public void setEntityParser(final EntityParser entityParser)
	{
		this.entityParser = entityParser;
	}

	public TradeReport getReport()
	{
		return report;
	}

	public void setReport(final TradeReport report)
	{
		this.report = report;
	}

	/*
	 * read file, create Entity and do the calculation
	 *
	 */
	public void load()
	{

		Scanner scanner = null;

		try
		{
			LOG.debug("Input file processing started");

			scanner = new Scanner(new File(inputFile));

			while (scanner.hasNextLine())
			{
				final String str = scanner.nextLine();
				final Entity entity = entityParser.parse(str);
				report.save(entity);
			}
			scanner.close();

			LOG.info("Input file processed sucessfully");
		}
		catch (final IOException ioe)
		{
			LOG.error("Error processing input file:", ioe);
		}
		catch (final Exception exp)
		{
			LOG.error("Error processing input file:", exp);
		}
		finally
		{
			if (scanner != null)
			{
				scanner.close();
			}
		}

	}

}
