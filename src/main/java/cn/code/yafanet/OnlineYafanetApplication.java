package cn.code.yafanet;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("cn.code.yafanet.mapper")
@EnableTransactionManagement
public class OnlineYafanetApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineYafanetApplication.class, args);
	}

}
