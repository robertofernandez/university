package studio.sodhium.academic.math.sets;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import studio.sodhium.academic.math.sets.operations.MemeberOf;
import studio.sodhium.academic.math.sets.operations.NotMemeberOf;
import studio.sodhium.academic.math.sets.operations.Subset;
import studio.sodhium.academic.utils.LaTexUtils;

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
        a = new FiniteSet<>("A", new IntegersTextRangeBuilder(0, 1));
        b = new FiniteSet<>("B", new CommaSeparatedStringsFiniteSet("0, 1, 2, 3, 4, 5, 6, 7, 8, 9, A, B, C, D, E, F"));
        c = new FiniteSet<>("C", new IntegersTextRangeBuilder(0, 7));
        d = new FiniteSet<>("D", new DefinedCharactersFiniteSet("0123456789ABCDEF"));
        e = new FiniteSet<>("E", new IntegersTextRangeBuilder(0, 1));
        f = new FiniteSet<>("F", new IntegersTextRangeBuilder(0, 7));
        g = new FiniteSet<>("G", new FiniteSetBuilder<String>() {
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
        h = new FiniteSet<>("H", new DefinedCharactersFiniteSet("asdfghjkl"));
        i = new FiniteSet<>("I", new IntegersTextRangeBuilder(0, 9));
        j = new FiniteSet<>("J", new DefinedCharactersFiniteSet("zxcvbnm"));
        k = new FiniteSet<>("K", new FiniteSetBuilder<String>() {
            @Override
            public ArrayList<SetElement<String>> generate() {
                ArrayList<SetElement<String>> output = new ArrayList<>();
                for (int i = 10; i < 100; i += 5) {
                    output.add(new SetElement<String>("" + i, "" + i));
                }
                return output;
            }
        });
        l = new FiniteSet<>("L", new FiniteSetBuilder<String>() {
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
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println(g);
        System.out.println(h);
        System.out.println(i);
        System.out.println(j);
        System.out.println(k);
        System.out.println(l);
    }

    @Test
    public void ejercicioB() {
        System.out.println(LaTexUtils.printLaTexEcuation(h.toString()));
        System.out.println(LaTexUtils.printLaTexEcuation(i.toString()));
        System.out.println(LaTexUtils.printLaTexEcuation(j.toString()));
        System.out.println(LaTexUtils.printLaTexEcuation(k.toString()));
        System.out.println(LaTexUtils.printLaTexEcuation(l.toString()));
    }

    @Test
    public void ejercicioC() {
//        1. 2 ϵ A _____
        System.out.println(MemeberOf.create("2", a).completeLaTex());
//        2. 9 ∉ C _____
        System.out.println(NotMemeberOf.create("9", c).completeLaTex());
//        3. D ϵ D _____
        System.out.println(MemeberOf.create("D", d).completeLaTex());
//        4. z ϵ G _____
        System.out.println(MemeberOf.create("z", g).completeLaTex());
//        5. 1 ϵ A _____
        System.out.println(MemeberOf.create("1", a).completeLaTex());
//        6. 3 ϵ C _____
        System.out.println(MemeberOf.create("3", c).completeLaTex());
//        7. 45 ϵ L _____
        System.out.println(MemeberOf.create("45", l).completeLaTex());
    }

    @Test
    public void ejercicioD() {
        //faltaria graficamente
//            1. B ꓵ F
        System.out.println(LaTexUtils.printLaTexEcuation(b.intersection(f).toString()));
//            2. H ꓴ I
        System.out.println(LaTexUtils.printLaTexEcuation(h.union(i).toString()));
//            3. B – F
        System.out.println(LaTexUtils.printLaTexEcuation(b.difference(f).toString()));
//            4. H ꓵ B
        System.out.println(LaTexUtils.printLaTexEcuation(h.intersection(b).toString()));
//            5. J ꓴ D
        System.out.println(LaTexUtils.printLaTexEcuation(j.union(d).toString()));
//            6. F – E
        System.out.println(LaTexUtils.printLaTexEcuation(f.difference(e).toString()));
//            7. A ꓵ H
        System.out.println(LaTexUtils.printLaTexEcuation(a.intersection(h).toString()));
    }

    @Test
    public void ejercicioE() {
//            A = {x/x es letra de la palabra camión}.
        a = new FiniteSet<>("A", new DefinedCharactersFiniteSet("camion"));
//            B = { x/x es vocal}.
        b = new FiniteSet<>("B", new DefinedCharactersFiniteSet("aeiou"));
//            C = {x/x es letra de la palabra almidón}.
        c = new FiniteSet<>("C", new DefinedCharactersFiniteSet("almidon"));
//            1. Defina los conjuntos A, B y C por extensión y represente en diagramas de Venn,
        System.out.println(LaTexUtils.printLaTexEcuation(a.toString()));
        System.out.println(LaTexUtils.printLaTexEcuation(b.toString()));
        System.out.println(LaTexUtils.printLaTexEcuation(c.toString()));
//            2. Conteste verdadero o falso y justifique:
        FiniteSet<String> a_1 = new FiniteSet<>("A_1", new DefinedCharactersFiniteSet("mo"));
        System.out.println(LaTexUtils.printLaTexEcuation(a_1.toString()));
        System.out.println(Subset.create(a_1, a).laTexJustification());
//            i. {m, o} ⊂ A
//            ii. camion ∈ A
//            iii. {c, a, s} – B ⊂ A
//            iv. i ∈ C
//            v. ∅ ⊂ B
//            vi. ∅ ∈ A
//            vii. A ⊂ A
//            viii. B ∈ B
        
    }
}
