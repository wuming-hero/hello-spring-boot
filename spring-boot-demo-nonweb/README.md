### Spring Boot非web应用程序实例
在Spring Boot中，要创建一个非Web应用程序，实现CommandLineRunner并覆盖run()方法，例如：
```
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class SpringBootConsoleApplication implements CommandLineRunner {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootConsoleApplication.class, args);
    }

    //access command line arguments
    @Override
    public void run(String... args) throws Exception {
        //do something
    }
}
```
下面是CommandLineRunner示例,如果运行这个Spring Boot，那么run方法将是入口点。

实例运行演示

```
## Go to project directory
## package it
$ mvn package

$ java -jar target/spring-boot-demo-nonweb-1.0.0-SNAPSHOT.jar
Hello non-web

$ java -jar target/spring-boot-demo-nonweb-1.0.0-SNAPSHOT.jar "wuming"
Hello wuming

```