package studio.sodhium.academic.math.sets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class FiniteSet<T> {
    private HashMap<String, SetElement<T>> elements;
    private String name;

    public FiniteSet(String name) {
        this.name = name;
        elements = new HashMap<>();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public FiniteSet(String name, FiniteSetBuilder<T> builder) {
        this.name = name;
        elements = new HashMap<>();
        init(builder);
    }

    public String getName() {
        return name;
    }

    public FiniteSet<T> union(FiniteSet<T> setToAdd) {
        FiniteSet<T> output = new FiniteSet<>(name + " \\cup " + setToAdd.name);
        output.elements = new HashMap<>();
        output.elements.putAll(elements);
        output.elements.putAll(setToAdd.elements);
        return output;
    }

    public FiniteSet<T> intersection(FiniteSet<T> setToIntersect) {
        FiniteSet<T> output = new FiniteSet<>(name + " \\cap " + setToIntersect.name);
        output.elements = new HashMap<>();
        for (Entry<String, SetElement<T>> entry : elements.entrySet()) {
            if (setToIntersect.elements.containsKey(entry.getKey())) {
                output.elements.put(entry.getKey(), entry.getValue());
            }
        }
        return output;
    }

    public FiniteSet<T> difference(FiniteSet<T> setToSustract) {
        FiniteSet<T> output = new FiniteSet<>(name + " - " + setToSustract.name);
        output.elements = new HashMap<>();
        for (Entry<String, SetElement<T>> entry : elements.entrySet()) {
            if (!setToSustract.elements.containsKey(entry.getKey())) {
                output.elements.put(entry.getKey(), entry.getValue());
            }
        }
        return output;
    }

    public boolean isMember(String input) {
        return elements.containsKey(input);
    }

    protected void init(FiniteSetBuilder<T> builder) {
        ArrayList<SetElement<T>> generated = builder.generate();
        for (SetElement<T> element : generated) {
            elements.put(element.getRepresentation(), element);
        }
    }

    public String asText() {
        if (elements.isEmpty()) {
            return "\\emptyset";
        }

        String output = "{";
        String separator = "";
        for (SetElement<T> element : elements.values()) {
            output += separator + element.getRepresentation();
            separator = ", ";
        }
        output += "}";
        return output;
    }

    @Override
    public String toString() {
        return name + " = " + asText();
    }

}
