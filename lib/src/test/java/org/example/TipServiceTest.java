package org.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TipServiceTest {

    private final TipService tipService = new TipService();

    private BigDecimal amount;
    private BigDecimal expected;

    public TipServiceTest(BigDecimal amount, BigDecimal expected) {
        this.amount = amount;
        this.expected = expected;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { BigDecimal.valueOf(500), BigDecimal.valueOf(550) },
                { BigDecimal.valueOf(1000), BigDecimal.valueOf(1050) },
                { BigDecimal.valueOf(1500), BigDecimal.valueOf(1575) }
        });
    }

    @Test
    public void testRoundTips() {
        BigDecimal result = tipService.roundTips(amount);
        assertEquals(0, expected.compareTo(result));
    }
}