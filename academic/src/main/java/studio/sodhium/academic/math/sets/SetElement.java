package studio.sodhium.academic.math.sets;

public class SetElement<T> {
    private String representation;
    private T value;

    public SetElement(String representation, T value) {
        this.representation = representation;
        this.value = value;
    }

    public String getRepresentation() {
        return representation;
    }

    public T getValue() {
        return value;
    }
    
    @Override
    public String toString() {
        return representation;
    }
}
