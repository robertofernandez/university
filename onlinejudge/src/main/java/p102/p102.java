package p102;
// @JUDGE_ID:  1000AA  102  Java  "Ecological Bin Packing"

import java.io.*;
import java.util.*;

class Main {
    static boolean readFromFile = true;
    static String filePath = "src/main/resources/p102.txt";

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
            try {
                idata = new StringTokenizer(input);
                
                ArrayList<Bin> bins = new ArrayList<>();

                for(int i=0;i<3;i++) {
                    Integer b = Integer.parseInt(idata.nextToken());
                    Integer g = Integer.parseInt(idata.nextToken());
                    Integer c = Integer.parseInt(idata.nextToken());
                    bins.add(new Bin(b, g, c));
                }

                BinsSet binsSet = new BinsSet(bins);
                ArrayList<ArrayList<String>> allCombinations = new ArrayList<>();
                addToList(allCombinations, "B", "C", "G");
                addToList(allCombinations, "B", "G", "C");
                addToList(allCombinations, "C", "B", "G");
                addToList(allCombinations, "C", "G", "B");
                addToList(allCombinations, "G", "B", "C");
                addToList(allCombinations, "G", "C", "B");

                ArrayList<String> bestCombination = null;
                Integer bestCombinationResult = null;

                for (ArrayList<String> combination : allCombinations) {
                    int movements = binsSet.calculateMovements(combination);
                    if(bestCombination == null) {
                        bestCombinationResult = movements;
                        bestCombination = combination;
                    } else {
                        if(movements < bestCombinationResult) {
                            bestCombinationResult = movements;
                            bestCombination = combination;
                        }
                    }
                }
                System.out.println(combinationDescriptor(bestCombination) + " " + bestCombinationResult);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        
    }
    
    private String combinationDescriptor(ArrayList<String> bestCombination) {
        return "" + bestCombination.get(0) + bestCombination.get(1) + bestCombination.get(2);
    }

    void addToList(ArrayList<ArrayList<String>> combinations, String... elements) {
        List<String> asList = Arrays.asList(elements);
        ArrayList<String> c1 = new ArrayList<>();
        c1.addAll(asList);
        combinations.add(c1);
    }

    class Bin {
        HashMap<String, Integer> elements;
        
        public Bin(Integer b, Integer g, Integer c) {
            elements = new HashMap<>();
            elements.put("B", b);
            elements.put("G", g);
            elements.put("C", c);
        }
        
        public HashMap<String, Integer> getElements() {
            return elements;
        }
        
        @Override
        public String toString() {
            return elements.toString();
        }
    }
    
    class BinsSet {
        private ArrayList<Bin> bins;

        public BinsSet(ArrayList<Bin> bins) {
            this.bins = bins;
        }

        int calculateMovements(ArrayList<String> configuration) {
            int output = 0;
            for(int i=0;i<bins.size();i++) {
                String label = configuration.get(i);
                for(int j = 0; j<bins.size();j++) {
                    if(i!=j) {
                        output+= bins.get(j).getElements().get(label);
                    }
                }
            }
            return output;
        }
    }

}