package com.fruit.gateway;

import com.fruit.shovel.ShovelLauncher;

public class GatewayLauncher extends ShovelLauncher {
    public GatewayLauncher() {
        this.mainVerticleClass = GatewayMainVerticle.class;
    }

    public static void main(String[] args) {
        GatewayLauncher launcher = new GatewayLauncher();
        launcher.prepare(args);
        launcher.runCommand(args);
    }
}
