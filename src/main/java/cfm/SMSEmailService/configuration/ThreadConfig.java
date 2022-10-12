package cfm.SMSEmailService.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class ThreadConfig {
    @Autowired
    private Environment environment;

    @Bean
    public TaskExecutor threadPoolTaskExecutor() {
        Integer numberCPU = Integer.parseInt(environment.getProperty("SMS_NUMBERCPU"));
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(numberCPU);
        executor.setMaxPoolSize(numberCPU);
        executor.setThreadNamePrefix("THREAD_");
        executor.setThreadPriority(1);
        executor.setAwaitTerminationSeconds(10);
        executor.initialize();

        return executor;
    }
}
