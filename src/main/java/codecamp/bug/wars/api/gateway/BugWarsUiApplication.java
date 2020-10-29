package codecamp.bug.wars.api.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@RestController
public class BugWarsUiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BugWarsUiApplication.class, args);
    }

    @Value("${eureka.instance.hostname:}")
    String hostname;

    @Value("${eureka.client.serviceUrl.defaultZone:}")
    String eurekaUrl;

    @Value("${spring.profiles.active:default}")
    String profile;

    @Value("${domain.name:}")
    String domainName;

    @GetMapping
    public String getIndex() {
        return String.join("<BR>", Arrays.asList(
                "Bug Wars API Gateway",
                "Hostname: " + hostname,
                "Eureka hostname; " + eurekaUrl,
                "Spring Profile: " + profile,
                "DOMAIN NAME: " + domainName
        ));
    }

}
