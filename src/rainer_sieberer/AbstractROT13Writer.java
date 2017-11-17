package rainer_sieberer;

import java.io.Writer;
import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.IllegalArgumentException;

public abstract class AbstractROT13Writer extends BufferedWriter
{

	protected Writer decoratedWriter;

	public AbstractROT13Writer ( Writer out )
	{
		super(out);
		this.decoratedWriter = out;
	}

	public AbstractROT13Writer ( Writer out, int sz ) throws IllegalArgumentException
	{
		super(out,sz);
		this.decoratedWriter = out;
	}

	public void close() throws IOException { this.decoratedWriter.close(); }

	public void flush() throws IOException { this.decoratedWriter.flush(); }

	// public void newLine() throws IOException { this.decoratedWriter.newLine(); }

	public void write(char[] cbuf, int off, int len) throws IOException
	{
		this.decoratedWriter.write(cbuf, off, len);
	}

	public void write(int c) throws IOException { this.decoratedWriter.write(c); }

	public void write(String s, int off, int len) throws IOException
	{
		this.decoratedWriter.write(s, off, len);
	}

}
