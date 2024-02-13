package studio.sodhium.academic;

public class NewtonRaphson {
    public static final int MAX_STEPS = 10000;

    public static Double getSquareRoot(Double number, Double precision) {
        int steps = 0;
        if (number < 0) {
            throw new IllegalArgumentException("No negative number allowed");
        }
        Double currentApprox = number / 2;
        Double lastMin = 0D;
        Double lastMax = number;

        while (Math.abs(currentApprox * currentApprox - number) > precision) {
            if (currentApprox * currentApprox - number > 0) {
                lastMax = currentApprox;
            } else {
                lastMin = currentApprox;
            }
            currentApprox = lastMin + (lastMax - lastMin) / 2;
            steps++;
            if (steps > MAX_STEPS) {
                break;
            }
        }

        System.out.println("calculated in " + steps + " steps");
        return currentApprox;
    }
    
    public static Double getSquareRootImprovedForIntegers(Double number, Double precision) {
        int steps = 0;
        if (number < 0) {
            throw new IllegalArgumentException("No negative number allowed");
        }
        Double currentApprox = number / 2;
        Double lastMin = 0D;
        Double lastMax = number;

        while (Math.abs(currentApprox * currentApprox - number) > precision) {
            if (currentApprox * currentApprox - number > 0) {
                lastMax = currentApprox;
            } else {
                lastMin = currentApprox;
            }
            currentApprox = lastMin + (lastMax - lastMin) / 2;

            Double roundApprox = Double.valueOf(Math.round(currentApprox));
            if(Math.abs(roundApprox * roundApprox - number) < precision) {
                currentApprox = roundApprox;
                break;
            }

            steps++;
            if (steps > MAX_STEPS) {
                break;
            }
        }

        System.out.println("calculated in " + steps + " steps");
        return currentApprox;
    }
}
