import redis.clients.jedis.Jedis;

/**
 * redis单实例连接
 *
 * @author bob {Tel：15811588260}-{Email：bobyang_coder@163.com}
 * @version 1.0
 * @since 2017/4/9
 */
public class JedisSingle {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.229.128", 6379);
        jedis.set("name", "bar");
        String name = jedis.get("name");
        System.out.println(name);
        jedis.close();
    }
}
