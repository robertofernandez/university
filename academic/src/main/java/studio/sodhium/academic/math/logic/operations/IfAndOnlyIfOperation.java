package studio.sodhium.academic.math.logic.operations;

import studio.sodhium.academic.math.logic.BinaryOperationPredicate;
import studio.sodhium.academic.math.logic.Predicate;

public class IfAndOnlyIfOperation extends BinaryOperationPredicate {

    public IfAndOnlyIfOperation(Predicate leftPredicate, Predicate rightPredicate) {
        super("\\iff", leftPredicate, rightPredicate);
    }

    @Override
    public Integer solve() {
        return getLeftPredicate().solve().equals(getRightPredicate().solve()) ? 1 : 0;
    }

}
