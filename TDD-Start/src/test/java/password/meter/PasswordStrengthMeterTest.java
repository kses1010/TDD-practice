package password.meter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordStrengthMeterTest {

    @Test
    @DisplayName("모든 조건 충족이면 강함")
    void meetsAllCriteria() {
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("ab12!@AB");
        assertEquals(PasswordStrength.STRONG, result);
    }

    @Test
    @DisplayName("길이8글자 미만 나머지조건 충족이면 보통")
    void meetsOtherCriteria_except_for_Length() {
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("ab12!@A");
        PasswordStrength result2 = meter.meter("ab12!@");

        assertEquals(PasswordStrength.NORMAL, result);
        assertEquals(PasswordStrength.NORMAL, result2);
    }

    @Test
    @DisplayName("숫자포함하지 않고 나머지조건 충족이면 보통")
    void meetsOtherCriteria_except_for_number() {
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("ab!@ABqwer");
        assertEquals(PasswordStrength.NORMAL, result);
    }
}
