# Properties属性配置文件使用详解
## 1.基础介绍
Spring Boot弱化配置的特性让属性配置文件的使用也更加便捷，它默认支持对application.properties或application.yml属性配置文件处理，
即在application.properties或application.yml文件中添加属性配置，可以使用@Value注解将属性值注入到beans中，
或使用@ConfigurationProperties注解将属性值绑定到结构化的beans中。

以上对application.properties文件的使用都是基于在classpath根路径下，
即将application.properties文件放在resources目录下。Spring Boot支持从以下位置加载application.properties文件：

```
* 1.当前目录下的/config子目录；
* 2.当前目录；
* 3.classpath下的/config包；
* 4.classpath根路径。
```

若这四个位置都存在application.properties文件，属性值的覆盖顺序是：1>2>3>4。

例如四个位置的application.properties文件都配置了db.name属性，最终生效的是当前目录下的/config子目录application.properties文件中的属性值；
如果四个位置的application.properties文件，只有classpath下的/config包application.properties文件配置了db.name，最终生效的就是这个位置下的属性值。

如果不喜欢将application.properties作为配置文件名，可以通过指定spring.config.name环境属性来更改它的名称，
可以将spring.config.name设置为系统属性或命令行参数，但是需要注意多数操作系统的key名称不允许以句号分割，
可以使用SPRING_CONFIG_NAME代替spring.config.name，例如将名称改为app.properties，可以使用如下命令行参数：
```
java -jar spring-boot-2.jar --spring.config.name=app
```
Spring Boot也支持自主指定配置文件的位置，可以使用spring.config.location环境属性引用一个明确的路径（目录位置或文件路径列表以逗号分割），
同样可以将spring.config.location设置为系统属性或命令行参数，key名同样也需要使用下划线代替句号分隔符，例如指定db.properties和mq.properties，
可以使用如下命令行参数：
```
java -jar spring-boot-2.jar --spring.config.location=classpath:/db.properties,classpath:/mq.properties
```

## 2. 加载更多配置

项目的属性配置文件比较多的时候，会把它们按用途分为多个配置文件，例如application-db.properties、application-mq.properties等，
Spring Boot也支持对这些文件的加载，除了使用spring.config.location实现，还可以在application.properties中添加spring.profiles.include属性实现，
属性值有多个的使用逗号分隔，例如额外加载application-db.properties和application-mq.properties配置如下：

```
spring.profiles.include=db,mq
```
注：假如没有在application.properties include其他配置文件，但在某个类中又要使用，该如何是好呢？
可以使用@PropertySource 来指定任意位置的配置文件

```
@Component
@PropertySource("classpath:application-db.properties")
@ConfigurationProperties(prefix = "db")
public class DbProperties {
    private String ip;
    private String port;
    // Page 不可以为内部类
    private Page page;
    // 省略getter 、setter    
}
```

## 3. 使用@ConfigurationProperties注解

虽然使用@Value注解可以很好的把属性配置文件中的值注入到beans中，但是，当属性配置文件变多或属性特别多的时候，使用@Value注解将变的很麻烦，
而@ConfigurationProperties注解可以很轻松的实现属性注入。例如有如下属性配置：

```
db.ip=127.0.0.1
db.port=3306
db.page.min=1
db.page.max=50
```

在编写属性注入bean时，只需要使用@ConfigurationProperties注解和prefix属性，prefix属性值用于指定属性的前缀 ，具体代码如下：

```
@Component
@ConfigurationProperties(prefix = "db")
public class DbProperties {

    private String ip;
    private String port;
    private String Page;
    //省略getter和setter

}
```

Spring Boot的@ConfigurationProperties注解对这种属性注入方式的key校验不是很严格，你可以在属性配置文件中配置DB.IP或DB_IP，Spring Boot都可以处理。
以下四种写法都是可以的。 
```
1.person.firstName // 标准骆驼式语法
2.person.first-name // 横线 多用于.properties 或 .yml
3.person.first_name // 下划线 多用于.properties 或 .yml
4.PERSON_FIRST_NAME // 大写 多用于环境变量
```