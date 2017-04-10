import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Jedis连接池连接
 *
 * @author bob {Tel：15811588260}-{Email：bobyang_coder@163.com}
 * @version 1.0
 * @since 2017/4/9
 */
public class JedisPoolTest {

    public static void main(String[] args) {
        JedisPoolConfig config = new JedisPoolConfig();
        //最大连接数
        config.setMaxTotal(30);
        //最大连接空闲数
        config.setMaxIdle(2);
        JedisPool pool = new JedisPool(config, "192.168.229.128", 6379);
        Jedis jedis = null;
        jedis = pool.getResource();
        jedis.set("name", "lisi");
        String name = jedis.get("name");
        System.out.println(name);
        //释放资源
        jedis.close();
        pool.close();
    }
}
