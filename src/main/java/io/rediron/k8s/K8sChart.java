package io.rediron.k8s;

import org.cdk8s.ApiObjectMetadata;
import org.cdk8s.Chart;
import org.cdk8s.ChartProps;
import org.cdk8s.plus25.ServiceAccount;
import software.constructs.Construct;

import java.util.Map;

public class K8sChart extends Chart {

    public K8sChart(final Construct scope, final String id) {
        this(scope, id, null);
    }

    public K8sChart(final Construct scope, final String id, final ChartProps options) {
        super(scope, id, options);

        final ServiceAccount serviceAccount = ServiceAccount.Builder.create(this, "service-account")
                .metadata(ApiObjectMetadata.builder()
                        .name("service-account-name")
                        .annotations(Map.ofEntries(
                                Map.entry("eks.amazonaws.com/role-arn", "service-account-role-arn")
                        ))
                        .labels(Map.ofEntries(
                                Map.entry("app", "app-name"),
                                Map.entry("chart", "chart-name"),
                                Map.entry("release", "app-name"),
                                Map.entry("heritage", "heritage")
                        ))
                    .build())
                .build();
    }

}
