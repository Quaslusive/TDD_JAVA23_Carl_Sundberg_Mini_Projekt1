package se.TDD;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PrimeNumbersTest {

    private PrimeNumbers primeNumbers;

    @BeforeEach
    void setUp() {
        primeNumbers = new PrimeNumbers();
    }

    @Test
    @DisplayName("Testa om talet är ett primtal")
    void testIsPrime() {
        assertAll("Primtal Test",
                () -> assertTrue(primeNumbers.isPrime(2), "2 är primtal"),
                () -> assertTrue(primeNumbers.isPrime(3), "3 är primtal"),
                () -> assertTrue(primeNumbers.isPrime(997), "997 är primtal"),

                () -> assertFalse(primeNumbers.isPrime(0), "0 är inte primtal"),
                () -> assertFalse(primeNumbers.isPrime(1), "1 är inte primtal"),
                () -> assertFalse(primeNumbers.isPrime(4), "4 är inte primtal")
        );
    }

    @Test
    @DisplayName("Testa primtalsräkning inom intervallet 0 - 10")
    void testCountPrimesInRange() {
        assertAll("Primtalsräkning Test",
                () -> assertEquals(4, primeNumbers.countPrimesInRange(0, 10),
                        "Det borde finnas 4 primtal mellan 0 - 10"),
                () -> assertEquals(25, primeNumbers.countPrimesInRange(0, 100),
                        "Det borde finnas 25 primtal mellan 0 - 100")
        );
    }

    @Test
    @DisplayName("Testa summan av primtal inom intervallet 0 - 10")
    void testSumPrimesInRange() {
        assertAll("Primtalssumma Test",
                () -> assertEquals(17, primeNumbers.sumPrimesInRange(0, 10),
                        "Summan av primtal mellan 0 - 10 är vara 17"),
                () -> assertEquals(76127, primeNumbers.sumPrimesInRange(0, 1000),
                        "Summan av primtal mellan 0 - 1000 borde är 76127")
        );
    }

    @Test
    @DisplayName("Testa ogiltig primal")
    void testInvalidRange() {
        assertAll("ogiltig interval Test",
                () -> assertThrows(IllegalArgumentException.class, () -> {
                    primeNumbers.countPrimesInRange(-1, 1001);
                }, "negativa värden bör kastas ett undantag"),
                () -> assertThrows(IllegalArgumentException.class, () -> {
                    primeNumbers.sumPrimesInRange(500, 400); // Start greater than end
                }, "startvärde som är större än slutvärdet bör kastas ett undantag")
        );
    }
}


