package tacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//组合注解
//@SpringBootConfiguration:声明为配置类
//@EnableAutoConfiguration:启用Spring Boot自动配置
//@ComponentScan:启用组件扫描，Spring会自动发现它们并将它们注册成为Spring应用上下文中的组件
@SpringBootApplication
public class TacoCloudApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        //运行应用
        SpringApplication.run(TacoCloudApplication.class, args);
    }

    //声明视图控制器
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        //访问根路径， 自动转发到home.html
        registry.addViewController("/").setViewName("home");
    }

}
