package hyperglobal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SpringBootApplication
@EnableScheduling
public class HyperglobalApplication {
	
	private static final Logger log = LoggerFactory.getLogger(HyperglobalApplication.class);
	

	public static void main(String[] args) {
		SpringApplication.run(HyperglobalApplication.class, args);
	}
	
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
        	log.info("commandline runner invoked " );
        };
    }
}
