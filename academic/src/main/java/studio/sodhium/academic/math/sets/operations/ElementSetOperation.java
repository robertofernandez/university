package studio.sodhium.academic.math.sets.operations;

import studio.sodhium.academic.math.sets.FiniteSet;

public abstract class ElementSetOperation<T> {
    protected String symbol;
    protected String element;
    protected FiniteSet<T> set;

    public ElementSetOperation(String element, FiniteSet<T> set, String symbol) {
        this.element = element;
        this.set = set;
        this.symbol = symbol;
    }

    public abstract String result();

    public String toString() {
        return element + " " + symbol + " " + set.getName() + ": " + result();
    }
    
    public String completeLaTex() {
        return "\\begin{equation}\n" + element + " " + symbol + " " + set.getName() + ": " + result() + "\n\\end{equation}";
    }
}
