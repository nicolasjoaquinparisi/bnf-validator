package test;

import main.grammar.SymbolCollection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SymbolCollectionTest {

    private SymbolCollection underTest;

    @BeforeEach
    void setUp() {
        this.underTest = new SymbolCollection("N");
    }

    @Test
    void cantAddSymbolDueInvalidFormat() {
        // Given
        String symbol = "digit";

        // When
        boolean expected = underTest.add(symbol);

        // Then
        Assertions.assertFalse(expected);
    }

    @Test
    void checkCantAddDuplicatesSymbols() {
        // Given
        String symbol = "<digit>";

        // When
        underTest.add(symbol);
        boolean expected = underTest.add(symbol);

        // Then
        Assertions.assertFalse(expected);
    }

    @Test
    void checkGetOneSymbolFormat() {
        // Given
        String symbol = "<digit>";

        // When
        underTest.add(symbol);

        // Then
        Assertions.assertEquals(underTest.getAll(), "N = {<digit>}");
    }
}
