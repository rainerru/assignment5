package rainer_sieberer;

import java.io.PrintWriter;
import java.io.Writer;

public class ROT13WriterTester
{

	public static void main ( String[] args )
	{
		try
		{
			PrintWriter console = new PrintWriter(System.out, true);
			Writer rot13 = new ROT13Writer(console);
			console.write("CAESAR will become PNRFNE:\nrot13.write(\"CAESAR\") = ");
			rot13.write("CAESAR\n");
			rot13.close();
		}	catch ( Exception e ) { e.printStackTrace(); }
	}

}
