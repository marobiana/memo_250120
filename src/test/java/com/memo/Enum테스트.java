package com.memo;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class Enum테스트 {

    public enum CalcType {
        // 열거형 정의
        CALC_A(value -> value),
        CALC_B(value -> value * 10),
        CLAC_C(value -> value * 3),
        CLAC_ETC(value -> 0);

        // enum에 정의된 필드(function)
        private Function<Integer, Integer> expression;

        // 생성자
        CalcType(Function<Integer, Integer> expression) {
            this.expression = expression;
        }

        // 계산 적용 메소드
        public int caculate(int value) {
            return expression.apply(value);
        }
    }

    @Test
    void calc_테스트() {
        // given
        CalcType ct = CalcType.CLAC_C;

        // when
        int result = ct.caculate(500);

        // then
        assertEquals(1500, result);
    }

    @Getter
    public enum Status {
        // 열거형 정의
        Y(1, true),   // 생성자 호출하는 중
        N(0, false);

        // enum에 정의된 항목 필드
        private int value1;
        private boolean value2;

        // 생성자
        Status(int value1, boolean value2) {
            this.value1 = value1;
            this.value2 = value2;
        }
    }

    @Test
    void status_테스트() {
        // given-준비
        Status status = Status.Y;

        // when-실행
        int v1 = status.getValue1();
        boolean v2 = status.isValue2();

        // then-검증
        assertEquals(1, v1);
        assertEquals(true, v2);
        assertEquals(Status.Y, status);
    }
}
