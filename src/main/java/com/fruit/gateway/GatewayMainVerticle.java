package com.fruit.gateway;

import com.fruit.shovel.SVConstant;
import com.fruit.shovel.ShovelMainVerticle;
import com.fruit.shovel.annotation.EventMethod;
import com.fruit.shovel.manager.VerticleManager;
import com.fruit.shovel.utils.HandlerUtil;
import io.vertx.core.eventbus.Message;

public class GatewayMainVerticle extends ShovelMainVerticle {

    @EventMethod(SVConstant.EVENT_START_DEFAULT)
    public void startDefault(Message<?> msg) {
        VerticleManager.send(SVConstant.EVENT_STARTREDAY,null, HandlerUtil.handlerTransfer2Msg(msg));
    }

}
