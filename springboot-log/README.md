SpringBoot中默认是slf4j+logback的方式记录日志，如果我们需要切换到其他的日志，首先需要排除掉原有的日志包。修改pom文件。<br>
如果你需要使用log4j2日志系统，则需要通过在pom文件中配置排除一些应用包，如下:<br>
导入slf4j-log4j12的slf4j适配器包<br>
``` 
<dependency>
  <groupId>org.slf4j</groupId>
  <artifactId>slf4j-log4j12</artifactId>
</dependency>
```
resources/log4j.properties<br>
```
### set log levels ###
log4j.rootLogger=debug,stdout,D,E
### 输出到控制台###
log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.Target=System.out
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern=%d{ABSOLUTE} %5p %c{ 1 }:%L - %m%n

#### 输出到日志文件 ####
#log4j.appender.D = org.apache.log4j.DailyRollingFileAppender
#log4j.appender.D.File=logs/log.log
#log4j.appender.D.Append=true
#log4j.appender.D.Threshold=DEBUG
#log4j.appender.D.layout=org.apache.log4j.patternLayout
#log4j.appender.D.layout.ConversionPattern=%-d{yyyy-MM-dd HH:mm:ss} [%t:%r] - [%p] %m%n
```