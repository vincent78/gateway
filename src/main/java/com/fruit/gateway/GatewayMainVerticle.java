package com.fruit.gateway;

import com.fruit.shovel.SVConstant;
import com.fruit.shovel.ShovelMainVerticle;
import com.fruit.shovel.manager.VerticleManager;
import com.fruit.shovel.model.VerticleModel;
import com.fruit.shovel.utils.MsgIFQueue;
import io.vertx.core.eventbus.Message;

import java.util.List;

public class GatewayMainVerticle extends ShovelMainVerticle {


    @Override
    protected void doWhenStartDefault(Message msg) {
        new MsgIFQueue(msg)
                .thenCompose(SVConstant.EVENT_MONGODB_INIT)
                .thenCompose(SVConstant.EVENT_REDIS_INIT)
                .thenCompose(SVConstant.EVENT_KAFKA_CONSUMER_INIT)
                .thenCompose(SVConstant.EVENT_HTTP_SERVER_INIT)
                .thenCompose(Constant.EVENT_REGIST_SERVICE)
                .thenCompose(SVConstant.EVENT_STARTREDAY)
                .start();
    }


    @Override
    protected List<VerticleModel> genVerticleList() {
        List<VerticleModel> list = super.genVerticleList();
        list.addAll(VerticleManager.getVerticleList("com.fruit.gateway", this.getClass().getClassLoader()));
        return list;
    }
}
