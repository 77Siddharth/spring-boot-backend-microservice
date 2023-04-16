package src.main.java.com.cyber.microservice.currencyexchangeservice;

import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);


    @GetMapping("/sample-first")
    @Retry(name = "default")
    public String sampleApi(){
        ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8000/sample1",String.class);
        logger.info("SAMPLE == called");
        return "SAMPLE";
    }
}
