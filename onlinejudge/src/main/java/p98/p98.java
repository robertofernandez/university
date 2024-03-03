package p98;
// @JUDGE_ID:  1000AA  100  Java  "The 3n + 1 problem"

import java.io.*;
import java.util.*;

class Main {
    static boolean readFromFile = true;
    static String filePath = "src/main/resources/p100.txt";

    static String ReadLn(int maxLg, InputStream inputStream) {
        byte lin[] = new byte[maxLg];
        int lg = 0, car = -1;

        try {
            while (lg < maxLg) {
                car = inputStream.read();
                if ((car < 0) || (car == '\n'))
                    break;
                lin[lg++] += car;
            }
        } catch (IOException e) {
            return (null);
        }

        if ((car < 0) && (lg == 0))
            return (null); // eof
        return (new String(lin, 0, lg));
    }

    public static void main(String args[])
    {
        Main myWork = new Main();
        myWork.Begin();
    }

    void Begin() {
        String input;
        StringTokenizer idata;

        InputStream inputStream = System.in;
        FileInputStream fileInputStream;

        if (readFromFile) {
            try {
                fileInputStream = new FileInputStream(filePath);
                inputStream = fileInputStream;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        while ((input = Main.ReadLn(255, inputStream)) != null) {
            idata = new StringTokenizer(input);
            Long a = Long.parseLong(idata.nextToken());
            Long b = Long.parseLong(idata.nextToken());
        }
    }
}