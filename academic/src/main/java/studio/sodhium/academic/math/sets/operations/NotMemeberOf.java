package studio.sodhium.academic.math.sets.operations;

import studio.sodhium.academic.math.sets.FiniteSet;

public class NotMemeberOf extends ElementSetOperation<String> {

    public static NotMemeberOf create(String element, FiniteSet<String> set) {
        return new NotMemeberOf(element, set);
    }

    public NotMemeberOf(String element, FiniteSet<String> set) {
        super(element, set, "\\notin");
    }

    @Override
    public String result() {
        if (set.isMember(element)) {
            return "F";
        } else {
            return "V";
        }
    }

}
