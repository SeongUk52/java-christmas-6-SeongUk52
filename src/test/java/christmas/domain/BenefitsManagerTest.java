package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.utils.LocalDateFactory;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BenefitsManagerTest {

    @DisplayName("총 할인률을 계산하는 기능")
    @Test
    void calculateTotalBenefits() {
        assertThat(BenefitsManager.of(LocalDateFactory.createLocalDateFrom("24"),
                70_000 + 60_000 + 15_000, List
                        .of(Dish.from("해산물파스타-2"),
                                Dish.from("레드와인-1"),
                                Dish.from("초코케이크-1"))).calculateTotalBenefits())
                .isEqualTo(3_300 + 2_023 + 1_000 + 25_000);
    }
}
