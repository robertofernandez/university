package p116;
// @JUDGE_ID:  1000AA  116  Java  "Unidirectional TSP"

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
    static boolean readFromFile = true;
    static String filePath = "src/main/resources/p116.txt";

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

    public static void main(String args[]) {
        Main myWork = new Main();
        myWork.Begin();
    }

    void Begin() {
        MyStringTokenizer idata;
        FileInputStream fileInputStream;
        InputStream inputStream;
        try {
            inputStream = System.in;
        } catch (Exception e) {
            return;
        }

        if (readFromFile) {
            try {
                fileInputStream = new FileInputStream(filePath);
                inputStream = fileInputStream;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        idata = new MyStringTokenizer(inputStream);

        while (idata.hasMoreTokens()) {
            Integer rows = 0;
            Integer columns = 0;
            rows = Integer.parseInt(idata.nextToken());
            columns = Integer.parseInt(idata.nextToken());
            if (rows == 0 || columns == 0) {
                continue;
            }
            Integer currentRow = 0;
            Integer currentColumn = 0;
            NodesMatrix matrix = new NodesMatrix(columns, rows);
            int currentElement = 0;
            while (currentElement < columns * rows) {
                if (idata.hasMoreTokens()) {
                    Integer value = Integer.parseInt(idata.nextToken());
                    matrix.addNode(currentColumn, currentRow, new Node(value, currentColumn, currentRow, columns));
                    currentElement++;
                    currentColumn++;
                    if (currentColumn > columns - 1) {
                        currentColumn = 0;
                        currentRow++;
                    }
                } else {
                    break;
                }
            }
            if (currentElement < columns * rows) {
                return;
            }
            for (int processedColumn = 1; processedColumn < columns; processedColumn++) {
                for (int i = 0; i < rows; i++) {
                    ArrayList<Node> adjacents = matrix.getAdjacents(processedColumn, i);
                    Collections.sort(adjacents);
                    Node node = matrix.matrix[processedColumn][i];
                    node.setTotalSum(adjacents.get(0).totalSum + node.value);
                    node.totalRowSum = adjacents.get(0).totalRowSum.withValue(node.row + 1);
                    node.previousNode = adjacents.get(0);
                }
            }
            ArrayList<Node> lastColumn = matrix.getLastColumn();
            Collections.sort(lastColumn);

            Node finalNode = lastColumn.get(0);
            Node currentNode = finalNode;
            Stack<Node> nodesInPath = new Stack<>();
            while (currentNode.previousNode != null) {
                currentNode = currentNode.previousNode;
                nodesInPath.push(currentNode);
            }
            String outputLine = "";
            while (nodesInPath.size() > 0) {
                Node popedNode = nodesInPath.pop();
                outputLine += (popedNode.row + 1) + " ";
            }
            outputLine += (finalNode.row + 1);

            System.out.println(outputLine);
            System.out.println(finalNode.totalSum);
        }
    }

    public class Node implements Comparable<Node> {
        Integer value;
        //BigInteger ponderedRowValue;
        Integer totalSum;
        RowsList totalRowSum;
        private Integer column;
        private Integer row;
        Node previousNode;

        public Node(Integer value, Integer column, Integer row, Integer totalColumns) {
            this.value = value;
            this.column = column;
            this.row = row;
            totalSum = value;
            totalRowSum = new RowsList(row + 1);
        }

        public void setTotalSum(Integer totalSum) {
            this.totalSum = totalSum;
        }

        public Integer getTotalSum() {
            return totalSum;
        }

        @Override
        public String toString() {
            return "<" + column + ", " + row + ">: " + value.toString();
        }

        @Override
        public int compareTo(Node o2) {
            if (totalSum.equals(o2.totalSum)) {
                //return row.compareTo(o2.row);
                return totalRowSum.compareTo(o2.totalRowSum);
            }
            return totalSum.compareTo(o2.totalSum);
        }
    }

    public class NodesMatrix {
        Node[][] matrix;
        private Integer columns;
        private Integer rows;

        public NodesMatrix(Integer columns, Integer rows) {
            this.columns = columns;
            this.rows = rows;
            matrix = new Node[columns][rows];
        }

        public void addNode(Integer column, Integer row, Node node) {
            matrix[column][row] = node;
        }

        ArrayList<Node> getAdjacents(Integer column, Integer row) {
            ArrayList<Node> output = new ArrayList<>();
            Integer targetColumn = column - 1;
            Integer row1 = (row + rows - 1) % rows;
            Integer row2 = (row + 1) % rows;
            output.add(matrix[targetColumn][row]);
            output.add(matrix[targetColumn][row1]);
            output.add(matrix[targetColumn][row2]);
            return output;
        }

        ArrayList<Node> getLastColumn() {
            ArrayList<Node> output = new ArrayList<>();
            for (int i = 0; i < rows; i++) {
                output.add(matrix[columns - 1][i]);
            }
            return output;
        }
    }

    public class RowsList implements Comparable<RowsList> {
        ArrayList<Integer> rows;

        public RowsList() {
            rows= new ArrayList<>();
        }

        public RowsList(Integer initialValue) {
            rows= new ArrayList<>();
            addValue(initialValue);
        }


        @Override
        public int compareTo(RowsList o) {
            int i= 0;
            for (Integer value : rows) {
                Integer anotherValue = o.rows.get(i++);
                if(value.compareTo(anotherValue) != 0) {
                    return value.compareTo(anotherValue);
                }
            }
            return 0;
        }
        
        public RowsList withValue(Integer value) {
            RowsList output = new RowsList();
            output.rows.addAll(rows);
            output.addValue(value);
            return output;
        }

        public void addValue(Integer value) {
            rows.add(value);
        }
    }

    public class MyStringTokenizer {
        private InputStream inputStream;
        private StringTokenizer tokenizer;

        public MyStringTokenizer(InputStream inputStream) {
            this.inputStream = inputStream;
        }

        public String nextToken() {
            if (hasMoreTokens()) {
                return tokenizer.nextToken();
            } else {
                return null;
            }
        }

        public boolean hasMoreTokens() {
            if (tokenizer == null || !tokenizer.hasMoreTokens()) {
                String input = Main.ReadLn(255, inputStream);
                if (input == null || input.length() == 0) {
                    return false;
                }
                tokenizer = new StringTokenizer(input);
            }
            return tokenizer.hasMoreElements();
        }
    }
}