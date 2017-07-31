package mengfw.rms.aspect;

import mengfw.rms.helper.ServletHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by MFW on 2017/5/30.
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionAspect {
    private static  final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionAspect.class);
    @ExceptionHandler(value=MethodArgumentNotValidException.class)
    public Object MethodArgumentNotValidHandler( MethodArgumentNotValidException exception) throws Exception{
        String message = generateErrorMessages(exception.getBindingResult().getAllErrors());
        LOGGER.error(message,exception);
        ServletHelper.sendResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                message    );

        return null;
    }
    @ExceptionHandler(value=Exception.class)
    public Object ExceptionHandler( Exception exception) throws Exception{
        LOGGER.error(exception.getMessage(),exception);
        ServletHelper.sendResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                exception.getMessage());

        return null;
    }
    private String generateErrorMessages(List<ObjectError> errors) {
        StringBuilder builder = new StringBuilder();
        errors.forEach(e -> builder.append(e.getDefaultMessage()).append("|"));
        String message = builder.toString();
        return message.substring(0,message.length() - 1);
    }
}
