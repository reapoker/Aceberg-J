---
title: 介绍
type: guide
order: 2
---



![Aceberg logo](/images/Aceberg0.jpg)

Aceberg是基于Spring Cloud开发的项目群，可作为微服务开发基础框架，也可用于Spring Cloud应用实践的学习交流。

**功能架构图**

![Aceberg功能架构图](/images/features.png)

**项目成员**

| 项目名                      | 简介                                   | 作者       |
| ------------------------ | ------------------------------------ | -------- |
| jbone-sso                | 单点登录模块                               | reapoker |
| jbone-service-management | 服务管理模块(包含注册中心、服务网关、服务监控、调用链追踪等)      | reapoker |
| jbone-system             | 系统管理模块,通用权限管理等                       | reapoker |
| jbone-system-admin       | 系统管理后台                               | reapoker |
| jbone-fs                 | 文件系统，用于存储和管理文件、图片等                   | reapoker |
| jbone-cms                | 多站点内容管理系统                            | reapoker |
| jbone-common             | 公共模块，封装工具类等                          | reapoker |
| jbone-banner             | jbone通用艺术banner                      | reapoker |
| jbone-configuration      | 公共配置模块                               | reapoker |
| jbone-ui                 | 以webjars形式管理前端静态资源，所有包含页面的工程需要依赖此模块。 | reapoker |
|                          |                                      |          |
|                          |                                      |          |

# 系统简介

## 系统要求

**JDK11+**


