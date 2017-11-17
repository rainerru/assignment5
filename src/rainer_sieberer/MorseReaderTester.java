package rainer_sieberer;

import java.io.File;
import java.io.FileReader;

public class MorseReaderTester
{

	public static void main (String[] args)
	{

		File morseCode = new File("../conf/message.txt");
		try
		{
			MorseReader mr = new MorseReader(new FileReader(morseCode));
			String line;

			while ((line = mr.readLine()) != null)
				System.out.print(line);

			mr.close();
		} catch ( Exception e ) { e.printStackTrace(); }
		System.out.println("test to see if at the end of the line is a space or not");
	}

}
