package studio.sodhium.academic.utils;

import java.util.ArrayList;

public class BinaryGenerator {

    public static ArrayList<String> generateBinary(int length) {
        ArrayList<String> output = new ArrayList<>();
        generateBinaryHelper("", length, output);
        return output;
    }

    private static void generateBinaryHelper(String prefix, int length, ArrayList<String> output) {
        if (length == 0) {
            output.add(prefix);
        } else {
            generateBinaryHelper(prefix + "0", length - 1, output);
            generateBinaryHelper(prefix + "1", length - 1, output);
        }
    }
}