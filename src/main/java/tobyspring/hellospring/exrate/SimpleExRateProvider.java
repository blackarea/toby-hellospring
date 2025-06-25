package tobyspring.hellospring.exrate;

import tobyspring.hellospring.payment.ExRateProvider;

import java.math.BigDecimal;

public class SimpleExRateProvider implements ExRateProvider {

    @Override
    public BigDecimal getExRate(String currency) {
        if (currency.equals("USD")) return BigDecimal.valueOf(1000);
        throw new IllegalArgumentException("only USD support, your currency is " + currency);
    }

}
