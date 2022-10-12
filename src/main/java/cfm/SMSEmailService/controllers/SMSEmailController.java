package cfm.SMSEmailService.controllers;

import cfm.SMSEmailService.dto.EmailDataDTO;
import cfm.SMSEmailService.dto.ResponseObjectDTO;
import cfm.SMSEmailService.dto.SMSDataDTO;
import cfm.SMSEmailService.services.SMSEmailService.SMSEmailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.mail.MessagingException;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/smsemail")
@Api(tags = "smsemail")
@RequiredArgsConstructor
public class SMSEmailController {

  private final ModelMapper modelMapper;

  private final SMSEmailService smsEmailService;

  @PostMapping("/sendSMSByContent")
  @ApiOperation(value = "Send SMS content", response = ResponseEntity.class)
  public ResponseEntity<ResponseObjectDTO> sendSMSByContent(
      @Valid @RequestBody SMSDataDTO smsDataDTO) {
    return ResponseEntity.status(HttpStatus.OK).body(smsEmailService.sendSMSByContent(smsDataDTO));
  }

  @PostMapping("/sendEmailByContent")
  @ApiOperation(value = "Send Email content", response = ResponseEntity.class)
  public ResponseEntity<ResponseObjectDTO> sendEmailByContent(
      @Valid @RequestBody EmailDataDTO emailDataDTO) {
    return ResponseEntity.status(HttpStatus.OK)
        .body(smsEmailService.sendEmailByContent(emailDataDTO));
  }

  @PostMapping("/sendEmailByFileAttachment")
  @ApiOperation(value = "Send Email File Attachment", response = ResponseEntity.class)
  public ResponseEntity<ResponseObjectDTO> sendEmailByFileAttachment(
      @Valid @RequestBody EmailDataDTO emailDataDTO) throws MessagingException {
    return ResponseEntity.status(HttpStatus.OK)
        .body(smsEmailService.sendEmailByFileAttachment(emailDataDTO));
  }

  @PostMapping("/sendEmailByHTML")
  @ApiOperation(value = "Send Email HTML", response = ResponseEntity.class)
  public ResponseEntity<ResponseObjectDTO> sendEmailByHTML(
      @Valid @RequestBody EmailDataDTO emailDataDTO) throws MessagingException {
    return ResponseEntity.status(HttpStatus.OK)
        .body(smsEmailService.sendEmailByHTML(emailDataDTO));
  }
}
