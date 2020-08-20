package password.meter;

public class PasswordStrengthMeter {
    public PasswordStrength meter(String s) {
        if (s.length() < 8) {
            return PasswordStrength.NORMAL;
        }
        boolean containsNumber = false;
        for (char ch : s.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                containsNumber = true;
                break;
            }
        }
        if (!containsNumber) {
            return PasswordStrength.NORMAL;
        }
        return PasswordStrength.STRONG;
    }
}
