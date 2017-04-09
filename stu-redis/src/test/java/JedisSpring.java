import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * redis单机版
 * spring整合jedis(即jedis相关对象交由spring容器管理)
 *
 * @author bob {Tel：15811588260}-{Email：bobyang_coder@163.com}
 * @version 1.0
 * @since 2017/4/9
 */
public class JedisSpring {
    private ApplicationContext applicationContext;

    @Before
    public void init() {
        applicationContext = new ClassPathXmlApplicationContext("spring-jedis.xml");
    }

    @Test
    public void test() {
        JedisPool jedisPool = (JedisPool) applicationContext.getBean("jedisPool");
        Jedis jedis = jedisPool.getResource();
        jedis.set("name", "wangwu");
        String name = jedis.get("name");
        System.out.println(name);
    }

}
