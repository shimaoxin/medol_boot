package medol.boot_mybatis;

import model.boot_mybatis.BootMybatisApplication;
import model.boot_mybatis.model.user.User;
import model.boot_mybatis.service.user.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BootMybatisApplication.class)
public class BootMybatisApplicationTests {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	@Autowired
	private IUserService userService;

	@Test
	public void contextLoads() {
		redisTemplate.opsForValue().set("1","2");
//		redisTemplate.delete("1");
	}

	@Test
	public void ycFile() {
		File file = new File("D:/yc/");

		File[] fileList = file.listFiles();
		for(File subFile: fileList) {
			if(subFile.isHidden()) continue;
			System.out.println("目录：" +subFile.getName());
			File[] fileList2 = subFile.listFiles();
			for(File subFile2: fileList2) {
				if(subFile2.isHidden()) continue;
				String name = subFile2.getName();
				if(name.indexOf(".") > 0) {
					name = name.substring(0, name.indexOf("."));
				}

				User user = new User();
				user.setId(UUID.randomUUID().toString());
				user.setUserName(name);
				System.out.println("文件:"+name);
				userService.insertSelective(user);
			}
		}
	}

	public static void main(String[] args) throws Exception{
		String s = null;
		InputStream is = new FileInputStream(s);
	}

}
