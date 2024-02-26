package studio.sodhium.academic.math.logic.operations;

import studio.sodhium.academic.math.logic.BinaryOperationPredicate;
import studio.sodhium.academic.math.logic.Predicate;

public class ImpliesOperation extends BinaryOperationPredicate {

    public ImpliesOperation(Predicate leftPredicate, Predicate rightPredicate) {
        super("\\implies", leftPredicate, rightPredicate);
    }

    @Override
    public Integer solve() {
        if(getLeftPredicate().solve().intValue() == 1 && getRightPredicate().solve().intValue() == 0) {
            return 0;
        }
        return 1;
    }

}
