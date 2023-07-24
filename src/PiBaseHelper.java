import lombok.extern.slf4j.Slf4j;

/**
 * @author travistran
 */
@Slf4j
public class PiBaseHelper {

    public static final String[] MASKING_PATTERNS = new String[]{
        // Password
        "(?i)(\"password\"\\s*:\\s*\")[^\"]+(\")",
        "(?i)(\"otp\"\\s*:\\s*\")[^\"]+(\")",
        "(?i)(\"pin\"\\s*:\\s*\")[^\"]+(\")",
        "(?i)(password\\s*=\\s*)[^\\s*]+(,)",
        "(?i)(otp\\s*=\\s*)[^\\s*]+(,)",
        "(?i)(pin\\s*=\\s*)[^\\s*]+(,)",
        // Token
        "(?i)(\"token\"\\s*:\\s*\")[^\"]+(\")",
        "(?i)(\"accessToken\"\\s*:\\s*\")[^\"]+(\")",
        "(?i)(\"access_token\"\\s*:\\s*\")[^\"]+(\")",
        "(?i)(\"access-token\"\\s*:\\s*\")[^\"]+(\")",
        "(?i)(\"refreshToken\"\\s*:\\s*\")[^\"]+(\")",
        "(?i)(\"refresh_token\"\\s*:\\s*\")[^\"]+(\")",
        "(?i)(\"refresh-token\"\\s*:\\s*\")[^\"]+(\")",
        "(?i)(token\\s*=\\s*)[^\\s*]+(,)",
        "(?i)(accessToken\\s*=\\s*)[^\\s*]+(,)",
        "(?i)(\\s)[^\\s*]+( la ma xac thuc )",
        // Key
        "(?i)(\"privateKey\"\\s*:\\s*\")[^\"]+(\")",
        "(?i)(\"private_key\"\\s*:\\s*\")[^\"]+(\")",
        "(?i)(\"private-key\"\\s*:\\s*\")[^\"]+(\")",
        "(?i)(\"publicKey\"\\s*:\\s*\")[^\"]+(\")",
        "(?i)(\"public_key\"\\s*:\\s*\")[^\"]+(\")",
        "(?i)(\"public-key\"\\s*:\\s*\")[^\"]+(\")",
        "(?i)(privateKey\\s*=\\s*)[^\\s*]+(,)",
        "(?i)(publicKey\\s*=\\s*)[^\\s*]+(,)",
        // Money
        "(?i)(\"amount\"\\s*:\\s*\")[^\"]+(\")",
        "(?i)(amount\\s*=\\s*)[^\\s*]+(,)",
    };

    /**
     * Mask sensitive data
     *
     * @param message
     * @return
     */
    public static String maskSensitiveData(String message) {
        for (String maskingPattern : MASKING_PATTERNS) {
            message = message.replaceAll(maskingPattern, "$1*****$2");
        }
        return message;
    }
}
