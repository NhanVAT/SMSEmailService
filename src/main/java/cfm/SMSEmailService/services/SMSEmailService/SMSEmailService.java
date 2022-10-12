package cfm.SMSEmailService.services.SMSEmailService;

import cfm.SMSEmailService.dto.EmailDataDTO;
import cfm.SMSEmailService.dto.ResponseObjectDTO;
import cfm.SMSEmailService.dto.SMSDataDTO;
import javax.mail.MessagingException;
import javax.transaction.Transactional;

public interface SMSEmailService {

  @Transactional
  ResponseObjectDTO sendSMSByContent(SMSDataDTO smsDataDTO);

  @Transactional
  ResponseObjectDTO sendEmailByContent(EmailDataDTO emailDataDTO);

  @Transactional
  ResponseObjectDTO sendEmailByFileAttachment(EmailDataDTO emailDataDTO) throws MessagingException;

  @Transactional
  ResponseObjectDTO sendEmailByHTML(EmailDataDTO emailDataDTO) throws MessagingException;
}
