package test.demov1.carrier_test.mqtt;

import io.smallrye.mutiny.Uni;
import io.vertx.mqtt.MqttClient;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class MqttPublisher {
    @Inject
    MqttClient mqttClient;

    public Uni<Void> publishTemperature(int temperature) {
        String payload = "{ \"temperature\": " + temperature + " }";
        return null;//mqttClient.publish("hvac/temperature", Buffer.buffer(payload), MqttQoS.AT_LEAST_ONCE, false, false).replaceWithVoid();
    }
}
