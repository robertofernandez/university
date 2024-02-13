package studio.sodhium.academic.math.sets;

import java.util.ArrayList;

public interface FiniteSetBuilder<T> {
    ArrayList<SetElement<T>> generate();
}
