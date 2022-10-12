package cfm.SMSEmailService.services.SMSEmailService;

import cfm.SMSEmailService.component.SOAPClientSAAJ;
import cfm.SMSEmailService.dto.EmailDataDTO;
import cfm.SMSEmailService.dto.ResponseObjectDTO;
import cfm.SMSEmailService.dto.SMSDataDTO;
import cfm.SMSEmailService.entities.AppTransaction;
import cfm.SMSEmailService.models.InfoFile;
import cfm.SMSEmailService.repositories.TransactionRepository;
import cfm.SoisotaService.services.BaseService;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service(value = "smsEmailService")
@RequiredArgsConstructor
public class SMSEmailServiceImpl extends BaseService implements SMSEmailService {

  private final ModelMapper modelMapper;
  private final SOAPClientSAAJ soapClientSAAJ;
  private final TransactionRepository transactionRepository;
  private final JavaMailSender javaMailSender;

  public static final Logger logger = LoggerFactory.getLogger(SMSEmailServiceImpl.class);

  @Override
  @Transactional
  public ResponseObjectDTO sendSMSByContent(SMSDataDTO smsDataDTO) {

    smsDataDTO.setUser("evn");
    smsDataDTO.setPassword("EVNICT@123");
    smsDataDTO.setCpCode("EVN");
    smsDataDTO.setRequestID("1");
    smsDataDTO.setUserID("84" + smsDataDTO.getPhone().substring(1));
    smsDataDTO.setReceiverID("84" + smsDataDTO.getPhone().substring(1));
    smsDataDTO.setServiceID("EVN");
    smsDataDTO.setCommandCode("bulksms");
    smsDataDTO.setContentType("1");

    //Lưu thoong tin giao dịch
    AppTransaction appTransaction = new AppTransaction();
    appTransaction.setTransactionAppCode(smsDataDTO.getAppCode());
    appTransaction.setTransactionName(smsDataDTO.getPhone());
    appTransaction.setTransactionContent(smsDataDTO.getContent());
    appTransaction.setTransactionType("SMS");
    appTransaction.setCreatedBy(smsDataDTO.getAppCode());

    if (soapClientSAAJ.sendServiceSMSViettel(smsDataDTO)) {
      logger.info("SEND OTP TO SMS SUCCESS");
      appTransaction.setTransactionDescribe("SEND SMS SUCCESS");
    } else {
      logger.info("SEND OTP TO SMS ERROR");
      appTransaction.setTransactionDescribe("SEND SMS ERROR");
    }

    logger.info("THREAD: {}", Thread.currentThread().getName());

    transactionRepository.save(appTransaction);

    return new ResponseObjectDTO(true, "Gửi SMS thành công", null);
  }

  @Override
  @Transactional
  public ResponseObjectDTO sendEmailByContent(EmailDataDTO emailDataDTO) {
    //Lưu thoong tin giao dịch
    AppTransaction appTransaction = new AppTransaction();
    appTransaction.setTransactionAppCode(emailDataDTO.getAppCode());
    appTransaction.setTransactionName(emailDataDTO.getEmail());
    appTransaction.setTransactionType("EMAI_CONTENT");
    appTransaction.setCreatedBy(emailDataDTO.getAppCode());
    appTransaction.setTransactionContent(emailDataDTO.getContent());

    SimpleMailMessage message = new SimpleMailMessage();
    message.setTo(emailDataDTO.getEmail());
    message.setText(emailDataDTO.getContent());
    message.setSubject(emailDataDTO.getSubject());
    javaMailSender.send(message);

    appTransaction.setTransactionDescribe("SEND Email SUCCESS");

    logger.info("THREAD: {}", Thread.currentThread().getName());

    transactionRepository.save(appTransaction);
    return new ResponseObjectDTO(true, "Gửi Email thành công", null);
  }

  @Override
  @Transactional
  public ResponseObjectDTO sendEmailByFileAttachment(EmailDataDTO emailDataDTO)
      throws MessagingException {

    //Lưu thoong tin giao dịch
    AppTransaction appTransaction = new AppTransaction();
    appTransaction.setTransactionAppCode(emailDataDTO.getAppCode());
    appTransaction.setTransactionName(emailDataDTO.getEmail());
    appTransaction.setTransactionType("EMAI_FILE");
    appTransaction.setCreatedBy(emailDataDTO.getAppCode());
    appTransaction.setTransactionContent(emailDataDTO.getContent());

    MimeMessage message = javaMailSender.createMimeMessage();

    boolean multipart = true;

    MimeMessageHelper helper = new MimeMessageHelper(message, multipart);

    helper.setTo(emailDataDTO.getEmail());
    helper.setText(emailDataDTO.getContent());
    helper.setSubject(emailDataDTO.getSubject());
    if (emailDataDTO.getListFile() != null && !emailDataDTO.getListFile().isEmpty()) {
      for (InfoFile item : emailDataDTO.getListFile()) {
        //conver base64 to byte array
        byte[] dataByteFile = java.util.Base64.getDecoder().decode(item.getDataBase64());

        if (dataByteFile != null) {
          helper.addAttachment(item.getNameFile() + "." + item.getTypeFile(),
              new ByteArrayResource(dataByteFile));
        }
      }
    }

    javaMailSender.send(message);

    appTransaction.setTransactionDescribe("SEND Email SUCCESS");

    logger.info("THREAD: {}", Thread.currentThread().getName());

    transactionRepository.save(appTransaction);
    return new ResponseObjectDTO(true, "Gửi Email thành công", null);
  }

  @Override
  @Transactional
  public ResponseObjectDTO sendEmailByHTML(EmailDataDTO emailDataDTO) throws MessagingException {
    //Lưu thoong tin giao dịch
    AppTransaction appTransaction = new AppTransaction();
    appTransaction.setTransactionAppCode(emailDataDTO.getAppCode());
    appTransaction.setTransactionName(emailDataDTO.getEmail());
    appTransaction.setTransactionType("EMAI_HTML");
    appTransaction.setCreatedBy(emailDataDTO.getAppCode());
    appTransaction.setTransactionContent(emailDataDTO.getContent());

    MimeMessage message = javaMailSender.createMimeMessage();

    boolean multipart = true;

    MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "UTF-8");

    message.setContent(emailDataDTO.getContent(), "text/html");

    helper.setTo(emailDataDTO.getEmail());
    helper.setSubject(emailDataDTO.getSubject());
    helper.setSubject("Test send HTML email");

    javaMailSender.send(message);

    appTransaction.setTransactionDescribe("SEND Email SUCCESS");

    logger.info("THREAD: {}", Thread.currentThread().getName());

    transactionRepository.save(appTransaction);

    return new ResponseObjectDTO(true, "Gửi Email thành công", null);
  }

}
