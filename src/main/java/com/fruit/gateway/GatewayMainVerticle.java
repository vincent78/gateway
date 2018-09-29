package com.fruit.gateway;

import com.fruit.shovel.SVConstant;
import com.fruit.shovel.ShovelMainVerticle;
import com.fruit.shovel.annotation.EventMethod;
import com.fruit.shovel.manager.VerticleManager;
import com.fruit.shovel.model.VerticleModel;
import com.fruit.shovel.utils.MsgIFQueue;
import io.vertx.core.eventbus.Message;

import java.util.List;

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


    /**
     * 获取包中verticle的内容
     * 注：子类需要覆盖
     * @return
     */
    @Override
    protected List<VerticleModel> genVerticleList() {
        List<VerticleModel> list = super.genVerticleList();
        list.addAll(VerticleManager.getVerticleList("com.fruit.gateway",this.getClass().getClassLoader()));
        return list;
    }

}
