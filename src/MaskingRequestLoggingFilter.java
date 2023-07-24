import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import pibase.spring.core.util.PiBaseHelper;

import javax.servlet.http.HttpServletRequest;

/**
 * @author travistran
 */
public class MaskingRequestLoggingFilter extends CommonsRequestLoggingFilter {

    @Override
    protected String createMessage(HttpServletRequest request, String prefix, String suffix) {
        String message = super.createMessage(request, prefix, suffix);
        if (request instanceof ContentCachingRequestWrapper) {
            ContentCachingRequestWrapper wrappedRequest = (ContentCachingRequestWrapper) request;
            String requestBody = new String(wrappedRequest.getContentAsByteArray());
            String maskedRequestBody = PiBaseHelper.maskSensitiveData(requestBody);
            return message.replace(requestBody, maskedRequestBody);
        }
        return message;
    }
}
