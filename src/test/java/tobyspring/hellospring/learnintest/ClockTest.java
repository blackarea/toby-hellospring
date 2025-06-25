package tobyspring.hellospring.learnintest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static org.assertj.core.api.Assertions.assertThat;

public class ClockTest {

    @Test
    void clock() throws InterruptedException {
        Clock clock = Clock.systemDefaultZone();

        LocalDateTime dt1 = LocalDateTime.now(clock);
        Thread.sleep(1);
        LocalDateTime dt2 = LocalDateTime.now(clock);
        assertThat(dt2).isAfter(dt1);

    }

    @Test
    void fixedClock() throws InterruptedException {
        Clock clock = Clock.fixed(Instant.now(), ZoneId.systemDefault());

        LocalDateTime dt1 = LocalDateTime.now(clock);
        Thread.sleep(1);
        LocalDateTime dt2 = LocalDateTime.now(clock);
        LocalDateTime dt3 = LocalDateTime.now(clock).plusHours(1);

        assertThat(dt1).isEqualTo(dt2);
        assertThat(dt3).isEqualTo(dt2.plusHours(1));
    }
}
