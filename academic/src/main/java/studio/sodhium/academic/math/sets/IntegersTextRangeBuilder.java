package studio.sodhium.academic.math.sets;

import java.util.ArrayList;

public class IntegersTextRangeBuilder implements FiniteSetBuilder<String> {
    private Integer min;
    private Integer max;

    public IntegersTextRangeBuilder(Integer min, Integer max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public ArrayList<SetElement<String>> generate() {
        ArrayList<SetElement<String>> output = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            output.add(new SetElement<String>("" + i, "" + i));
        }
        return output;
    }

}
