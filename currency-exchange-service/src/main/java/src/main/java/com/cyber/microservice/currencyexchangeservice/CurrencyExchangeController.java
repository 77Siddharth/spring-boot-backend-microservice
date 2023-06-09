package src.main.java.com.cyber.microservice.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;
    @Autowired
    private Environment environment;


    @GetMapping("/hello")
    public String retHello(){
        return "Hello World";
    }

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange getExchange(
            @PathVariable String from,
            @PathVariable String to
    ){
        logger.info("Called CurrencyExchange service FROM {} TO {}", from,to);
//        CurrencyExchange currencyExchange = new CurrencyExchange(1000L, "usd", "EUR", BigDecimal.valueOf(50L));
        CurrencyExchange currencyExchange = currencyExchangeRepository.findByFromAndTo(from,to);
        if (currencyExchange==null){
            throw new RuntimeException("Currency exchange not found");
        }
        currencyExchange.setEnviron(environment.getProperty("local.server.port"));
        return currencyExchange;
    }
}
