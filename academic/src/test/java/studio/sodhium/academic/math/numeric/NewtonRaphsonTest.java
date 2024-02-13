package studio.sodhium.academic.math.numeric;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import studio.sodhium.academic.math.numeric.NewtonRaphson;

public class NewtonRaphsonTest {

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
    public void testSquares() {
        System.out.println(NewtonRaphson.getSquareRoot(2D, 0.00000001D));
        System.out.println(NewtonRaphson.getSquareRoot(4D, 0.00000001D));
        System.out.println(NewtonRaphson.getSquareRoot(6D, 0.00000001D));
        System.out.println(NewtonRaphson.getSquareRoot(8D, 0.00000001D));
        System.out.println(NewtonRaphson.getSquareRoot(9D, 0.00000001D));
        System.out.println(NewtonRaphson.getSquareRoot(10D, 0.00000001D));
    }
    
    @Test
    public void testImprovedSquares() {
        System.out.println(NewtonRaphson.getSquareRootImprovedForIntegers(2D, 0.00000001D));
        System.out.println(NewtonRaphson.getSquareRootImprovedForIntegers(4D, 0.00000001D));
        System.out.println(NewtonRaphson.getSquareRootImprovedForIntegers(6D, 0.00000001D));
        System.out.println(NewtonRaphson.getSquareRootImprovedForIntegers(8D, 0.00000001D));
        System.out.println(NewtonRaphson.getSquareRootImprovedForIntegers(9D, 0.00000001D));
        System.out.println(NewtonRaphson.getSquareRootImprovedForIntegers(10D, 0.00000001D));
    }

}
