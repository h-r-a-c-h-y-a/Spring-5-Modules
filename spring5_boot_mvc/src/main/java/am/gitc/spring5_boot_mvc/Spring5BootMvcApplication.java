package am.gitc.spring5_boot_mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class Spring5BootMvcApplication {

    private static Logger logger = LoggerFactory.getLogger(Spring5BootMvcApplication.class);

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext ctx = SpringApplication.run(Spring5BootMvcApplication.class, args);
        assert (ctx != null);
        logger.info("Application Started...");
        System.in.read();
        ctx.close();
    }

}
