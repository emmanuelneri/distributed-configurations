# distributed-configurations

Distributed configurations with Spring Cloud Config Server

---

SouJava channel presentation: https://www.youtube.com/watch?v=9EUpXKL9n5E

TDC POA 2018 slides: https://www.slideshare.net/emmanuelnerisouza/configuraes-distribudas-com-spring-cloud-config

---

## Preparing environment

#### Building applications

```
cd distributed-configurations
mvn clean package
```

#### Building Config Server Docker image 

```
cd server
mvn dockerfile:build
```

## Executing 

#### Starting Config Server

```
docker run -it -p 8888:8888 distributed-configurations/server
```


Config Server log:
```
s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8888 (http)
b.c.e.config.CloudConfigAppConfig        : Started CloudConfigAppConfig in 5.479 seconds (JVM running for 6.201)

```

Config Server url: http://localhost:8888/ 

User/Password = Config/Config

#### Starting applications


```
cd app
mvn spring-boot:run
```

App application log:
```
c.c.c.ConfigServicePropertySourceLocator : Fetching config from server at: http://localhost:8888
c.c.c.ConfigServicePropertySourceLocator : Located environment: name=app, profiles=[default], label=null, version=24f2a8d2927a3bd516c49b06dc2ca37c9bab5326, state=null
b.c.PropertySourceBootstrapConfiguration : Located property source: CompositePropertySource {name='configService', propertySources=[MapPropertySource {name='configClient'}, MapPropertySource {name='https://github.com/emmanuelneri/distributed-configurations-files/app-default.properties'}, MapPropertySource {name='https://github.com/emmanuelneri/distributed-configurations-files/application-default.properties'}, MapPropertySource {name='https://github.com/emmanuelneri/distributed-configurations-files/app.properties'}, MapPropertySource {name='https://github.com/emmanuelneri/distributed-configurations-files/application.properties'}]}
s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8090 (http)
br.com.emmanuelneri.app.AppConfig        : Started AppConfig in 4.291 seconds (JVM running for 4.79)
```
App application url: http://localhost:8090/ 

User/Password = User/Default

```
cd web
mvn spring-boot:run
```

Web application log:
```
c.c.c.ConfigServicePropertySourceLocator : Fetching config from server at: http://localhost:8888
c.c.c.ConfigServicePropertySourceLocator : Located environment: name=web, profiles=[default], label=null, version=24f2a8d2927a3bd516c49b06dc2ca37c9bab5326, state=null
b.c.PropertySourceBootstrapConfiguration : Located property source: CompositePropertySource {name='configService', propertySources=[MapPropertySource {name='configClient'}, MapPropertySource {name='https://github.com/emmanuelneri/distributed-configurations-files/web-default.properties'}, MapPropertySource {name='https://github.com/emmanuelneri/distributed-configurations-files/application-default.properties'}, MapPropertySource {name='https://github.com/emmanuelneri/distributed-configurations-files/web.properties'}, MapPropertySource {name='https://github.com/emmanuelneri/distributed-configurations-files/application.properties'}]}
s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8070 (http)
br.com.emmanuelneri.app.WebConfig        : Started WebConfig in 8.151 seconds (JVM running for 9.283)```
```

Web application url: http://localhost:8070/ 

User/Password = User/Default
