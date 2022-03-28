package test;

import main.grammar.Grammar;
import main.grammar.SymbolCollection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class GrammarTest {

    private Grammar underTest;

    @BeforeEach
    void setUp() {
        underTest = new Grammar();
    }

    @Test
    void checkAddedNoTerminalsWithoutAxiom() {
        // Given
        String noTerminal = "<digit>";

        // When
        underTest.addNoTerminal(noTerminal);

        // Then
        Assertions.assertEquals(underTest.getNoTerminals(), "N = {<digit>}");
    }

    @Test
    void checkInitialAxiomValue() {
        Assertions.assertEquals(underTest.getAxiom(), "S = {}");
    }

    @Test
    void checkWhenAddInvalidAxiom() {
        // Given
        String axiom = "integer";

        // When
        boolean expected = underTest.setAxiom(axiom);

        // Then
        Assertions.assertFalse(expected);
    }

    @Test
    void checkValidAxiom() {
        // Given
        String axiom = "<integer>";

        // When
        underTest.setAxiom(axiom);

        // Then
        Assertions.assertEquals(underTest.getAxiom(), "S = {<integer>}");
    }

    @Test
    void checkCheckAddedNoTerminalsWithAxiom() {
        // Given
        String axiom = "<integer>";
        String noTerminal = "<digit>";

        // When
        underTest.setAxiom(axiom);
        underTest.addNoTerminal(noTerminal);

        // Then
        Assertions.assertEquals(underTest.getNoTerminals(), "N = {<integer>, <digit>}");
    }

    @Test
    void checkIsValidProduction() {
        // Given
        underTest.setAxiom("<integer>");
        underTest.addNoTerminal("<digit>");

        String integerProductionId = "<integer>";
        String integerProductionDescription = "<digit>|<digit><integer>";

        // When
        boolean expected = underTest.addProduction(integerProductionId, integerProductionDescription);

        // Then
        Assertions.assertTrue(expected);
    }

    @Test
    void validateSymbolsExtractedFromString() {
        // Given
        String symbols = "<digit>|<digit><integer>";

        Set<String> givenSymbols = new LinkedHashSet<>();
        givenSymbols.add("<digit>");
        givenSymbols.add("<integer>");

        // When
        Set<String> expected = underTest.getSymbolsFromString(symbols);

        // Then
        Assertions.assertTrue(expected.containsAll(givenSymbols));
    }

    @Test
    void grammarContainsSymbols() {
        // Given
        underTest.setAxiom("<integer>");

        Set<String> symbols = new LinkedHashSet<String>();
        symbols.add("<integer>");

        // When
        boolean expected = underTest.validateSymbols(symbols);

        // Then
        Assertions.assertTrue(expected);
    }

    @Test
    @Disabled
    void checkIsValidGrammar() {
        // Given
        SymbolCollection noTerminals = new SymbolCollection("N");
        noTerminals.add("<integer>");
        noTerminals.add("<digit>");

        SymbolCollection terminals = new SymbolCollection("T");
        String axiom;

        // When
    }

    @Test
    @Disabled
    void validateSemanticalTree() {}
}
