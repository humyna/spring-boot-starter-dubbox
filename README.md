## spring-boot-starter-dubbox 
> starter解决了引用官方starter暴露的服务被使用高版本dubbox的客户端调用出现的序列化问题。

### 使用方法

#### 一、发布jar至maven伺服
1. 下载工程代码
2. 修改pom.xml中添加你的私服配置
3. 然后执行mvn deploy，发布至仓库

#### 二、springboot工程暴露和调用dubbo服务
1. 工程pom.xml引入
````
<dependency>
	<groupId>info.zoio.spring</groupId>
	<artifactId>spring-boot-starter-dubbox</artifactId>
	<version>1.0.0</version>
</dependency>
````

2. 配置
* yml配置
````
spring:
  dubbo:
    application:
        name: app-demo
    registry:
      address: zookeeper://127.0.0.1:2181 #修改成your zk配置
    consumer:
      check: false
    provider:
      timeout: 90000
      token: false
      retries: 0
      actives: 30
      accepts: 1000
    protocol:
      id: dubbo
      name: dubbo
      payload: 83886080
      port: 0
      dispatcher: all
      threadpool: fixed
      threads: 1000
````

3. 服务调用
````
@org.springframework.stereotype.Component
@org.springframework.context.annotation.Profile({"dev","test","online"})
public class DubboReference {
	@com.alibaba.dubbo.config.annotation.Reference(group = "demo", version = "1.0.0", timeout = 60000, retries = 0)
	public DemoFacade demoFacade;
}
````
> 其中dev、test、online对应
>
> application-dev.yml
>
> application-test.yml
>
> application-online.yml

* 业务调用
````
@javax.annotation.Resource
private DubboReference dubboReference;

dubboReference.demoFacade.methodXXX();
````
4. 暴露服务
````
@org.springframework.stereotype.Component
@Service(version = "1.0.0",timeout = 10000,interfaceClass = ExportDemoFacade.class,group="demo")
public class exportDemoFacadeImpl implements exportDemoFacade {
	//TODO
}
````














