package tacos;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author Fly
 * @date 2021/5/30
 */

@RunWith(SpringRunner.class)
//针对HomeController的Web测试
@WebMvcTest
class HomeControllerTest {

    //注入MockMvc:是spring-test包提供，实现对http请求的模拟，能够直接使用网络的形式，转换到controller调用，
    //使得测试速度快，不依赖于网络，同时提供一套验证的工具，方便验证结果。
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testHomePage() throws Exception {
        mockMvc.perform(get("/"))   //发起对“/”的GET
                .andExpect(status().isOk())     //期望状态为200
                .andExpect(view().name("home"))     //期望得到home的试图
                .andExpect(content().string(containsString("Welcome to TacoCloud")));   //期望包含“Welcome”

    }
}