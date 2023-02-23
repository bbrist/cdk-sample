package io.rediron.k8s;

import io.rediron.config.AppProperties;
import io.rediron.support.ResourceBuilder;
import lombok.RequiredArgsConstructor;
import org.cdk8s.App;
import org.cdk8s.ChartProps;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class K8sChartResourceBuilder implements ResourceBuilder {

    private final AppProperties properties;

    @Override
    public void build() {
        final App app = new App();

        new K8sChart(app, "helm-chart", ChartProps.builder()
                .labels(Map.ofEntries(
                        Map.entry("app", properties.getIdentifier()),
                        Map.entry("chart", String.format("%s-%s", properties.getIdentifier(), properties.getVersion())),
                        Map.entry("release", properties.getIdentifier()),
                        Map.entry("heritage", "cdk8s")
                ))
                .build());

        app.synth();
    }

}
