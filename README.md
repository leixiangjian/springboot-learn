# springboot-learning
spring-boot 最佳实践学习
## 一、学习结构
#### 1). [ 基础 - 入门 ]
project:getting-started、springboot-configuration<br>
- 带着问题学习<br>
 pom.xml引用的包、使用的日志组件是什么、怎么打包、部署结构规划、启动脚本、相关脚本服务命令<br>
 #### a.pom.xml引用的包<br>
 继承默认的spring-boot-starter-parent，引入spring-boot-starter、spring-boot-starter-web<br>
 #### b.使用的日志组件是什么<br>
 这里使用log4j来记录日志,排除掉logback<br>
 #### c.怎么打包<br>
 通过使用spring-boot-maven-plugin、maven-assembly-plugin来进行打包<br>
 #### d.部署结构规划<br>
 目录bin[启动/停止命令]、config[log4j.xml&application.yml]、lib[jar]、logs[output log file]、start.bat/startup.sh<br>
#### 2). [ 基础 - Web 开发 ]<br>
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