package test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class GrammarTestTest {
    @Test
    @Disabled("TODO: This test is incomplete")
    void testCheckInitialAxiomValue() {
        // TODO: This test is incomplete.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at test.GrammarTest.checkInitialAxiomValue(GrammarTest.java:32)
        //   In order to prevent checkInitialAxiomValue()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   checkInitialAxiomValue().
        //   See https://diff.blue/R013 to resolve this issue.

        (new GrammarTest()).checkInitialAxiomValue();
    }
}

