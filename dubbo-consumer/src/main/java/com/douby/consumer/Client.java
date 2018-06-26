package com.douby.consumer;

import com.douby.server.DemoService;
import com.douby.server.SayHello;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class Client {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/spring/dubbo.xml");
        ctx.start();
        SayHello sayHello = (SayHello) ctx.getBean("sayHello");
        SayHello sayHelloH = (SayHello) ctx.getBean("sayHelloH");
        DemoService demoService = (DemoService) ctx.getBean("demoService");
        System.out.println("=============================");
//        System.out.println(sayHello.savHello("douby"));
//        System.out.println(sayHelloH.savHello("douby"));
//
//        System.out.println(demoService.demoProtol("douby"));
        for (int i = 0; i < 10; i++) {
            System.out.println(sayHello.savHello("douby"));

        }
        System.out.println("=============================");
    }
}
