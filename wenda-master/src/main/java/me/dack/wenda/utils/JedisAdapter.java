package me.dack.wenda.utils;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

@Service
public class JedisAdapter implements InitializingBean{

	private static final Logger logger = LoggerFactory.getLogger(JedisAdapter.class);
	private JedisPool pool;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		pool = new JedisPool("127.0.0.1",6379);
	}
	
	public long set(String key,String value,int expire) {
		Jedis jedis = null;
		try{
			jedis = pool.getResource();	
			jedis.set(key, value);
			return jedis.expire(key, expire);
		}catch (Exception e) {
			logger.error("redis连接异常"+e.getMessage());
		}finally {
			if(jedis != null) {
				jedis.close();
			}
		}
		return 0;
	}
	
	public String get(String key) {
		Jedis jedis = null;
		try{
			jedis = pool.getResource();		
			return jedis.get(key);
		}catch (Exception e) {
			logger.error("redis连接异常"+e.getMessage());
		}finally {
			if(jedis != null) {
				jedis.close();
			}
		}
		return "";
	}
	
	public long del(String key) {
		Jedis jedis = null;
		try{
			jedis = pool.getResource();	
			return jedis.del(key);
		}catch (Exception e) {
			logger.error("redis连接异常"+e.getMessage());
		}finally {
			if(jedis != null) {
				jedis.close();
			}
		}
		return 0;
	}
	
	
	public long sadd(String key,String value){
		Jedis jedis = null;
		try{
			jedis = pool.getResource();
			return jedis.sadd(key, value);
		}catch (Exception e) {
			logger.error("redis链接异常"+e.getMessage());
		}finally {
			if(jedis != null){
				jedis.close();
			}
		}
		return 0;
	}
	
	public long srem(String key,String value){
		Jedis jedis = null;
		try{
			jedis = pool.getResource();
			return jedis.srem(key, value);
		}catch (Exception e) {
			logger.error("redis链接异常"+e.getMessage());
		}finally {
			if(jedis != null){
				jedis.close();
			}
		}
		return 0;
	}
	
	public long scard(String key){
		Jedis jedis = null;
		try{
			jedis = pool.getResource();
			return jedis.scard(key);
		}catch (Exception e) {
			logger.error("redis链接异常"+e.getMessage());
		}finally {
			if(jedis != null){
				jedis.close();
			}
		}
		return 0;
	}
	
	public boolean sismember(String key,String value){
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			return jedis.sismember(key, value);
		} catch (Exception e) {
			logger.error("redis链接异常"+e.getMessage());
		}finally {
			if(jedis != null){
				jedis.close();
			}
		}
		return false;
	}
	
	 public List<String> brpop(int timeout, String key) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.brpop(timeout, key);
        } catch (Exception e) {
            logger.error("redis链接异常" + e.getMessage());
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return null;
    }

    public long lpush(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.lpush(key, value);
        } catch (Exception e) {
            logger.error("redis链接异常" + e.getMessage());
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return 0;
    }
    
    public Set<String> zrevrange(String key,int start,int end){
    	Jedis jedis = null;
    	try {
			jedis = pool.getResource();
			return jedis.zrevrange(key, start, end);
		} catch (Exception e) {
			logger.error("redis链接异常" + e.getMessage());
		}
    	return null;
    }
    
    public long zcard(String key) {
    	Jedis jedis = null;
    	try {
    		jedis = pool.getResource();
    		return jedis.zcard(key);
    	}catch (Exception e) {
			logger.error("redis链接异常" + e.getMessage());
		}finally {
			if(jedis != null) {
				jedis.close();
			}
		}
    	return 0;
    }
    
    public Double zscore(String key,String member) {
    	Jedis jedis = null;
    	try {
			jedis = pool.getResource();
			return jedis.zscore(key, member);
		} catch (Exception e) {
			logger.error("发生异常" + e.getMessage());
		}finally {
			if(jedis != null) {
				jedis.close();
			}
		}
    	return null;
    }

    public Jedis getJedis() {
    	return pool.getResource();
    }
    
    public Transaction multi(Jedis jedis) {
    	try {
			return jedis.multi();
		} catch (Exception e) {
			logger.error("发生异常" + e.getMessage());
		}finally{
			
		}
    	return null;
    }
    
    public List<Object> exec(Transaction tx,Jedis jedis){
    	try {
			return tx.exec();
		} catch (Exception e) {
			logger.error("发生异常"+e.getMessage());
			tx.discard();
		}finally {
			if(tx != null) {
				try {
					tx.close();
				} catch (Exception e2) {
					logger.error("发生异常"+e2.getMessage());
				}
				if (jedis != null) {
	                jedis.close();
	            }
			}
		}
    	return null;
    }
    
    public long zadd(String key,double score,String number,int expire){
    	Jedis jedis = null;
    	try {
    		jedis = pool.getResource();    	
    		jedis.zadd(key,score,number);
    		return jedis.expire(key, expire);
    	}catch (Exception e) {
    		logger.error("发生异常"+e.getMessage());
    	}finally {
    		if(jedis != null) {
				jedis.close();
			}
    	}
    	return 0;
    }
    
//    public List<Integer> zrevrange(String key,int offset,int limit){
//    	
//    	return new ArrayList<Integer>;
//    }
}
