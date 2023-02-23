package io.rediron.cdk;

import io.rediron.config.AwsProperties;
import io.rediron.support.ResourceBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import software.amazon.awscdk.App;
import software.amazon.awscdk.Environment;
import software.amazon.awscdk.StackProps;

@Component
@RequiredArgsConstructor
public class AwsCdkResourceBuilder implements ResourceBuilder {

    private final AwsProperties properties;

    @Override
    public void build() {
        App app = new App();

        new CdkStack(app, "CdkStack", StackProps.builder()
                .env(Environment.builder()
                        .account(properties.getAccount())
                        .region(properties.getRegion())
                        .build())
                .build());

        app.synth();
    }

}
