package cfm.SMSEmailService.dto;

import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SMSDataDTO {

  private Long id;
  @NotEmpty(message = "Thiếu phone")
  private String phone;
  @NotEmpty(message = "Thiếu content")
  private String content;
  @NotEmpty(message = "Thiếu app code")
  private String appCode;

  private String user;
  private String password;
  private String cpCode;
  private String requestID;
  private String userID;
  private String receiverID;
  private String serviceID;
  private String commandCode;
  private String contentType;
}
