package rainer_sieberer;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Test0
{
    public static void main(String[] args) throws IOException
    {
        Map<String, String> morseCodes = new HashMap<String, String>();
        File file1 = new File ("../conf/morsecode.txt");
        Scanner in = new Scanner(file1);  

        while (in.hasNext())
        {
            String letter = in.next();          
            String code = in.next();   
            morseCodes.put(code, letter);
        }

        File morseCode = new File("../conf/message.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(morseCode));
        String line;

        while ((line = bufferedReader.readLine()) != null)
        {
            String letter = "";

            for (String morseLetter: line.split(" "))
            {
                letter = morseCodes.get(morseLetter);
                System.out.print(letter);
            }

            if (letter.equals(".")) {
                // Insert a new line after a period.
                System.out.println();
            } else {
                // Insert a space between words.
                System.out.print(' ');
            }
        }
    }
}
