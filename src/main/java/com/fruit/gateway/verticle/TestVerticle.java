package com.fruit.gateway.verticle;

import com.fruit.shovel.annotation.EventMethod;
import com.fruit.shovel.annotation.Verticle;
import com.fruit.shovel.verticle.VerticleBase;
import io.vertx.core.eventbus.Message;

@Verticle(value = "com.fruit.gateway.verticle", instances = 3)
@SuppressWarnings("unused")
public class TestVerticle extends VerticleBase {

    @EventMethod("gateway_test")
    public void testEvent(Message msg) {

    }
}
