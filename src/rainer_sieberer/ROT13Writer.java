package rainer_sieberer;

import java.io.Writer;
import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.IllegalArgumentException;

public class ROT13Writer extends AbstractROT13Writer
{

	public ROT13Writer ( Writer out ) { super(out); }

	public ROT13Writer ( Writer out, int sz ) throws IllegalArgumentException { super(out,sz); }

	public void write(char[] cbuf, int off, int len) throws IOException
	{
		char[] newbuf = new char[cbuf.length];
		for ( int i = off; i < off+len && i < cbuf.length; i++ )
		{
			newbuf[i] = (char) encode(cbuf[i]);
		}
		this.decoratedWriter.write(newbuf,off,len);
	}

	public void write(int c) throws IOException
	{
		this.decoratedWriter.write( encode(c) );
	}

	public void write(String s) throws IOException
	{
		this.write(s,0,s.length());
	}

	public void write(String s, int off, int len) throws IOException
	{
		StringBuilder str = new StringBuilder();

		for ( int i = off; i < off+len && i < s.length(); i++ )
		{
			str.append( (char)encode(s.charAt(i)) );
		}

		this.decoratedWriter.write(str.toString(),0,len);
	}

	private int encode ( int inputChar )
	{

		int code = inputChar;
		if ( 'a' <= code && code <= 'z' )
		{
			code = code - 'a';
			code = (code + 13) % 26;
			code = code + 'a';
		}
		if ( 'A' <= code && code <= 'Z' )
		{
			code = code - 'A';
			code = (code + 13) % 26;
			code = code + 'A';
		}
		return code;

	}

}
