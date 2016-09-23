**tests.demo_04_restassured**

1. Install and usage

Maven dependency: 

```
        <dependency>
            <groupId>io.rest-assured</groupId>
            <artifactId>rest-assured</artifactId>
            <version>3.0.1</version>
        </dependency>ó
```

Static imports:

```
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
```

[User Guide](https://github.com/rest-assured/rest-assured/wiki/Usage)

2. Demos

2.1 Hello World Demo (ITeBooks)

    Web: http://it-ebooks.info/tag/programming/
    API: http://it-ebooks-api.info/
    
    Tests: tests.demo_04_restassured.ITeBooks

2.1 GitHub API Demos

    Web: https://github.com
    API: https://api.github.com

    Tests: tests.demo_04_restassured.GitHubAPI