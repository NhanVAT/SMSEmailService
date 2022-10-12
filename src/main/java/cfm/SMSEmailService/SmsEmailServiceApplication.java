package cfm.SMSEmailService;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;

@SpringBootApplication
@RequiredArgsConstructor
@EnableConfigurationProperties
@EntityScan(basePackages = {"cfm.SMSEmailService.entities"})
public class SmsEmailServiceApplication extends SpringBootServletInitializer implements
    CommandLineRunner {

  private static final Logger log = LoggerFactory.getLogger(SmsEmailServiceApplication.class);

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(SmsEmailServiceApplication.class);
  }

  @Bean
  public CharacterEncodingFilter characterEncodingFilter() {
    CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
    characterEncodingFilter.setEncoding("UTF-8");
    characterEncodingFilter.setForceEncoding(true);
    return characterEncodingFilter;
  }

  public static void main(String[] args) {
    SpringApplication.run(SmsEmailServiceApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {

  }
}
