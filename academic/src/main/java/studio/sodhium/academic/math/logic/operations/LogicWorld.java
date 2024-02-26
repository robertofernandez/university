package studio.sodhium.academic.math.logic.operations;

import java.util.ArrayList;
import java.util.HashMap;

import studio.sodhium.academic.math.logic.LiteralPredicate;
import studio.sodhium.academic.math.logic.Predicate;
import studio.sodhium.academic.utils.BinaryGenerator;

public class LogicWorld {

    private HashMap<String, LiteralPredicate> literals;
    private Predicate mainPredicate;

    public LogicWorld() {
        literals = new HashMap<>();
    }

    public HashMap<String, LiteralPredicate> getLiterals() {
        return literals;
    }

    public Predicate getMainPredicate() {
        return mainPredicate;
    }

    public void setMainPredicate(Predicate mainPredicate) {
        this.mainPredicate = mainPredicate;
    }

    public ArrayList<Integer> solveForAllCombinations() {
        ArrayList<Integer> output = new ArrayList<>();
        ArrayList<String> binaryCombinations = BinaryGenerator.generateBinary(literals.size());
        ArrayList<LiteralPredicate> literalsList = new ArrayList<>();
        literalsList.addAll(literals.values());
        for (String combination : binaryCombinations) {
            output.add(solveCombination(combination, literalsList));
        }
        return output;
    }

    public boolean isTautology() {
        ArrayList<String> binaryCombinations = BinaryGenerator.generateBinary(literals.size());
        ArrayList<LiteralPredicate> literalsList = new ArrayList<>();
        literalsList.addAll(literals.values());
        for (String combination : binaryCombinations) {
            if(solveCombination(combination, literalsList).intValue() == 0 ) {
                return false;
            }
        }
        return true;
    }

    private Integer solveCombination(String combination, ArrayList<LiteralPredicate> literalsList) {
        for(int i = 0; i<combination.length(); i++) {
            String element= "" + combination.charAt(i);
            literalsList.get(i).setValue(Integer.parseInt(element));
        }
        return mainPredicate.solve();
    }
}
