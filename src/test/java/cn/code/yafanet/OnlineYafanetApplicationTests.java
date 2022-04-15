package cn.code.yafanet;

import cn.code.yafanet.model.entity.User;
import cn.code.yafanet.utils.JWTUtils;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OnlineYafanetApplicationTests {

	@Test
	public void testGeneJwt(){

		User user = new User();
		user.setId(66);
		user.setName("yafanet");
		user.setHeadImg("archeage");
		String  token = JWTUtils.geneJsonWebToken(user);

		System.out.println(token);

		try {
			Thread.sleep(4000L);
		}catch (InterruptedException e){
			e.printStackTrace();
		}
		Claims claims = JWTUtils.checkJWT(token);
		System.out.println(claims.get("name"));
	}


}
