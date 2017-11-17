package rainer_sieberer;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class MorseReader extends AbstractMorseReader
{

	public MorseReader ( Reader in ) throws IOException { super(in); }

	public MorseReader ( Reader in, int sz ) throws IOException { super(in,sz); }

	/**
	 *	
	 * source: inspired by stackoverflow
	 * https://stackoverflow.com/questions/1856501/java-morsecode-converter
	 *
	 */
	public String readLine () throws IOException
	{

		String line;
		String result = "";

		if ( !this.decoratedReader.ready() ) return null;

		while ((line = this.decoratedReader.readLine()) != null)
		{
				String letter = "";

				for (String morseLetter: line.split(" "))
				{
				    letter = this.morseCodes.get(morseLetter);
				    result = result + letter;
				}

				if ( this.decoratedReader.ready() )
					result = result + " ";
				
		}

		return result;

	}

	/*public String readLine () throws IOException
	{

		StringBuilder result = new StringBuilder();
		int currentChar;

		if ( !this.ready() ) return null;

		while ( this.ready() )
		{
			currentChar = this.read();
			if ( currentChar == '\n' || currentChar == '\r' )
				return result.toString();
			result.append((char)currentChar);
		}

		return null;

	}*/

	public int read ( char[] cbuf, int off, int len ) throws IOException
	{

		int currentChar;

		if ( !this.ready() )
			return -1;

		for ( int i = off; i < off+len; i++ )
		{
			if ( !this.ready() || ( currentChar = this.read() ) == -1 )
				return i-off;
			cbuf[i] = (char)currentChar;
		}

		return len; // len = i, if no previous return statement has been reached

	}

	public int read () throws IOException
	{
		if ( !this.ready() )
			return -1;

		StringBuilder str = new StringBuilder();
		int nextChar;

		while ( this.ready() && ( nextChar = this.decoratedReader.read() ) != -1 )
		{
			if ( nextChar == '\n' || nextChar == '\r' )
				return nextChar;

			if ( nextChar == ' ' )
				return this.morseCodes.get( str.toString() ).charAt(0);
			str.append((char)nextChar);
		}

		return -1;

	}

}
