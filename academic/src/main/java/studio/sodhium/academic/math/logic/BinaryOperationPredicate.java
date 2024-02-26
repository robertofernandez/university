package studio.sodhium.academic.math.logic;

public abstract class BinaryOperationPredicate extends Predicate {
    private String symbol;
    private Predicate leftPredicate;
    private Predicate rightPredicate;

    public BinaryOperationPredicate(String symbol, Predicate leftPredicate, Predicate rightPredicate) {
        this.symbol = symbol;
        this.leftPredicate = leftPredicate;
        this.rightPredicate = rightPredicate;
    }

    public String getSymbol() {
        return symbol;
    }

    public Predicate getLeftPredicate() {
        return leftPredicate;
    }

    public Predicate getRightPredicate() {
        return rightPredicate;
    }
    
    @Override
    public String getRepresentation() {
        return "(" + leftPredicate.getRepresentation() + " " + symbol + " " + rightPredicate.getRepresentation() + ")";
    }
}
