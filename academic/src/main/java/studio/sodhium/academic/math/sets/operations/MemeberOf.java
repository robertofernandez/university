package studio.sodhium.academic.math.sets.operations;

import studio.sodhium.academic.math.sets.FiniteSet;

public class MemeberOf extends ElementSetOperation<String> {

    public static MemeberOf create(String element, FiniteSet<String> set) {
        return new MemeberOf(element, set);
    }
    
    public MemeberOf(String element, FiniteSet<String> set) {
        super(element, set, "\\in");
    }

    @Override
    public String result() {
        if (set.isMember(element)) {
            return "V";
        } else {
            return "F";
        }
    }

}
