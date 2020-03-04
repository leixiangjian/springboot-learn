# springboot-learning
spring-boot 最佳实践学习
![Spring Boot 2.0](https://img.shields.io/badge/Spring%20Boot-2.0-brightgreen.svg)

## 一、学习结构
#### 1). [ 基础 - 入门 ]
project:getting-started、springboot-configuration<br>
- 带着问题学习<br>
 pom.xml引用的包、使用的日志组件是什么、怎么打包、部署结构规划、启动脚本、相关脚本服务命令<br>
 #### a.pom.xml引用的包<br>
 继承默认的spring-boot-starter-parent，引入spring-boot-starter、spring-boot-starter-web<br>
 #### b.使用的日志组件是什么<br>
 这里使用log4j来记录日志,排除掉logback<br>
 spring-boot引导使用commons logging日志组件，默认配置提供了java util logging、log4j2、logback；
 如果使用"Starters"组件，则默认使用Logback日志组件进行记录
 #### c.怎么打包<br>
 通过使用spring-boot-maven-plugin、maven-assembly-plugin来进行打包<br>
 #### d.部署结构规划<br>
 目录bin[启动/停止命令]、config[log4j.xml&application.yml]、lib[jar]、logs[output log file]、start.bat/startup.sh<br>
#### 2). [ 基础 - Web 开发 ]<br>
 包括了按照webjars规则规划与引入资源、请求参数的验证与包装、响应的格式转换、请求的过滤与拦截<br>
#### 3). [ 基础 – 安全 ]<br>
#### 4). [ 基础 – 数据存储 ]<br>
#### 5). [ 基础 – 数据缓存 ]<br>
#### 6). [ 基础 – 消息 ]<br>
#### 7). [ 基础 – 发送邮件 ]<br>
#### 8). [ 基础 – Validation ]<br>
#### 9). [ 基础 – 分布式事务 ]<br>
#### 10). [ 基础 – Scheduler ]<br>
#### 11). [ 基础 – Spring集成 ]<br>
#### 12). [ 基础 – Spring Session ]<br>
#### 13). [ 基础 – 基于JMX的监控和管理 ]<br>
#### 14). [ 基础 – 测试 ]<br>