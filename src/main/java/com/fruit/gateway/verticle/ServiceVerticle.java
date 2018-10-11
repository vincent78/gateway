package com.fruit.gateway.verticle;

import com.fruit.gateway.Constant;
import com.fruit.shovel.SVConstant;
import com.fruit.shovel.annotation.EventMethod;
import com.fruit.shovel.annotation.Verticle;
import com.fruit.shovel.manager.ClusterConfManager;
import com.fruit.shovel.manager.WebManager;
import com.fruit.shovel.verticle.VerticleBase;
import io.vertx.core.eventbus.Message;

@Verticle
public class ServiceVerticle extends VerticleBase {

    @EventMethod(Constant.EVENT_REGIST_SERVICE)
    public void registService(Message msg) {
        WebManager manager = WebManager.getInstance();
        String root = manager.getVirtualPathPrefix();
        //时间戳
        manager.registServiceRoute(SVConstant.EVENT_TIMESTAMP, root + "/timestamp");

        //verticle的信息
        manager.registServiceRoute(SVConstant.EVENT_BASE_VERTICLE_INSTANCE, root + "/vInfo");

        if (ClusterConfManager.isClustered()) {
            //查询brokers
            manager.registServiceRoute(SVConstant.EVENT_CLUSTER_BROKERS_INFO, root + "/brokers");
        }
        msg.reply(true);
    }
}
