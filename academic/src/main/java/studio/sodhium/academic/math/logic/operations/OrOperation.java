package studio.sodhium.academic.math.logic.operations;

import studio.sodhium.academic.math.logic.BinaryOperationPredicate;
import studio.sodhium.academic.math.logic.Predicate;

public class OrOperation extends BinaryOperationPredicate {

    public OrOperation(Predicate leftPredicate, Predicate rightPredicate) {
        super("\\lor", leftPredicate, rightPredicate);
    }

    @Override
    public Integer solve() {
        return Math.max(getLeftPredicate().solve(), getRightPredicate().solve());
    }

}
