package com.douby.consumer;

import com.douby.server.SayHello;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *                _ooOoo_
 *                o8888888o
 *                88" . "88
 *                (| -_- |)
 *                O\ = /O
 *              ____/`---'\____
 *            .   ' \\| |// `.
 *              / \\||| : |||// \
 *             / _||||| -:- |||||- \
 *              | | \\\ - /// | |
 *              | \_| ''\---/'' | |
 *            \ .-\__ `-` ___/-. /
 *            ___`. .' /--.--\ `. . __
 *          ."" '< `.___\_<|>_/___.' >'"".
 *         | | : `- \`.;`\ _ /`;.`/ - ` : | |
 *          \ \ `-. \_ __\ /__ _/ .-` / /
 * ======`-.____`-.___\_____/___.-`____.-'======
 *                `=---='
 * .............................................
 *      佛祖镇楼                  BUG辟易
 * 佛曰:
 *       写字楼里写字间，写字间里程序员；
 *       程序人员写程序，又拿程序换酒钱。
 *       酒醒只在网上坐，酒醉还来网下眠；
 *       酒醉酒醒日复日，网上网下年复年。
 *       但愿老死电脑间，不愿鞠躬老板前；
 *       奔驰宝马贵者趣，公交自行程序员。
 *       别人笑我忒疯癫，我笑自己命太贱；
 *       不见满街漂亮妹，哪个归得程序员？
 *
 * @Author: cpzh
 * @Date: 2018/6/25 17:29
 * TODO:
 */
public class DubboClientTest {
    private static  ClassPathXmlApplicationContext ctx = null;
    /**
     * 读取配置文件
     */
    @Before
    public void init(){
        ctx = new ClassPathXmlApplicationContext("META-INF/spring/dubbo.xml");
        ctx.start();
    }

    /**
     * 测试多版本
     */
    @Test
    public void testMultiVersion(){
        if (ctx == null){
            System.out.println("ClassPathXmlApplicationContext can not be construct");
            return;
        }
        System.out.println("--------USER VERSION 1.0.0-------------");
        SayHello dubboVersion0 = (SayHello) ctx.getBean("sayHelloDubboVersion0");
        SayHello hessionVersion0 = (SayHello) ctx.getBean("sayHelloHessianVersion0");
        System.out.println(dubboVersion0.savHello("dubbo协议"));
        System.out.println(hessionVersion0.savHello("hession协议"));

        System.out.println("--------USER VERSION 1.0.1-------------");
        SayHello dubboVersion1 = (SayHello) ctx.getBean("sayHelloDubboVersion1");
        SayHello hessionVersion1 = (SayHello) ctx.getBean("sayHelloHessianVersion1");
        System.out.println(dubboVersion1.savHello("dubbo协议"));
        System.out.println(hessionVersion1.savHello("hession协议"));

        try {
            System.out.println("--------NO VERSION-------------");
            SayHello dubboNoVersion = (SayHello) ctx.getBean("sayHelloDubboNoVersion");
            SayHello hessionNoVersion = (SayHello) ctx.getBean("sayHelloHessianNoVersion");
            System.out.println(dubboNoVersion.savHello("dubbo协议"));
            System.out.println(hessionNoVersion.savHello("hession协议"));
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("在服务端存在多个版本时， 客户端不指定版本的话，会报错");
        }
    }
}
