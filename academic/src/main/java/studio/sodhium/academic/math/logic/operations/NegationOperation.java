package studio.sodhium.academic.math.logic.operations;

import studio.sodhium.academic.math.logic.Predicate;
import studio.sodhium.academic.math.logic.UnaryOperationPredicate;

public class NegationOperation extends UnaryOperationPredicate {

    public NegationOperation(Predicate subPredicate) {
        super("\\neg", subPredicate);
    }

    @Override
    public Integer solve() {
        return (getSubPredicate().solve() + 1) % 2;
    }

    @Override
    public String getRepresentation() {
        return getSymbol() + " " + getSubPredicate().getRepresentation();
    }

}
