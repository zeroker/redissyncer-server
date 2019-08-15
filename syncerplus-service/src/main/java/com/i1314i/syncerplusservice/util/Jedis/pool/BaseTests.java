package com.i1314i.syncerplusservice.util.Jedis.pool;

import com.alibaba.fastjson.JSON;
import com.moilioncircle.redis.replicator.RedisReplicator;
import com.moilioncircle.redis.replicator.Replicator;
import com.moilioncircle.redis.replicator.event.Event;
import com.moilioncircle.redis.replicator.event.EventListener;

import java.io.IOException;
import java.net.URISyntaxException;

public class BaseTests {
    public static void main(String[] args) throws IOException, URISyntaxException {
        final Replicator replicator = new RedisReplicator("redis://114.67.100.239:6379?authPassword=redistest0102");
        replicator.addEventListener(new EventListener() {
            @Override
            public void onEvent(Replicator replicator, Event event) {
                System.out.println(JSON.toJSONString(event));
//                if(event instanceof KeyStringValueString){
//                    KeyStringValueString valueString= (KeyStringValueString) event;
//                    System.out.println(JSON.toJSONString(valueString));
//                }else if(event instanceof KeyStringValueList){
//                    KeyStringValueList valueList= (KeyStringValueList) event;
//                    System.out.println(JSON.toJSONString(valueList));
//                }else {
//                    System.out.println(JSON.toJSONString(event));
//                }

            }
        });

        replicator.open();
    }
}
