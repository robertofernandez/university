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
    static boolean readFromFile = false;
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
        try {
            Main myWork = new Main();
            myWork.Begin();
        } catch (Exception e) {
            
        }
    }

    void Begin() {
        String input = "";
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

        while (true) {
            try {
                input = Main.ReadLn(255, inputStream);
                if(input == null) {
                    break;
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
            
            Integer rows = null;
            Integer columns = null;
            try {
                idata = new StringTokenizer(input);
                rows = Integer.parseInt(idata.nextToken());
                columns = Integer.parseInt(idata.nextToken());
            } catch (Exception e) {
                continue;
            }
            if(rows == 0 || columns == 0) {
                continue;
            }

            Integer currentRow = 0;
            Integer currentColumn = 0;

            NodesMatrix matrix;

            try {
                matrix = new NodesMatrix(columns, rows);
            } catch (Exception e) {
                continue;
            }

            int currentElement = 0;

            while (currentElement < columns * rows) {
                try {
                    input = Main.ReadLn(255, inputStream);
                    idata = new StringTokenizer(input);
                    while (idata.hasMoreTokens()) {
                        Integer value = Integer.parseInt(idata.nextToken());
                        matrix.addNode(currentColumn, currentRow, new Node(value, currentColumn, currentRow));
                        currentElement++;
                        currentColumn++;
                        if (currentColumn > columns - 1) {
                            currentColumn = 0;
                            currentRow++;
                        }
                    }
                } catch (Exception e) {
                    continue;
                }
            }
            
            if(currentElement < columns * rows) {
                return;
            }

            try {
                for (int processedColumn = 1; processedColumn < columns; processedColumn++) {
                    for (int i = 0; i < rows; i++) {
                        ArrayList<Node> adjacents = matrix.getAdjacents(processedColumn, i);
                        Collections.sort(adjacents);
                        Node node = matrix.matrix[processedColumn][i];
                        node.setTotalSum(adjacents.get(0).totalSum + node.value);
                        node.previousNode = adjacents.get(0);
                    }
                }
            } catch (Exception e) {
                return;
            }
            
            ArrayList<Node> lastColumn = null;

            try {
                lastColumn = matrix.getLastColumn();
                Collections.sort(lastColumn);
            } catch (Exception e) {
                return;
            }

            try {
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
            } catch (Exception e) {
                continue;
            }
        }
    }

    public class Node implements Comparable<Node> {
        Integer value;
        Integer totalSum;
        private Integer column;
        private Integer row;
        Node previousNode;

        public Node(Integer value, Integer column, Integer row) {
            this.value = value;
            this.column = column;
            this.row = row;
            totalSum = value;
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
                return row.compareTo(o2.row);
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
}