# Java library for TON Client

[![SDK version](https://img.shields.io/badge/TON%20SDK%20version-1.12.0-green)](https://github.com/tonlabs/TON-SDK/tree/1.12.0)

The Library is a binding for [TONOS Client](https://github.com/tonlabs/TON-SDK) written in Java
that act as a bridge between TONOS Client and a Java application. The library includes original
TONOS Library with incorporated support of [Java Native Interface (JNI)](https://en.wikipedia.org/wiki/Java_Native_Interface)
which allows direct access to TONOS Client from Java Virtual Machine.

### Code Generation

The most of the library source code is generated from `api.json` by script `./binding/gen-java.js`.
To use the script you must have [Node.js](https://nodejs.org/en/) installed.

### Prerequisites
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

### Build
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
- If succeed, you can find "ton-client-binding-1.12.0-jar-with-dependencies.jar" file located under ${Project_basedir}/binding/target


### Clean
- To clean the generated files, enter the following command:
```
    $ mvn clean
```
### How to use the library

Once the build succeed you will have the library installed to your local maven repository.
To use it in your projects, add the dependency to `pom.xml`

```xml
    ...
    <dependency>
      <groupId>com.radiance.tonclient</groupId>
      <artifactId>ton-client-binding</artifactId>
      <version>1.12.0</version>
    </dependency>
    ...
```

Example of usage:

```java
    // At the beginning TON Context must be created
    // Configuration parameters are passed as a json string
    TONContext context = TONContext.create("{\"network\":{\"server_address\":\"https://net.ton.dev/graphql\"}}");

    /* Alternatively TON context can be configured via ClientConfig object
    TONContext context = TONContext.create(new ClientConfig(
        new NetworkConfig("https://net.ton.dev/graphql")
    ));
    */

    try {
        // TON methods can be invoked via context directly ...
        String randomBytes = context
            .requestJSON("crypto.generate_random_bytes", "{\"length\":12}")
            .get()
            .findValue("bytes").asText();
        System.out.println("Random bytes: '" + randomBytes + "'");

        // ... or using convenience classes
        Crypto crypto = new Crypto(context);
        randomBytes = crypto.generateRandomBytes(12).get();
        System.out.println("Random bytes: '" + randomBytes + "'");
    } finally {
        // context should be destroyed after using
        context.destroy();
    }
```

### See also
- More usage examples [test sources](binding/src/test/java/com/radiance/tonclient/)
- [Java API Docs](apidocs/)
- [Support channel](https://t.me/RADIANCE_TON_SDK)
