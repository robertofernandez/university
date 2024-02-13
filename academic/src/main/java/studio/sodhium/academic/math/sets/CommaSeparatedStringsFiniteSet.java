package studio.sodhium.academic.math.sets;

import java.util.ArrayList;

import ar.com.sodhium.commons.strings.StringUtils;

public class CommaSeparatedStringsFiniteSet implements FiniteSetBuilder<String> {
    private String input;

    public CommaSeparatedStringsFiniteSet(String input) {
        this.input = input;
    }

    @Override
    public ArrayList<SetElement<String>> generate() {
        ArrayList<SetElement<String>> output = new ArrayList<>();
        if (StringUtils.isNotBlank(input)) {
            String[] splitted = input.split(",");
            for (String element : splitted) {
                output.add(new SetElement<String>(element.trim(), element.trim()));
            }
        }
        return output;
    }

}
