package tacos;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//JUint的注解，提供一个测试运行器来指导JUnit如何运行测试
@RunWith(SpringRunner.class)
//启动测试时添加SpringBoot 功能，相当于在main中调用SpringApplication.run()
@SpringBootTest
class TacoCloudApplicationTests {

    //测试方法
    @Test
    void contextLoads() {
    }

}
