package studio.sodhium.academic.math.logic;

public abstract class UnaryOperationPredicate extends Predicate {
    private String symbol;
    private Predicate subPredicate;

    public UnaryOperationPredicate(String symbol, Predicate subPredicate) {
        this.symbol = symbol;
        this.subPredicate = subPredicate;
    }

    public String getSymbol() {
        return symbol;
    }

    public Predicate getSubPredicate() {
        return subPredicate;
    }
}
