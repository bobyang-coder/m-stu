import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.ShardedJedis;

@Service
public class RedisClusterService {

    @Autowired
    private JedisCluster jedisCluster;

    

    /**
     * set方法
     * 
     * @param key
     * @param value
     * @return
     */
    public String set(final String key, final String value) {
    	return jedisCluster.set(key, value);
    }

    /**
     * 保存数据到redis中，并且设置过期时间
     * 
     * @param key
     * @param value
     * @param expire
     * @return
     */
    public String set(final String key, final String value, final Integer expire) {
    	
    	// 设置数据
    	String str = jedisCluster.set(key, value);
    	jedisCluster.expire(key, expire);
    	return str;
    }

    /**
     * 设置过期时间
     * 
     * @param key
     * @param expire
     * @return
     */
    public Long expire(final String key, final Integer expire) {
    	return jedisCluster.expire(key, expire);
    }

    /**
     * get 方法
     * 
     * @param key
     * @return
     */
    public String get(final String key) {
    	return jedisCluster.get(key);
    }

    /**
     * 根据key删除redis中的数据
     * @param key
     * @return
     */
    public Long del(final String key) {
    	 return jedisCluster.del(key);
    }

}
