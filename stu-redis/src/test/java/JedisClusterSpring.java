import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/**
 * redis集群版
 * spring整合jedis(即jedis相关对象交由spring容器管理)
 *
 * @author bob {Tel：15811588260}-{Email：bobyang_coder@163.com}
 * @version 1.0
 * @since 2017/4/9
 */
public class JedisClusterSpring {
    private ApplicationContext applicationContext;

    @Before
    public void init() {
        applicationContext = new ClassPathXmlApplicationContext("spring-jediscluster.xml");
    }

    @Test
    public void test() {
        JedisCluster jedisCluster = (JedisCluster) applicationContext.getBean("jedisCluster");
        //jedisCluster.set("name", "linlin");
        String name = jedisCluster.get("name");
        Map<String, JedisPool> clusterNodes = jedisCluster.getClusterNodes();
        Iterator<Map.Entry<String, JedisPool>> entryIterator = clusterNodes.entrySet().iterator();
        if (entryIterator.hasNext()) {
            JedisPool jedisPool = entryIterator.next().getValue();
            System.out.println(jedisPool.getResource().clusterInfo() + ",NumActive:" + jedisPool.getNumActive() + ",NumIdle:" + jedisPool.getNumIdle() + "NumWaiters" + jedisPool.getNumWaiters());
        }
        jedisCluster.del("name");
        jedisCluster.set("user", "hehe");
        System.out.println(name);
    }

    @Test
    public void testShardedJedisPool() {
        ShardedJedisPool jedisPool = (ShardedJedisPool) applicationContext.getBean("shardedJedisPool");
        ShardedJedis shardedJedis = jedisPool.getResource();
        Collection<JedisShardInfo> allShardInfo = shardedJedis.getAllShardInfo();
        Iterator<JedisShardInfo> iterator = allShardInfo.iterator();
        if (iterator.hasNext()) {
            JedisShardInfo shardInfo = iterator.next();
            System.out.println(String.format("host:%s,port:%d", shardInfo.getHost(), shardInfo.getPort()));
        }
        //shardedJedis.set("name", "linlin");
        String name = shardedJedis.get("name");
        System.out.println(name);
    }
}
