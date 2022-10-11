package cfm.SoisotaService.exception;

import cfm.SoisotaService.dto.ResponseObjectDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandlerController {

  @Bean
  public ErrorAttributes errorAttributes() {
    // Hide exception field in the return object
    return new DefaultErrorAttributes() {
      @Override
      public Map<String, Object> getErrorAttributes(WebRequest webRequest,
          ErrorAttributeOptions options) {
        return super.getErrorAttributes(webRequest,
            ErrorAttributeOptions.defaults().excluding(ErrorAttributeOptions.Include.EXCEPTION));
      }
    };
  }

  @ExceptionHandler(CustomException.class)
  public void handleCustomException(HttpServletResponse res, CustomException ex)
      throws IOException {
    res.sendError(ex.getHttpStatus().value(), ex.getMessage());
  }

  @ExceptionHandler(AccessDeniedException.class)
  public void handleAccessDeniedException(HttpServletResponse res) throws IOException {
    res.sendError(HttpStatus.FORBIDDEN.value(), "Access denied");
  }

  @ExceptionHandler(Exception.class)
  public void handleException(HttpServletResponse res) throws IOException {
    res.sendError(HttpStatus.BAD_REQUEST.value(), "Something went wrong");
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ResponseObjectDTO> handleInvalidArgument(MethodArgumentNotValidException ex,
      HttpServletResponse res) {
    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult().getAllErrors().forEach((error) -> {
      String fieldName = ((FieldError) error).getField();
      String message = error.getDefaultMessage();
      errors.put(fieldName, message);
    });

    ObjectMapper mapper = new ObjectMapper();
    String jsonResult;
    try {
      jsonResult = mapper.writerWithDefaultPrettyPrinter()
          .writeValueAsString(errors);
      //res.sendError(HttpStatus.BAD_REQUEST.value(), jsonResult);

      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
          new ResponseObjectDTO(false, HttpStatus.BAD_REQUEST.name(),
              mapper.readValue(jsonResult, Object.class))
      );
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }

  }

  @ExceptionHandler(BindException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)  // Nếu validate fail thì trả về 400
  public String handleBindException(BindException e) {
    // Trả về message của lỗi đầu tiên
    String errorMessage = "Request không hợp lệ";
    if (e.getBindingResult().hasErrors()) {
      e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
    }
    return errorMessage;
  }
}
