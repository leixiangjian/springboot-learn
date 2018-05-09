# springboot-learning
spring-boot 最佳实践学习
## 一、学习结构
#### 1). [ 基础 - 入门篇 ]
- 带着问题学习<br>
 pom.xml引用的包、使用的日志组件是什么、怎么打包、部署结构规划、启动脚本、相关脚本服务命令<br>
 #### a.pom.xml引用的包<br>
 继承默认的spring-boot-starter-parent，引入spring-boot-starter、spring-boot-starter-web<br>
 #### b.使用的日志组件是什么<br>
 这里使用log4j来记录日志,排除掉logback<br>
 #### c.怎么打包<br>
 通过使用spring-boot-maven-plugin、maven-assembly-plugin来进行打包<br>
 #### d.部署结构规划<br>
 目录bin[启动/停止命令]、config[log4j.xml&application.yml]、lib[jar]、logs[output log file]、start.bat/startup.sh