package rainer_sieberer;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.io.FileNotFoundException;

public abstract class AbstractMorseReader extends BufferedReader
{

	protected Map<String, String> morseCodes;
	BufferedReader decoratedReader;

	public AbstractMorseReader ( Reader in ) throws IOException
	{
		super(in);
		decoratedReader = new BufferedReader(in);
		morseCodes = new HashMap<String, String>();
		this.storeCode();		
	}

	public AbstractMorseReader ( Reader in, int sz ) throws IOException
	{
		super(in,sz);
		decoratedReader = new BufferedReader(in,sz);
		morseCodes = new HashMap<String, String>();
		this.storeCode();
	}

	private void storeCode () throws FileNotFoundException
	{
		File file1 = new File ("morsecode.txt");
		Scanner codeScanner = new Scanner(file1);

		while (codeScanner.hasNext())
		{
				String letter = codeScanner.next();
				String code = codeScanner.next();
				this.morseCodes.put(code, letter);
		}
	}

	public void close () throws IOException{ this.decoratedReader.close(); }

	public void mark ( int readAheadLimit ) throws IOException { this.decoratedReader.mark( readAheadLimit ); }

	public boolean markSupported () { return this.decoratedReader.markSupported(); }

	public int read () throws IOException { return this.decoratedReader.read(); }

	public int read ( char[] cbuf, int off, int len ) throws IOException
	{
		return this.decoratedReader.read( cbuf, off, len );
	}

	public String readLine () throws IOException { return this.decoratedReader.readLine(); }

	public boolean ready () throws IOException { return this.decoratedReader.ready(); }

	public void reset () throws IOException { this.decoratedReader.reset(); }

	public long skip ( long n ) throws IOException { return this.decoratedReader.skip( n ); }

}
