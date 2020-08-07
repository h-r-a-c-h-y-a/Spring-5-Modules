package javay.main.config;

import javay.main.aspects.Auditing;
import javay.main.aspects.LoggingAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "javay.main")
public class AppConfig {

//    @Bean
//    public TransferService transferService(DataSource dataSource) {
//        return new TransferServiceImpl(
//                accountRepository(dataSource),
//                transferRepository(dataSource));
//    }
//
//    @Bean
//    public AccountRepository accountRepository(DataSource dataSource) {
//        return new JdbcAccountRepository(dataSource);
//    }
//
//    @Bean
//    public TransferRepository transferRepository(DataSource dataSource) {
//        return new JdbcTransferRepository(dataSource);
//    }
//
    @Bean
    public LoggingAspect loggingAspect() {
        return new LoggingAspect();
    }

    @Bean
    public Auditing auditing() {
        return new Auditing();
    }

}
