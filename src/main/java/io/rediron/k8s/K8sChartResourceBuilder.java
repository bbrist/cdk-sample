package io.rediron.k8s;

import io.rediron.support.ResourceBuilder;
import org.cdk8s.App;
import org.springframework.stereotype.Component;

@Component
public class K8sChartResourceBuilder implements ResourceBuilder {

    @Override
    public void build() {
        final App app = new App();

        new K8sChart(app, "helm-chart");

        app.synth();
    }

}
