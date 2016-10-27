**Commandline execution**

0. Prerequisites

    Add [maven-surefire-plugin](https://maven.apache.org/surefire/maven-surefire-plugin/usage.html#) to your pom.xml
    
    ```
        <build>
          <pluginManagement>
            <plugins>
              <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>2.19.1</version>
              </plugin>
            </plugins>
          </pluginManagement>
        </build>
    ```
    
1. Execution

    Run all tests in GitHubTests class:
    ```
    mvn -Dtest=tests.demo_05_selenium.Tests.GitHubTests test
    ```
    
    Run all tests in demo_01_junit package:
    ```
    mvn -Dtest=tests.demo_01_junit.* test
    ```