package studio.sodhium.academic.math.sets;

import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EjerciciosTeoriaDeConjuntos {
//    A = {x/x es dígito del sistema de numeración binario}
    private FiniteSet<String> a;

//    B = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, A, B, C, D, E, F}
    private FiniteSet<String> b;

//    C = {x/x es dígito del sistema de numeración octal}
    private FiniteSet<String> c;

//    D = {x/x es dígito del sistema de numeración hexadecimal}
    private FiniteSet<String> d;

//    E = {0, 1}
    private FiniteSet<String> e;

//    F = {0, 1, 2, 3, 4, 5, 6, 7}
    private FiniteSet<String> f;

//    G = {x/x es letra minúscula del código ASCII}
    private FiniteSet<String> g;

//    H = {x/x es letra de la fila guía del teclado QWERTY}
    private FiniteSet<String> h;

//    I = {x/x es dígito de la fila superior del teclado QWERTY}
    private FiniteSet<String> i;

//    J = {x/x es letra de la fila inferior del teclado QWERTY}
    private FiniteSet<String> j;

//    K = {x/x es número natural de dos dígitos múltiplo de 5}
    private FiniteSet<String> k;

//    L = {x/x es número natural de dos dígitos divisible por 7}
    private FiniteSet<String> l;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        a = new FiniteSet<>(new IntegersTextRangeBuilder(0, 1));
        b = new FiniteSet<>(new CommaSeparatedStringsFiniteSet("0, 1, 2, 3, 4, 5, 6, 7, 8, 9, A, B, C, D, E, F"));
        c = new FiniteSet<>(new IntegersTextRangeBuilder(0, 7));
        d = new FiniteSet<>(new DefinedCharactersFiniteSet("0123456789ABCDEF"));
        e = new FiniteSet<>(new IntegersTextRangeBuilder(0, 1));
        f = new FiniteSet<>(new IntegersTextRangeBuilder(0, 7));
        g = new FiniteSet<>(new FiniteSetBuilder<String>() {
            @Override
            public ArrayList<SetElement<String>> generate() {
                ArrayList<SetElement<String>> output = new ArrayList<>();
                for (char chr = 'a'; chr <= 'z'; chr++) {
                    if (Character.isLowerCase(chr)) {
                        output.add(new SetElement<String>("" + chr, "" + chr));
                    }
                }
                return output;
            }
        });
        h = new FiniteSet<>(new DefinedCharactersFiniteSet("asdfghjkl"));
        i = new FiniteSet<>(new IntegersTextRangeBuilder(0, 9));
        j = new FiniteSet<>(new DefinedCharactersFiniteSet("zxcvbnm"));
        k = new FiniteSet<>(new FiniteSetBuilder<String>() {
            @Override
            public ArrayList<SetElement<String>> generate() {
                ArrayList<SetElement<String>> output = new ArrayList<>();
                for (int i = 10; i < 100; i += 5) {
                    output.add(new SetElement<String>("" + i, "" + i));
                }
                return output;
            }
        });
        l = new FiniteSet<>(new FiniteSetBuilder<String>() {
            @Override
            public ArrayList<SetElement<String>> generate() {
                ArrayList<SetElement<String>> output = new ArrayList<>();
                for (int i = 14; i < 100; i += 7) {
                    output.add(new SetElement<String>("" + i, "" + i));
                }
                return output;
            }
        });
        
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void printSets() {
        System.out.print("A = ");
        System.out.println(a);
        System.out.print("B = ");
        System.out.println(b);
        System.out.print("C = ");
        System.out.println(c);
        System.out.print("D = ");
        System.out.println(d);
        System.out.print("E = ");
        System.out.println(e);
        System.out.print("F = ");
        System.out.println(f);
        System.out.print("G = ");
        System.out.println(g);
        System.out.print("H = ");
        System.out.println(h);
        System.out.print("I = ");
        System.out.println(i);
        System.out.print("J = ");
        System.out.println(j);
        System.out.print("K = ");
        System.out.println(k);
        System.out.print("L = ");
        System.out.println(l);
    }

    @Test
    public void testIntersection() {
        fail("Not yet implemented");
    }

    @Test
    public void testDifference() {
        fail("Not yet implemented");
    }

}
