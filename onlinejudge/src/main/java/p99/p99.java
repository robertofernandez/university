package p99;
// @JUDGE_ID:  1000AA  100  Java  "Easy algorithm"

import java.io.*;
import java.util.*;

class Main
{
    static boolean readFromFile = true;
    static String filePath = "src/main/resources/p99.txt";
    
    static String ReadLn (int maxLg, InputStream inputStream)
    {
        byte lin[] = new byte [maxLg];
        int lg = 0, car = -1;

        try
        {
            while (lg < maxLg)
            {
                car = inputStream.read();
                if ((car < 0) || (car == '\n')) break;
                lin [lg++] += car;
            }
        }
        catch (IOException e)
        {
            return (null);
        }

        if ((car < 0) && (lg == 0)) return (null);  // eof
        return (new String (lin, 0, lg));
    }

    public static void main (String args[])  // entry point from OS
    {
        Main myWork = new Main();  // create a dinamic instance
        myWork.Begin();            // the true entry point
    }

    void Begin()
    {
        String input;
        StringTokenizer idata;
        int a, b, min, max, num, n, cycle, cyclemax;
        
        InputStream inputStream = System.in;
        FileInputStream fileInputStream;
        
        if(readFromFile) {
            try {
                fileInputStream = new FileInputStream(filePath);
                inputStream = fileInputStream;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        while ((input = Main.ReadLn(255, inputStream)) != null)
        {
          idata = new StringTokenizer(input);
          a = Integer.parseInt (idata.nextToken());
          b = Integer.parseInt (idata.nextToken());
          if (a < b) { min=a; max=b; } else { min=b; max=a; }
          for (cyclemax=-1, num=min; num<=max; num++) {
            for (n=num, cycle=1; n != 1; cycle++) if ((n % 2) != 0) n=3*n+1; else n >>= 1;
            if (cycle > cyclemax) cyclemax=cycle;
            }
          System.out.println (a + " " + b + " " + cyclemax);
        }
    }
}