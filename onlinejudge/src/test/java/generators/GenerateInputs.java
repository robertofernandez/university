package generators;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GenerateInputs {

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
    public void generate101() {
        for (int i = 0; i < 200; i++) {
            double x = Math.random();
            String operationPrefix = "move";
            if (x > 0.5D) {
                operationPrefix = "pile";
            }

            double y = Math.random();
            String operationSuffix = "over";
            if (y > 0.5D) {
                operationSuffix = "onto";
            }

            int a = (int) (Math.random() * 24);
            int b = (int) (Math.random() * 24);

            System.out.println(operationPrefix + " " + a + " " + operationSuffix + " " + b);
        }
    }

}
