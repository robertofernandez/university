package studio.sodhium.academic.math.sets.operations;

import studio.sodhium.academic.math.sets.FiniteSet;
import studio.sodhium.academic.utils.LaTexUtils;

public class Subset<T> extends SetToSetOperation<T> {
    private FiniteSet<T> set1;
    private FiniteSet<T> set2;

    public static Subset<String> create(FiniteSet<String> set1, FiniteSet<String> set2) {
        return new Subset<>(set1, set2);
    }

    public Subset(FiniteSet<T> set1, FiniteSet<T> set2) {
        super(set1, set2, "\\subset");
        this.set1 = set1;
        this.set2 = set2;
    }

    @Override
    public String result() {
        boolean emptyDiff1 = set1.difference(set2).isEmpty();
        boolean emptyDiff2 = set2.difference(set1).isEmpty();
        String output = "F";
        if (emptyDiff1 && !emptyDiff2) {
            output = "V";
        }
        return output;
    }

    @Override
    public String justification() {
        return LaTexUtils.escapeLaTexBrackets(set1.difference(set2).toString()) + " \\land "
                + LaTexUtils.escapeLaTexBrackets(set2.difference(set1).toString());
    }

}
