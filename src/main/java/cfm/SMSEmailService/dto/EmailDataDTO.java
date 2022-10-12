package cfm.SMSEmailService.dto;

import cfm.SMSEmailService.models.InfoFile;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class EmailDataDTO {

  private Long id;
  @NotEmpty(message = "Thiếu email")
  @Email
  private String email;
  @NotEmpty(message = "Thiếu subject")
  private String subject;
  @NotEmpty(message = "Thiếu content")
  private String content;
  @NotEmpty(message = "Thiếu app code")
  private String appCode;
  private String emailType;
  @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
  private List<InfoFile> listFile;
}
