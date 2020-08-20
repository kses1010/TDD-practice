package password.meter;

public class PasswordStrengthMeter {
    public PasswordStrength meter(String s) {
        if (s == null || s.isEmpty()) {
            return PasswordStrength.INVALID;
        }
        if (s.length() < 8) {
            return PasswordStrength.NORMAL;
        }
        boolean containsNumber = meetsContainNumber(s);
        if (!containsNumber) {
            return PasswordStrength.NORMAL;
        }
        boolean containsUpperCase = meetsContainUppercase(s);
        if (!containsUpperCase) {
            return PasswordStrength.NORMAL;
        }
        return PasswordStrength.STRONG;
    }

    private boolean meetsContainNumber(String s) {
        for (char ch : s.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                return true;
            }
        }
        return false;
    }

    private boolean meetsContainUppercase(String s) {
        for (char ch : s.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                return true;
            }
        }
        return false;
    }

}
