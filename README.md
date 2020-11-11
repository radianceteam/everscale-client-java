# Java library for TON Client

### Prerequisites:
- Use the following command to install Java JDK:
```
    $ sudo apt-get install default-jdk
```
- Use the following command to install maven:
```
    $ sudo apt-get install maven
```
- Use the following command to install rust (see also https://www.rust-lang.org/tools/install ):
```
    $ curl --proto '=https' --tlsv1.2 -sSf https://sh.rustup.rs | sh
```
- To run test, Docker Engine is required. If the Engine isn't installed the tests will be skipped.
Follow installation instructions from https://docs.docker.com/engine/install/

### Build:
- To build, enter the following command:
```
    $ build.sh
```
- To generate Java API Documentation, use:
```
    $ mvn javadoc:javadoc
```
- You can find the generated documentation under ${Project_basedir}/binding/target/site/apidocs
- To run tests, enter the following command:
```
    $ mvn test
```
- If succeed, you can find "ton-client-binding-1.0-SNAPSHOT-jar-with-dependencies.jar" file located under ${Project_basedir}/binding/target

### Run
- To run, go to "binding" directory and enter the following command:
```
    $ mvn exec:java
```

### Clean
- To clean the generated files, enter the following command:
```
    $ mvn clean
```
