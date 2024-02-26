package studio.sodhium.academic.math.logic.operations;

import studio.sodhium.academic.math.logic.BinaryOperationPredicate;
import studio.sodhium.academic.math.logic.Predicate;

public class AndOperation extends BinaryOperationPredicate {

    public AndOperation(Predicate leftPredicate, Predicate rightPredicate) {
        super("\\land", leftPredicate, rightPredicate);
    }

    @Override
    public Integer solve() {
        return Math.min(getLeftPredicate().solve(), getRightPredicate().solve());
    }

}
