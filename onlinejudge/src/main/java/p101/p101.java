package p101;
// @JUDGE_ID:  1000AA  101  Java  "The Blocks Problem"

import java.io.*;
import java.util.*;

class Main {
    static boolean readFromFile = true;
    static String filePath = "src/main/resources/p101_4.txt";

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

        Integer elements = null;
        P101World world = null;

        while ((input = Main.ReadLn(255, inputStream)) != null) {
            try {
                idata = new StringTokenizer(input);
                if (elements == null) {
                    elements = Integer.parseInt(idata.nextToken());
                    world = new P101World(elements);
                    continue;
                }
                String operationPrefix = idata.nextToken();
                
                if ("quit".equalsIgnoreCase(operationPrefix)) {
                    break;
                }
                Integer a = Integer.parseInt(idata.nextToken());
                String operationSuffix = idata.nextToken();
                Integer b = Integer.parseInt(idata.nextToken());
                world.boxes.get(a).performOperation(operationPrefix + "_" + operationSuffix, world.boxes.get(b));
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

        System.out.print(world);
    }

    class P101World {
        ArrayList<BusSlot> slots;
        HashMap<Integer, Box> boxes;

        public P101World(Integer elements) {
            boxes = new HashMap<>();
            slots = new ArrayList<BusSlot>();
            for (Integer i = 0; i < elements; i++) {
                BusSlot slot = new BusSlot(i);
                Box box = new Box(i, slot.slotBox);
                slot.slotBox.setOnTop(box);
                slots.add(slot);
                boxes.put(i, box);
            }
        }

        @Override
        public String toString() {
            String output = "";
            for (BusSlot busSlot : slots) {
                output += busSlot + "\n";
            }
            return output;
        }
    }

    class BusSlot {
        Integer number;
        SlotBox slotBox;

        public BusSlot(Integer number) {
            this.number = number;
            slotBox = new SlotBox();
        }

        @Override
        public String toString() {
            String output = "" + number + ":";
            Box currentBox = slotBox;
            while (currentBox.boxOnTop != null) {
                output += " " + currentBox.boxOnTop.number;
                currentBox = currentBox.boxOnTop;
            }
            return output;
        }
    }

    class Box {
        Box boxOnTop;
        Box boxBelow;
        Box origin;

        Integer number;

        public Box(Integer number, Box origin) {
            this.number = number;
            this.origin = origin;
        }

        @Override
        public String toString() {
            return "" + number;
        }

        public void setOnTop(Box anotherBox) {
            boxOnTop = anotherBox;
            if (anotherBox.boxBelow != null) {
                anotherBox.boxBelow.boxOnTop = null;
            }
            anotherBox.boxBelow = this;
        }

        Box getMaxTop() {
            if (boxOnTop == null) {
                return this;
            } else {
                return boxOnTop.getMaxTop();
            }
        }

        Box getLowestBox() {
            if (boxBelow == null) {
                return this;
            } else {
                return boxBelow.getLowestBox();
            }
        }

        public void goToOrigin() {
            if (origin != null) {
                Box top = origin.boxOnTop;
                origin.setOnTop(this);
                if (top != null) {
                    setOnTop(top);
                }
            }
        }

        public void cleanTop() {
            while (!getMaxTop().equals(this)) {
                getMaxTop().goToOrigin();
            }
        }

        public void performOperation(String operation, Box anotherBox) {
            if (getLowestBox().equals(anotherBox.getLowestBox())) {
                return;
            }
            switch (operation) {
            case "move_onto": {
                moveOnto(anotherBox);
                break;
            }
            case "move_over": {
                moveOver(anotherBox);
                break;
            }
            case "pile_onto": {
                pileOnto(anotherBox);
                break;
            }
            case "pile_over": {
                pileOver(anotherBox);
                break;
            }
            default:
                throw new IllegalArgumentException("Unexpected value: " + operation);
            }
        }

        public void moveOnto(Box anotherBox) {
            cleanTop();
            anotherBox.cleanTop();
            anotherBox.setOnTop(this);
        }

        public void moveOver(Box anotherBox) {
            cleanTop();
            anotherBox.getMaxTop().setOnTop(this);
        }

        public void pileOnto(Box anotherBox) {
            anotherBox.cleanTop();
            anotherBox.setOnTop(this);
        }

        public void pileOver(Box anotherBox) {
            anotherBox.getMaxTop().setOnTop(this);
        }
    }

    class SlotBox extends Box {
        public SlotBox() {
            super(-1, null);
        }
    }
}