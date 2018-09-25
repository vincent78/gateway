package com.fruit.gateway;

import com.fruit.shovel.SVConstant;
import com.fruit.shovel.ShovelMainVerticle;
import com.fruit.shovel.annotation.EventMethod;
import com.fruit.shovel.utils.MsgIFQueue;
import io.vertx.core.eventbus.Message;

public class GatewayMainVerticle extends ShovelMainVerticle {

    @EventMethod(SVConstant.EVENT_START_DEFAULT)
    public void startDefault(Message<?> msg) {

        new MsgIFQueue().thenCompose(SVConstant.EVENT_MONGODB_INIT)
                        .thenCompose(SVConstant.EVENT_REDIS_INIT)
                        .thenCompose(SVConstant.EVENT_KAFKA_CONSUMER_INIT)
                        .thenCompose(SVConstant.EVENT_STARTREDAY)
                        .whenComplete((obj, e) -> {
                            if (e != null) {
                                msg.fail(100, e.getMessage());
                            } else {
                                msg.reply(obj);
                            }
                        }).start();
    }

}
