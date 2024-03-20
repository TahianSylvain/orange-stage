mvn package # -Pnative -uber-jar=true
#mvn package -Pnative -Dquarkus.native.container-build=true
cd target/camunda-bpm-quarkus-example-spin-plugin-1.0.0-SNAPSHOT-native-image-source-jar/
#java -jar Xdebug -agentlib:jdwp="transport=dt_socket,server=y,suspend=n,address=5001" \
#  *-SNAPSHOT-runner.jar
java -jar camunda-bpm-quarkus-example-spin-plugin-1.0.0-SNAPSHOT-runner.jar
