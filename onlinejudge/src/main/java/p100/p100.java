package p100;
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

    public static void main(String args[]) // entry point from OS
    {
        Main myWork = new Main(); // create a dinamic instance
        myWork.Begin(); // the true entry point
    }

    void Begin() {
        String input;
        StringTokenizer idata;
        long a, b;

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

        HashMap<Long, Long> calculatedAmounts = new HashMap<Long, Long>();
        calculatedAmounts.put(1L, 1L);

        while ((input = Main.ReadLn(255, inputStream)) != null) {
            idata = new StringTokenizer(input);
            a = Long.parseLong(idata.nextToken());
            b = Long.parseLong(idata.nextToken());

            Long min = Math.min(a, b);
            Long max = Math.max(a, b);

            Long maxLength = null;

            for (Long i = min; i <= max; i++) {
                if (!calculatedAmounts.containsKey(i)) {
                    completeThreeNPlusOneSequenceLength(i, calculatedAmounts);
                    //System.out.println(calculatedAmounts);
                }
                Long amount = calculatedAmounts.get(i);
                if (maxLength == null || maxLength.longValue() < amount.longValue()) {
                    maxLength = amount;
                }
            }

            System.out.println(a + " " + b + " " + maxLength);
        }
    }

    static long threeNPlusOneSequenceLength(long number) {
        long n = number;
        long length = 1;
        while (n != 1) {
            length++;
            if (n % 2 != 0) {
                n = 3 * n + 1;
            } else {
                n = n / 2;
            }
        }
        return length;
    }

    static void completeThreeNPlusOneSequenceLength(long number, HashMap<Long, Long> calculated) {
        long n = number;
        long length = 1;
        ArrayList<Long> stored = new ArrayList<>();
        while (n != 1) {
            stored.add(n);
            if (calculated.containsKey(n)) {
                length += calculated.get(n) - 1;
                break;
            }
            length++;
            if (n % 2 != 0) {
                n = 3 * n + 1;
            } else {
                n = n / 2;
            }
        }
        for (Long element : stored) {
            calculated.put(element, length--);
        }
    }
}