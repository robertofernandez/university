package studio.sodhium.academic.math.logic;

public class LiteralPredicate extends Predicate {
    private Integer value;
    private String name;

    public LiteralPredicate(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public Integer solve() {
        return value;
    }

    @Override
    public String getRepresentation() {
        return name;
    }
    
    public void setValue(Integer value) {
        this.value = value;
    }
}
