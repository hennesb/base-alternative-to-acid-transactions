package hyperglobal.message.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class MessageProducer {
	
	private static final Logger log = LoggerFactory.getLogger(MessageProducer.class);
	
    //@Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        log.info("Running the scheduler now" );
    }

}
