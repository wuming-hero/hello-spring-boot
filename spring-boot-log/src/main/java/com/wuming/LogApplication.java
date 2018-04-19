package com.wuming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot 支持Java Util Logging、Log4J2和Logback日志工具，默认使用Logback
 * 如果想使用其他日志工具，需要以下操作，以Log4J2为例

 * 1.将Log4J2的相关jar包添加到classpath目录下。可以使用spring-boot-starter-log4j2来添加jar，
 * 不过需要注意的是spring-boot-starter和spring-boot-starter-web会包含默认的Logback的jar，所以添加依赖时需要排除掉这些包含的jar
 *
 * 2.在classpath目录下创建log4j2-spring.xml或log4j2.xml日志配置文件，Spring Boot推荐使用带有-spring的文件名作为日志配置文件名。
 * 如果不想在classpath目录下创建log4j2-spring.xml或log4j2.xml日志配置文件，还可以通过在application.properties中配置logging.config属性来指定日志配置文件。
 * 示例是在classpath目录下创建log4j2-spring.xml文件
 * <?xml version="1.0" encoding="UTF-8"?>
 * <configuration status="OFF">
 *     <appenders>
 *         <Console name="Console" target="SYSTEM_OUT">
 *             <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
 *         </Console>
 *     </appenders>
 *     <loggers>
 *         <root level="trace">
 *             <appender-ref ref="Console"/>
 *         </root>
 *     </loggers>
 * </configuration>
 * 完成上面的两个步骤就可以使用log4j2作为日志工具了
 *
 * 多环境支持
 * 使用Logback作为日志工具，Spring Boot对它支持了多环境切换。
 * 可以在logback-spring.xml中使用<springProfile>标签来区分日志配置对哪个环境生效
 * @author wuming
 * Created on 2018/3/20 20:39
 */
@SpringBootApplication
public class LogApplication {

    private static final Logger logger = LoggerFactory.getLogger(LogApplication.class);

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(LogApplication.class);
        application.run(args);
        logger.debug("====LogApplication run====");
    }
}
