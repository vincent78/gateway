package com.fruit.gateway.verticle;

import com.fruit.gateway.Constant;
import com.fruit.shovel.annotation.EventMethod;
import com.fruit.shovel.annotation.Verticle;
import com.fruit.shovel.verticle.VerticleBase;
import io.vertx.core.eventbus.Message;

@Verticle
public class ServiceVerticle extends VerticleBase {

    @EventMethod(Constant.EVENT_REGIST_SERVICE)
    public void initService(Message msg) {
        msg.reply(true);
    }

}
