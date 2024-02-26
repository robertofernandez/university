package studio.sodhium.academic.math.logic;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import studio.sodhium.academic.math.logic.operations.AndOperation;
import studio.sodhium.academic.math.logic.operations.IfAndOnlyIfOperation;
import studio.sodhium.academic.math.logic.operations.ImpliesOperation;
import studio.sodhium.academic.math.logic.operations.LogicWorld;
import studio.sodhium.academic.math.logic.operations.NegationOperation;
import studio.sodhium.academic.math.logic.operations.OrOperation;
import studio.sodhium.academic.utils.LaTexUtils;

public class LogicOperationsExercices {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() {
        LiteralPredicate p = new LiteralPredicate("p", 0);
        LiteralPredicate q = new LiteralPredicate("q", 0);
        
        NegationOperation op2 = new NegationOperation(q);
        
        IfAndOnlyIfOperation operation = new IfAndOnlyIfOperation(p, op2);
        
        System.out.println(operation.getRepresentation());
        System.out.println(operation.solve());
    }

    @Test
    public void ejercicioEpunto1() {
        LiteralPredicate p = new LiteralPredicate("p", 0);
        LiteralPredicate q = new LiteralPredicate("q", 0);
        LiteralPredicate r = new LiteralPredicate("r", 0);

        LogicWorld world = new LogicWorld();

        world.getLiterals().put("p", p);
        world.getLiterals().put("q", q);
        world.getLiterals().put("r", r);

        AndOperation qANDr = new AndOperation(q, r);
        ImpliesOperation conclusion = new ImpliesOperation(p, qANDr);
        
        ImpliesOperation op1 = new ImpliesOperation(p, q);
        OrOperation  op2 = new OrOperation(r, new NegationOperation(p));

        world.setMainPredicate(new ImpliesOperation(new AndOperation(op1, op2), conclusion));
        System.out.println(LaTexUtils.printLaTexEcuation(world.getMainPredicate().getRepresentation()));
        System.out.println(world.isTautology());
    }

}
