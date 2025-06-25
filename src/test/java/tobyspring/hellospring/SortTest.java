package tobyspring.hellospring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SortTest {
    Sort sort;

    @BeforeEach
    void beforeEach() {
        sort = new Sort();
    }

    @Test
    void sort() {
        List<String> list = sort.sortByLength(Arrays.asList("aa", "b"));

        assertThat(list).isEqualTo(Arrays.asList("b", "aa"));
    }

    @Test
    void sort3Items() {
        List<String> list = sort.sortByLength(Arrays.asList("aa", "b", "ccc"));

        assertThat(list).isEqualTo(Arrays.asList("b", "aa", "ccc"));
    }

}