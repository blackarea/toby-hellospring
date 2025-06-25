package tobyspring.hellospring.payment;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static org.assertj.core.api.Assertions.assertThat;

class PaymentServiceTest {

    Clock clock;

    @BeforeEach
    void beforeEach(){
        this.clock = Clock.fixed(Instant.now(), ZoneId.systemDefault());
    }

    @Test
    @DisplayName("prepare 메소드가 유구사항 3가지를 잘 충족했는지 검증")
    void convertedAmount() throws IOException {
        testPayment(BigDecimal.valueOf(500), BigDecimal.valueOf(5000), clock);
        testPayment(BigDecimal.valueOf(1000), BigDecimal.valueOf(10000), clock);
    }

    @Test
    void validUntil() throws IOException {
        PaymentService paymentService = new PaymentService(new ExRateProviderStub(BigDecimal.valueOf(1000)), clock);
        Payment payment = paymentService.prepare(1L, "USD", BigDecimal.TEN);

        LocalDateTime now = LocalDateTime.now(clock);

        Assertions.assertThat(payment.getValidUntil()).isEqualTo(now.plusMinutes(30));
    }

    private static void testPayment(BigDecimal exRate, BigDecimal convertedAmount, Clock clock) throws IOException {
        PaymentService paymentService = new PaymentService(new ExRateProviderStub(exRate), clock);
        Payment payment = paymentService.prepare(1L, "USD", BigDecimal.TEN);

        assertThat(payment.getExRate()).isEqualByComparingTo(exRate); // 환율정보 가져온다.
        assertThat(payment.getConvertedAmount()).isEqualByComparingTo(convertedAmount); // 원화환산금액 계산
    }

}