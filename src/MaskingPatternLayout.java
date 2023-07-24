import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.spi.ILoggingEvent;
import pibase.spring.core.util.PiBaseHelper;

/**
 * @author travistran
 */
public class MaskingPatternLayout extends PatternLayout {

    @Override
    protected String writeLoopOnConverters(ILoggingEvent event) {
        return PiBaseHelper.maskSensitiveData(super.writeLoopOnConverters(event));
    }
}
