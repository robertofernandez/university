package studio.sodhium.academic.math.sets;

import java.util.ArrayList;

public class IntegersRangeBuilder implements FiniteSetBuilder<Integer> {
    private Integer min;
    private Integer max;

    public IntegersRangeBuilder(Integer min, Integer max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public ArrayList<SetElement<Integer>> generate() {
        ArrayList<SetElement<Integer>> output = new ArrayList<>();
        for (int i = min; i < max; i++) {
            output.add(new SetElement<Integer>("" + i, i));
        }
        return output;
    }

}
