package co.uk.jpmc.report.exception;

public class InvalidDataException extends Exception
{
	private String message;

	public InvalidDataException(final String message)
	{
		super(message);
	}
}