## 技术选型
| 技术                     | 简介                     | 网址                                       |
| ---------------------- | ---------------------- | ---------------------------------------- |
| Spring Boot            | 基础构建框架，用于快速整合各资源       | [https://projects.spring.io/spring-boot/](https://projects.spring.io/spring-boot/) |
| Spring Framework       | 底层容器                   | [https://projects.spring.io/spring-framework/](https://projects.spring.io/spring-framework/) |
| Spring Cloud           | 微服务框架                  | [https://projects.spring.io/spring-cloud/](https://projects.spring.io/spring-cloud/) |
| Spring Cloud Eureka    | 服务注册中心                 | [https://projects.spring.io/spring-cloud/](https://projects.spring.io/spring-cloud/) |
| Spring Cloud Zuul      | 服务网关                   | [https://projects.spring.io/spring-cloud/](https://projects.spring.io/spring-cloud/) |
| Spring Cloud Hystrix   | 服务容错框架                 | [https://projects.spring.io/spring-cloud/](https://projects.spring.io/spring-cloud/) |
| Spring Cloud Feign     | 微服务声明式调用框架             | [https://projects.spring.io/spring-cloud/](https://projects.spring.io/spring-cloud/) |
| Spring Boot Admin      | 服务管理中心                 | [https://github.com/codecentric/spring-boot-admin](https://github.com/codecentric/spring-boot-admin) |
| Spring Data Jpa        | 持久化框架                  | [https://projects.spring.io/spring-data-jpa/](https://projects.spring.io/spring-data-jpa/) |
| Spring Data Redis      | 缓存框架                   | [https://projects.spring.io/spring-data-redis/](https://projects.spring.io/spring-data-redis/) |
| Apache Shiro           | 权限框架                   | [http://shiro.apache.org/](http://shiro.apache.org/) |
| thymeleaf-extras-shiro | thymeleaf的shiro标签      | [https://github.com/theborakompanioni/thymeleaf-extras-shiro](https://github.com/theborakompanioni/thymeleaf-extras-shiro) |
| Apereo CAS             | 单点登陆框架                 | [https://github.com/apereo/cas](https://github.com/apereo/cas) |
| Spring Validator       | 后端验证框架                 | [https://projects.spring.io/spring-framework/](https://projects.spring.io/spring-framework/) |
| Hibernate Validator    | Hibernate验证框架          | [http://hibernate.org/](http://hibernate.org/) |
| lombok                 | 一个通过注解自动生成get/set方法的类库 | [https://projectlombok.org/](https://projectlombok.org/) |
| webjars                | 以jars的形式管理前端静态资源       | [http://www.webjars.org/](http://www.webjars.org/) |
| Thymeleaf              | 模板引擎                   | [http://www.thymeleaf.org/](http://www.thymeleaf.org/) |
| Maven                  | 项目构建管理                 | [http://maven.apache.org/](http://maven.apache.org/) |
| Redis                  | 分布式缓存数据库               | [https://redis.io/](https://redis.io/)   |
| Mysql                  | 对象关系数据库                | [https://www.mysql.com/](https://www.mysql.com/) |

jbone是一个项目群，包含公共项目和业务线项目。

公共项目是公共jar包或各系统都要用到的项目，是必须要安装的项目，如系统管理、单点登录等；

业务线项目是为了满足某业务需求的项目，是根据个人需要选择安装的项目，如CMS、电子商城等。



## 安装Redis

### 下载

```shell script
wget http://download.redis.io/releases/redis-5.0.3.tar.gz
```

### 解压

```shell script
tar xzf redis-5.0.3.tar.gz
```

### 安装

```shell script
cd redis-5.0.3
make
```

### 配置

在`redis.conf`中加入以下配置：

```shell script
requirepass jbone
daemonize yes
```

### 启动

```shell script
cd redis-5.0.3/src/
./redis-server ../redis.conf
```

## 安装RabbitMq

### 安装

```shell script
brew install rabbitmq
```

### 启动

```shell script
/usr/local/Cellar/rabbitmq/3.7.10/sbin
./rabbitmq-server -detached
```

## 安装Nginx

### 安装

```shell script
brew install nginx
```

### 配置

在nginx.conf中加入以下配置：

```shell script
upstream register {       
      server 127.0.0.1:10001;
}
upstream smadmin {
      server 127.0.0.1:10002;
}
upstream gateway {
      server 127.0.0.1:10005;
}
upstream sso {
      server 127.0.0.1:30001;
}
upstream ssomanagement {
      server 127.0.0.1:30002;
}
upstream sysadmin {
      server 127.0.0.1:20002;
}
upstream cmsadmin {
      server 127.0.0.1:50002;
}
upstream cmsportal {
      server 127.0.0.1:50003;
}
    server {
        listen       80;
        server_name  localhost;
        location / {
            root   html;
            index  index.html index.htm;
        }
        error_page   500 502 503 504  /50x.html;
        location = /50x.html {
            root   html;
        }
    }
server {
        listen       80;
        server_name  sso.local.jbone.cn;
        location / {
             proxy_set_header Host $host;
             proxy_set_header X-Real-Ip $remote_addr;
             proxy_set_header X-Forwarded-For $remote_addr;
             proxy_pass http://sso/;
             proxy_redirect off;
             root index.html;
        }
        error_page   500 502 503 504  /50x.html;
        location = /50x.html {
            root   html;
        }
    }
server {
        listen       80;
        server_name  ssomanagement.local.jbone.cn;
        location / {
             proxy_set_header Host $host;
             proxy_set_header X-Real-Ip $remote_addr;
             proxy_set_header X-Forwarded-For $remote_addr;
             proxy_pass http://ssomanagement/;
             proxy_redirect off;
             root index.html;
        }
        error_page   500 502 503 504  /50x.html;
        location = /50x.html {
            root   html;
        }
    }
server {
        listen       80;
        server_name  gateway.local.jbone.cn;
        location / {
             proxy_set_header Host $host;
             proxy_set_header X-Real-Ip $remote_addr;
             proxy_set_header X-Forwarded-For $remote_addr;
             proxy_pass http://gateway/;
             proxy_redirect off;
             root index.html;
        }
        error_page   500 502 503 504  /50x.html;
        location = /50x.html {
            root   html;
        }
    }
server {
        listen       80;
        server_name  smadmin.local.jbone.cn;
        location / {
             proxy_set_header Host $host;
             proxy_set_header X-Real-Ip $remote_addr;
             proxy_set_header X-Forwarded-For $remote_addr;
             proxy_pass http://smadmin/;
             proxy_redirect off;
             root index.html;
        }
        error_page   500 502 503 504  /50x.html;
        location = /50x.html {
            root   html;
        }
    }
server {
        listen       80;
        server_name  sysadmin.local.jbone.cn;
        location / {
             proxy_set_header Host $host;
             proxy_set_header X-Real-Ip $remote_addr;
             proxy_set_header X-Forwarded-For $remote_addr;
             proxy_pass http://sysadmin/;
             proxy_redirect off;
             root index.html;
        }
        error_page   500 502 503 504  /50x.html;
        location = /50x.html {
            root   html;
        }
    }
server {
        listen       80;
        server_name  cmsadmin.local.jbone.cn;
        location / {
             proxy_set_header Host $host;
             proxy_set_header X-Real-Ip $remote_addr;      
             proxy_set_header X-Forwarded-For $remote_addr;
             proxy_pass http://cmsadmin/;
             proxy_redirect off;
             root index.html;
        }

        error_page   500 502 503 504  /50x.html;
        location = /50x.html {
            root   html;
        }
    }
server {
        listen       80;
        server_name  cmsportal.local.jbone.cn;
        location / {
             proxy_set_header Host $host;
             proxy_set_header X-Real-Ip $remote_addr;
             proxy_set_header X-Forwarded-For $remote_addr;
             proxy_pass http://cmsportal/;
             proxy_redirect off;
             root index.html;
        }
        error_page   500 502 503 504  /50x.html;
        location = /50x.html {
            root   html;
        }
    }
server {
        listen       80;
        server_name  register.local.jbone.cn;
        

        location / {
             proxy_pass http://register;
             proxy_redirect off;
             root index.html;
        }

        location = /50x.html {
            root   html;
        }

    }
```

### 启动

```shell script
./nginx
```

## 配置本地Host

```properties
127.0.0.1 sso.local.jbone.cn
127.0.0.1 ssomanagement.local.jbone.cn
127.0.0.1 sysadmin.local.jbone.cn
127.0.0.1 cmsadmin.local.jbone.cn
127.0.0.1 cmsportal.local.jbone.cn
127.0.0.1 smadmin.local.jbone.cn
127.0.0.1 gateway.local.jbone.cn
127.0.0.1 register.local.jbone.cn
127.0.0.1 zipkinserver.local.jbone.cn
127.0.0.1 smmonitor.local.jbone.cn
```

## 安装公共项目

### 下载源码

### 导入IDE

将下载的源码导入到自己的IDE中

### install

按以下顺序一次安装：

- jbone
- jbone-system
- jbone-sso

```shell script
mvn install
```

> 注意：公共jar项目都发布到maven中央仓库了，如果不修改公共jar包，可以不在本地install。

## 本地启动

按以下顺序来启动项目：

1. 先启动Mysql、Redis、RabbitMq、Nginx等;
2. 启动服务治理部分;
3. 启动其他项目。

### 启动服务注册中心

本地运行`jbone-sm-register`的启动类，或放在`tomcat`中运行。

### 启动系统管理服务

本地运行`jbone-system-server`的启动类，或放在`tomcat`中运行。

### 启动SSO

放在`tomcat`中运行。

注意`sso-server`的端口号为`30001`，`sso-management`的端口号为`30002`。

### 启动系统管理后台

本地运行`jbone-system-admin`的启动类，或放在`tomcat`中运行。

### 访问测试

在浏览器访问`http://sysadmin.local.jbone.cn`，重定向到登录页面。

输入默认用户名密码`reapoker/nono7758521`，登录成功后跳转到系统页面，即为成功。

