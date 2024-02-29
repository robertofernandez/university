package p142;
// @JUDGE_ID:  1000AA  142  Java  "Mouse Clicks"

import java.io.*;
import java.util.*;

class Main {
    static boolean readFromFile = true;
    static String filePath = "src/main/resources/p142.txt";

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

        HashMap<Long, Boolean> visibleIcons = new HashMap<>();
        ArrayList<Icon> allIcons = new ArrayList<>();
        ArrayList<Icon> icons = new ArrayList<>();
        
        ArrayList<Region> regions = new ArrayList<>();
        Long iconNumber = 1L;
        char currentRegionName = 'A';
        boolean initialized = false;

        while ((input = Main.ReadLn(255, inputStream)) != null) {
            try {
                idata = new StringTokenizer(input);
                String command = idata.nextToken();
                switch (command) {
                case "#":
                    return;
                case "I":
                    Integer x = Integer.parseInt(idata.nextToken());
                    Integer y = Integer.parseInt(idata.nextToken());
                    Icon icon = new Icon(iconNumber++, x, y);
                    allIcons.add(icon);
                    visibleIcons.put(icon.getNumber(), Boolean.TRUE);
                    break;
                case "R":
                    Integer x1 = Integer.parseInt(idata.nextToken());
                    Integer y1 = Integer.parseInt(idata.nextToken());
                    Integer x2 = Integer.parseInt(idata.nextToken());
                    Integer y2 = Integer.parseInt(idata.nextToken());
                    regions.add(createFromCorners(currentRegionName++, x1, y1, x2, y2));
                    break;
                case "M":
                    if(!initialized) {
                        Collections.reverse(regions);
                        for (Icon currentIcon : allIcons) {
                            for (Region region : regions) {
                                if(contains(region, currentIcon.x, currentIcon.y)) {
                                    visibleIcons.remove(currentIcon.number);
                                    break;
                                }
                            }
                        }

                        for (Icon currentIcon : allIcons) {
                            if(visibleIcons.containsKey(currentIcon.number)) {
                                icons.add(currentIcon);
                            }
                        }

                        initialized = true;
                    }

                    Integer xm = Integer.parseInt(idata.nextToken());
                    Integer ym = Integer.parseInt(idata.nextToken());
                    calculateClick(xm, ym, regions, icons);
                    break;

                default:
                    break;
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        
    }

    void calculateClick(Integer x, Integer y, ArrayList<Region> regions, ArrayList<Icon> icons) {
        for (Region region : regions) {
            if(contains(region, x, y)) {
                System.out.println(region.name);
                return;
            }
        }
        ArrayList<Icon> nearestIcons = new ArrayList<>();
        Integer bestDistance = null;
        for (Icon icon : icons) {
            Integer distance = getCuadraticDistance(x, y, icon.x, icon.y);
            if(nearestIcons.isEmpty()) {
                bestDistance = distance;
                nearestIcons.add(icon);
            } else {
                if(bestDistance.equals(distance)) {
                    nearestIcons.add(icon);
                } else if(bestDistance > distance) {
                    nearestIcons = new ArrayList<>();
                    nearestIcons.add(icon);
                    bestDistance = distance;
                }
            }
        }
        if(!nearestIcons.isEmpty()) {
            for (Icon icon : nearestIcons) {
                System.out.print(String.format("%1$3s", icon.number));
            }
            System.out.println("");
        }
    }

    Integer getCuadraticDistance(Integer x1, Integer y1, Integer x2, Integer y2) {
        Integer difX = x1 - x2;
        Integer difY = y1 - y2;
        return difX * difX + difY * difY;
    }

    public static boolean contains(IntegerRectangularZone zone, int x, int y) {
        return (zone.getX() <= x && zone.getMaxX() >= x && zone.getY() <= y && zone.getMaxY() >= y);
    }

    public interface IntegerRectangularZone {
        int getX();
        int getY();
        int getWidth();
        int getHeight();
        int getMaxX();
        int getMaxY();
    }

    public Region createFromCorners(char name, int x, int y, int maxX, int maxY) {
        return new Region(name, x, y, maxX - x, maxY - y);
    }

    public class Icon {
        int x;
        int y;
        boolean obscured;
        Long number;

        public Icon(Long number, int x, int y) {
            super();
            this.number = number;
            this.x = x;
            this.y = y;
        }

        public Long getNumber() {
            return number;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public boolean isObscured() {
            return obscured;
        }

        public void setObscured(boolean obscured) {
            this.obscured = obscured;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }
        
        @Override
        public String toString() {
            return "" + number;
        }
    }

    public class Region implements IntegerRectangularZone {
        int x;
        int y;
        int width;
        int height;
        char name;

        public Region(char name, int x, int y, int width, int height) {
            this.name = name;
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        public char getName() {
            return name;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getMaxX() {
            return x + width;
        }

        public int getMaxY() {
            return y + height;
        }

        @Override
        public String toString() {
            return "" + name + " <" + x + ", " + y + "><" + getMaxX() + ", " + getMaxY() + ">";
        }

        public String getId() {
            return "RIZ:" + x + "_" + y + width + "_" + height;
        }
    }

}