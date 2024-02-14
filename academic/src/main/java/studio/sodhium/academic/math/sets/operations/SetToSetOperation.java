package studio.sodhium.academic.math.sets.operations;

import studio.sodhium.academic.math.sets.FiniteSet;

public abstract class SetToSetOperation<T> {
    protected String symbol;
    private FiniteSet<T> set1;
    protected FiniteSet<T> set2;

    public SetToSetOperation(FiniteSet<T> set1, FiniteSet<T> set2, String symbol) {
        this.set1 = set1;
        this.set2 = set2;
        this.symbol = symbol;
    }

    public abstract String result();

    public abstract String justification();

    public String toString() {
        return set1.getName() + " " + symbol + " " + set2.getName() + ": " + result();
    }

    public String completeLaTex() {
        return "\\begin{equation}\n" + set1.getName() + " " + symbol + " " + set2.getName() + ": " + result() + "\n\\end{equation}";
    }

    public String laTexJustification() {
        String finalSymbol = symbol;
        if(result().equals("F")) {
            finalSymbol = "\\not" + symbol;
        }

        return "\\begin{equation}\n" + justification() + " \\Rightarrow " + set1.getName() + " " + finalSymbol + " " + set2.getName() + "\n\\end{equation}";
    }
}
