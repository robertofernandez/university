package studio.sodhium.academic.math.sets;

import java.util.ArrayList;

import ar.com.sodhium.commons.strings.StringUtils;

public class DefinedCharactersFiniteSet implements FiniteSetBuilder<String> {
    private String input;

    public DefinedCharactersFiniteSet(String input) {
        this.input = input;
    }

    @Override
    public ArrayList<SetElement<String>> generate() {
        ArrayList<SetElement<String>> output = new ArrayList<>();
        if (StringUtils.isNotBlank(input)) {
            for (char c : input.toCharArray()) {
                String inputChar = "" + c;
                output.add(new SetElement<String>(inputChar, inputChar));
            }
        }
        return output;
    }

}
