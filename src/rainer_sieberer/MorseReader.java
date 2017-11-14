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

	protected Map<String, String> morseCodes = new HashMap<String, String>();

	public MorseReader ( Reader in ) throws IOException { super(in); }

	public MorseReader ( Reader in, int sz ) throws IOException { super(in,sz); }

/*
	public MorseReader ( Reader in ) throws IOException
	{
		super(in);
		File file1 = new File ("morsecode.txt");
		Scanner codeScanner = new Scanner(file1);

		while (codeScanner.hasNext())
		{
				String letter = codeScanner.next();
				String code = codeScanner.next();
				this.morseCodes.put(code, letter);
		}
	}

	public MorseReader ( Reader in, int sz ) throws IOException
	{
		super(in,sz);
		File file1 = new File ("morsecode.txt");
		Scanner codeScanner = new Scanner(file1);

		while (codeScanner.hasNext())
		{
				String letter = codeScanner.next();
				String code = codeScanner.next();
				this.morseCodes.put(code, letter);
		}
	}
*/
	public String readLine () throws IOException
	{

		String line;
		String result = "";

		while ((line = super.readLine()) != null)
		{
				String letter = "";

				for (String morseLetter: line.split(" "))
				{
				    letter = morseCodes.get(morseLetter);
				    result = result + letter;
				}

				if (letter.equals(".")) {
				    // Insert a new line after a period.
				    result = result + "\n";
				} else {
				    // Insert a space between words.
				    result = result + " ";
				}
		}

		return result;

	}

}
