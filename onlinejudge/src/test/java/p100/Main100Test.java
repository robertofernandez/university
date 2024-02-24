package p100;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Main100Test {

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
    public void testThreeNPlusOneSequenceLength() {
        System.out.println(Main.threeNPlusOneSequenceLength(22));
        System.out.println(Main.threeNPlusOneSequenceLength(9));
    }
    
    @Test
    public void test() {
        HashMap<Long, Long> calculated = new HashMap<>();
        Main.completeThreeNPlusOneSequenceLength(22, calculated);
        System.out.println(calculated);
    }
    
    @Test
    public void test2() {
        HashMap<Long, Long> calculated = new HashMap<>();
        Main.completeThreeNPlusOneSequenceLength(3, calculated);
        System.out.println(calculated);
    }

}
