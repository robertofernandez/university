package studio.sodhium.academic.utils;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BinaryGeneratorTest {

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
    public void testGenerateBinary() {
        System.out.println(BinaryGenerator.generateBinary(3));
        System.out.println(BinaryGenerator.generateBinary(4));
        System.out.println(BinaryGenerator.generateBinary(5));
    }

}
