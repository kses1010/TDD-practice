package password.meter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordStrengthMeterTest {
    private final PasswordStrengthMeter meter = new PasswordStrengthMeter();

    private void assertStrength(PasswordStrength expStr, String password) {
        PasswordStrength result = meter.meter(password);
        assertEquals(expStr, result);
    }

    @Test
    @DisplayName("모든 조건 충족이면 강함")
    void meetsAllCriteria() {
        assertStrength(PasswordStrength.STRONG, "ab12!@ABC");
    }


    @Test
    @DisplayName("길이8글자 미만 나머지조건 충족이면 보통")
    void meetsOtherCriteria_except_for_Length() {
        assertStrength(PasswordStrength.NORMAL, "ab12!@A");
        assertStrength(PasswordStrength.NORMAL, "ab12!@");
    }

    @Test
    @DisplayName("숫자포함하지 않고 나머지조건 충족이면 보통")
    void meetsOtherCriteria_except_for_number() {
        assertStrength(PasswordStrength.NORMAL, "ab!@ABqwer");
    }

    @Test
    @DisplayName("null이면 INVALID 리턴")
    void nullInput_Then_Invalid() {
        assertStrength(PasswordStrength.INVALID, null);
    }

    @Test
    @DisplayName("빈 문자열이면 INVALID 리턴")
    void emptyInput_Then_Invalid() {
        assertStrength(PasswordStrength.INVALID, "");
    }

    @Test
    @DisplayName("대문자를 포함하지 않은 나머지조건 충족이면 보통")
    void meetsOtherCriteria_except_for_Uppercase() {
        assertStrength(PasswordStrength.NORMAL, "ab12!@df");
    }

    @Test
    @DisplayName("길이가 8글자 이상인 조건만 충족이면 약함")
    void meetsOnlyLengthCriteria() {
        assertStrength(PasswordStrength.WEAK, "abcdefgh");
    }
}
