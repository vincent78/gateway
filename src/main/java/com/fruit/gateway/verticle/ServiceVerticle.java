package com.fruit.gateway.verticle;

import com.fruit.gateway.Constant;
import com.fruit.shovel.SVConstant;
import com.fruit.shovel.annotation.EventMethod;
import com.fruit.shovel.annotation.Verticle;
import com.fruit.shovel.manager.ClusterConfManager;
import com.fruit.shovel.manager.WebManager;
import com.fruit.shovel.model.HttpRouteModel;
import com.fruit.shovel.model.HttpRouteType;
import com.fruit.shovel.verticle.VerticleBase;
import io.vertx.core.eventbus.Message;

@Verticle
public class ServiceVerticle extends VerticleBase {

    @EventMethod(Constant.EVENT_REGIST_SERVICE)
    public void registService(Message msg) {
        WebManager manager = WebManager.getInstance();
        String root = manager.getVirtualPathPrefix();
        //时间戳
        manager.registServiceRoute(new HttpRouteModel(HttpRouteType.GET
                , SVConstant.EVENT_TIMESTAMP
                , root + "/timestamp"
                , true));

        if (ClusterConfManager.isClustered()) {
            //查询brokers
            manager.registServiceRoute(new HttpRouteModel(HttpRouteType.GET
                    , SVConstant.EVENT_CLUSTER_BROKERS_INFO
                    , root + "/brokers"
                    , true));

        }
        msg.reply(true);
    }
}
