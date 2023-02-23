# Infrastructure as Code (using CDKs) Sample

## Overview

This project is a sample of how to use the [AWS CDK](https://docs.aws.amazon.com/cdk/latest/guide/home.html) and [K8S CDK](https://cdk8s.io/) to define infrastructure as code.

[Construct Hub](https://constructs.dev/) is a great resource for finding constructs to use in your CDK projects.

## AWS CDK

The `cdk.json` file tells the CDK Toolkit how to execute your app.

It is a [Maven](https://maven.apache.org/) based project, so you can open this project with any Maven compatible Java IDE to build and run tests.

Resources:
* [AWS CDK V2](https://docs.aws.amazon.com/cdk/api/v2/)
* [AWS CDK Workshop](https://cdkworkshop.com/)

### Useful commands

* `mvn package`        compile and run tests
* `cdk ls`             list all stacks in the app
* `cdk synth`          emits the synthesized CloudFormation template
* `cdk deploy`         deploy this stack to your default AWS account/region
* `cdk diff`           compare deployed stack with current state
* `cdk docs`           open CDK documentation

### Integrating with Spring Boot

Specify the `--app` option to specify the command and any arguments necessary.
For example:
* `cdk deploy --app "mvn -e -q compile spring-boot:run -Dspring-boot.run.profiles=dev"`
* `cdk synth -a "mvn -e -q compile spring-boot:run -Dspring-boot.run.profiles=dev -Dspring-boot.run.arguments=--spring.config.location=/path/to/file.yml,/path/to/another/file.yml"`

## K8S CDK

The `cdk8s.json` file tells the CDK Toolkit how to execute your app.

Resources:
* [Documentation Reference](https://cdk8s.io/docs/latest/getting-started/)

### Useful commands

* `cat help`           Prints this message  
* `cdk8s synth`        Synthesize k8s manifests to dist/
* `cdk8s import`       Imports k8s API objects to "src/main/java/imports/"
* `mvn compile`        Compiles your java packages

### Deploying the Chart

Run the following command to deploy the synthesized chart:
```
kubectl apply -f dist/
```

## Notes

Running `cdk synth` will produce both the CloudFormation template and the k8s manifests (i.e. it doesn't appear necessary to run both `cdk synth` and `cdk8s synth`).
However, it does not appear that running `cdk8s synth` will produce the CloudFormation template.