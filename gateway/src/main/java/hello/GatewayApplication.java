package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import hello.filter.pre.SimpleFilter;

/**
 * Gateway application.
 *
 * @author Johnny Lim
 */
@SpringBootApplication
@EnableZuulProxy
public class GatewayApplication {

	@Bean
	public SimpleFilter simpleFilter() {
		return new SimpleFilter();
	}

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

}
