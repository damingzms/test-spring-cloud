package cn.sam.test.testspringcloud.feign.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Spencer Gibb
 */
@SpringBootApplication
@RestController
public class HelloServerApplication {

	@RequestMapping("/")
	public String hello() {
		return "访问成功";
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloServerApplication.class, args);
	}
}
