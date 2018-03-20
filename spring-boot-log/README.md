## 日志使用详解

Spring Boot内部使用Commons Logging记录所有日志，它支持使用Java Util Logging、Log4J2和Logback日志工具，并为它们提供了默认配置，默认配置情况下日志只会输出到控制台，当然也可以修改配置将日志输出到文件。

#### 1.默认日志配置
如果项目使用Starters，则默认使用Logback作为日志记录工具，并且默认配置下日志只会在控制台输出，例如如下一行日志记录信息：
```
2018-03-06 20:00:01.801  INFO 22532 --- [main] com.example.PropertiesTest : Started PropertiesTest in 2.422 seconds (JVM running for 5.826)
```
* 这行日志信息是按照一定格式输出，具体格式内容包含以下元素：
* 日期和时间：精确到毫秒；
* 日志级别：标识输出的日志级别，如ERROR、WARN、INFO、DEBUG或TRACE，需要注意的是Logback没有FATAL级别，配置时可以配置成ERROR；
* 进程ID，如22532；
* ---：分隔符，用于标识实际日志记录的开始位置；
* 线程名：被显示在方括号内，如[main]；
* Logger名：通常是源类名；
* 冒号分隔符；
* 日志信息。

默认配置下，日志将记录ERROR、WARN和INFO级别的日志信息。当然你也可以开启调试模式记录更多信息，有两种方法：
* 1.命令行启动应用时指定开启调试模式，例如如下命令行：java -jar test.jar --debug；
* 2.在application.properties中配置debug=true，或在application.yml中配置debug：true ；
需要注意的是开启调试模式并不是改变日志记录的级别为DEBUG！

#### 2.日志输出到文件
在实际的项目开发中需要将日志信息记录到文件中，以便保存和查询问题。可以在application.properties中配置logging.file属性，用于指定日志文件的位置(可以是相对位置或绝对位置)和名称，它将会把日志信息记录到对应位置下的日志文件中，例如配置logging.file=app.log，将会在当前classpath下创建app.log，并将日志信息记录到这个文件中。这个日志文件配置同样可以配置在application.yml中。

也可以在application.properties中配置logging.path属性，用于指定日志文件的位置，可以是相对位置或绝对位置 ，同时生成的日志文件名称固定为spring.log，例如配置logging.path=/logs，将会在根目录下创建logs目录，并生成spring.log日志文件，日志信息记录到这个文件中。这个日志文件位置配置同样可以配置在application.yml中。

本以为Spring Boot的这两个属性配置是可以配合使用，实验发现并不能。如果同时配置了logging.file和logging.path，最终生效的只是logging.file。

#### 3.日志文件大小
指定日志信息输出到文件后，默认情况下使用Logback作为日志记录工具，会记录ERROR、WARN和INFO级别的日志信息，并且日志文件大小超过10MB后，日志文件将会被打包成.gz的压缩文件，且压缩文件名称会排序累加，例如app.log.2018-03-06.0.gz、app.log.2018-03-06.1.gz。

当然也可以修改日志文件最大大小，通过在application.properties中配置logging.file.max-size，例如配置最大大小为100MB，则logging.file.max-size=100MB，这里需要注意的是这个属性配置仅对默认Logback生效。

还需要注意的是，logging.file.max-size属性值需要带单位，可以是KB、MB或GB，单位大小写不敏感都可以使用，查看源码可以得到验证

#### 4.修改日志级别
修改日志记录的级别可以在application.properties或application.yml中配置，添加logging.level.<logger-name>=<level>，其中level可以是TRACE、DEBUG、INFO、WARN、ERROR、FATAL或OFF，对于root级的配置可以使用logging.level.root，下面是一些配置示例：
```
logging.level.root=INFO
logging.level.org.springframework.web=DEBUG
logging.level.org.hibernate=ERROR
```

#### 5.自定义日志工具
Spring Boot 2.0版本支持Java Util Logging、Log4J2和Logback日志工具，默认使用Logback，如果不想使用默认日志工具，可以通过如下步骤自定义日志工具，例如使用Log4J2作为日志工具：

(一) 将Log4J2的相关jar包添加到classpath目录下。可以使用spring-boot-starter-log4j2来添加jar，不过需要注意的是spring-boot-starter和spring-boot-starter-web会包含默认的Logback的jar，所以添加依赖时需要排除掉这些包含的jar，对应Gradle的构建文件代码如下：
```
dependencies {
    compile("org.springframework.boot:spring-boot-starter:2.0.0.RELEASE"){
        exclude module: 'spring-boot-starter-logging'
    }
    compile group: 'org.springframework.boot', name: 'spring-boot-starter-log4j2', version: '2.0.0.RELEASE'
    testCompile("org.springframework.boot:spring-boot-starter-test:2.0.0.RELEASE")
}

configurations {
    all*.exclude module: 'spring-boot-starter-logging'
    all*.exclude module: 'logback-classic'
    all*.exclude module: 'log4j-over-slf4j'
}
```

(二) 在classpath目录下创建log4j2-spring.xml或log4j2.xml日志配置文件，Spring Boot推荐使用带有-spring的文件名作为日志配置文件名。如果不想在classpath目录下创建log4j2-spring.xml或log4j2.xml日志配置文件，还可以通过在application.properties中配置logging.config属性来指定日志配置文件。示例是在classpath目录下创建log4j2-spring.xml文件，具体代码如下：

```
<?xml version="1.0" encoding="UTF-8"?>
<configuration status="OFF">
    <appenders>
        <Console name="Console" target="SYSTEM_OUT">
            <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
        </Console>
    </appenders>

    <loggers>
        <root level="trace">
            <appender-ref ref="Console"/>
        </root>
    </loggers>
</configuration>


```
完成上面的两个步骤就可以使用log4j2作为日志工具了。当然，你也可以强制让Spring Boot使用某一个特定的日志工具，
通过配置一个系统属性，属性的key为org.springframework.boot.logging.LoggingSystem，value是LoggingSystem子类的全限定名，
例如Log4J2LoggingSystem，或者直接将value设置为none来禁止Spring Boot的日志默认配置。

如果想自定义Logback的日志配置文件，Spring Boot支持加载logback-spring.xml、logback-spring.groovy、logback.xml或logback.groovy，不过推荐使用logback-spring.xml。

#### 6.多环境支持
使用Logback作为日志工具，Spring Boot对它支持了多环境切换。可以在logback-spring.xml中使用<springProfile>标签来区分日志配置对哪个环境生效，例如如下配置代码：
```
<springProfile name="dev">
    <!-- 当dev环境的profiles生效时，这部分配置生效 -->
</springProfile>

<springProfile name="dev, test">
    <!-- 当dev或test环境的profiles生效时，这部分配置生效 -->
</springProfile>

<springProfile name="!prod">
    <!-- 当非prod环境的profiles生效时，这部分配置生效 -->
</springProfile> 
```