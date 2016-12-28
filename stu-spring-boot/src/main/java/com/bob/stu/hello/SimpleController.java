package com.bob.stu.hello;

import com.bob.stu.domain.JsonBean;
import com.bob.stu.domain.MailProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.PrintStream;

/**
 * 学习Spring-Boot入门1
 *
 * @author bob
 * @since 2016-11-12 18:28
 */
@Controller
@EnableAutoConfiguration
public class SimpleController {

    @Value("hello")
    private String hello;

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        MailProperties mail = new MailProperties();
        return mail.getHost();
    }


    @RequestMapping("/getJson")
    public JsonBean getJsonData() {
        JsonBean json = new JsonBean();
        json.setId("1");
        json.setName("bob");
        return json;
    }

    @RequestMapping(value = "zeroException")
    public int zeroException() {

        return 200 / 0;
    }

    public static void main(String[] args) {
        SimpleController.customBanner(args);
    }


    /**
     * 自定义banner
     *
     * @param args
     * @return
     */
    public static SpringApplication customBanner(String[] args) {
        SpringApplication app = new SpringApplication(SimpleController.class);
        app.setBanner(new Banner() {
            @Override
            public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
                out.println("bob:Application");
            }
        });
        app.run(args);
        return app;
    }


}
