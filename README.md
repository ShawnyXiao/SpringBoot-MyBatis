# SpringBoot-MyBatis

最近由于实训，发现很多同学都在开发Java后台，因此少不了重复繁杂的配置工作，这个框架就是为了减少这些不必要的工作。它集成了**Spring Boot**和**MyBatis**，并实现了一个类似“书籍管理”的模块（支持**RESTful API**）以供参考，框架简单易懂。完全可以根据自己的需要，修改这个框架，以实现自己想实现的功能。

- [中文文档](README-zh.md)
- [English documents](README.md)

## 技术

- Spring Boot
- MyBatis
- MySQL or HSQLDB (a in-memory database)
- Commons Logging
- Java 8 Lambda Expressions
- Lombok
- Apache Commons Lang

## 细节

这个项目其实有点像一个Demo项目。我没有将Spring Boot、MyBatis和其他框架提供的功能再封装一层（虽然可以这样做），以提供更加应用级的接口。这是因为我觉得这些框架已经提供了很好的封装度和灵活度，完全只需要“掌控”他们，再“利用”他们，你就能实现你想要的。既然是一个Demo项目，所以对于初学者，还是有必要讲解一下其中的“**门道**”。对于我个人来说，这一个部分就有点像在回忆：“我当时**怎么做**的，**为什么这样做**”。（顺序有点乱，请根据需要阅读）

### 文件目录

```
`-- src
	|-- main
	|	|-- java
	|	|	`-- com
	|	|		`-- shawn
	|	|			|-- constant
	|	|			|-- model
	|	|			|	|-- dto
	|	|			|	`-- entity
	|	|			|-- monitor
	|	|			|-- repository
	|	|			|	`-- mybatis
	|	|			|-- service
	|	|			|	`-- impl
	|	|			|-- util
	|	|			`-- web
	|	|				|-- controller
	|	|				|-- excetpion
	|	|				`-- filter
	|	`-- resources
	|		|-- com
	|		|	`-- shawn
	|		|		`-- repository
	|		|			`-- mybatis
	|		`-- db
	|			`-- hsqldb
	`-- test
		`-- ...(& so on)
```

- src/main/java/com/shawn/constant: 该目录放置了各种常量类
- src/main/java/com/shawn/model: 该目录放置了各种模型类，其子目录dto放置了DTO（Data Trasfer Object）类，其另一子目录entity放置了实体类
- src/main/java/com/shawn/monitor: 该目录放置了各种监测类
- src/main/java/com/shawn/repository: 该目录放置了数据库增删改查的接口，其子目录impl放置了这些接口的实现类
- src/main/java/com/shawn/service: 该目录下放置服务（一个服务对应于一些业务逻辑的集合）的接口，其子目录impl放置了这些接口的实现类
- src/main/java/com/shawn/util: 该目录放置了各种工具类
- src/main/java/com/shawn/web: 该目录放置了和网络层相关的一切，包括控制器、异常处理、过滤器等等
- src/main/resources/com/shawn/repository/mybatis: 该目录放置了MyBatis的映射器XML文件
- src/main/resources/db: 该目录放置了有关内存数据库的脚本，其子目录hsqldb放置了HSQL的数据库脚本

### 架构

为了节约时间就不谈架构的重要性了，那我们先把关注点放在Web应用的**职责**上（Web应用应该做些什么）：

- 它应该能够处理用户的输入，并且返回正确的相应给用户
- 它应该拥有一套异常处理机制，来应对错误发生的时候
- 它应该拥有一个事务管理策略
- 它应该能够对用户进行认证和授权
- 它应该要实现业务逻辑，为用户提供服务
- 它应该要能操纵数据库和其他资源
- ……

那么，怎样才能，既实现这些职责，又达到低耦合高内聚（提供一定的封装度和灵活度）的要求？**三层架构**可以支持这一切，它的概览如下图所示：

![Three Layer architecture](pic/three_layer.png)

- **Web层**：Web应用的最顶层。它负责处理用户输入以及返回正确的相应给用户；处理其他层抛出的异常并向用户反映错误的发生；对用户进行认证，拒绝未认证的用户访问。
- **Service层**：Web应用的中间层。它应该组织业务逻辑，为Web层提供服务；使得所有服务都是事务性的（要么完成，要么什么都没做）；负责用户的授权。
- **Repository层**：Web应用的最底层。它负责操纵数据库，以实现对数据库的增删改查。

那么，这三层的组件要如何交互呢？最佳实践是：**上层组件使用下层组件，使用模型（Model）作为交互媒介**。模型包括两种：数据传输对象（DTO）和领域模型（Domain Model）。

- **DTO**: 一种用户可见的数据容器。它用来传输用户可见的数据，屏蔽了Web应用的内部实现。
- **Domain Model**: 具有领域特征的数据容器。一般来说，它对应于数据库中的表，它代表了Web应用的内部实现，应该对用户透明。

## 引用

- [Understanding Spring Web Application Architecture: The Classic Way](https://www.petrikainulainen.net/software-development/design/understanding-spring-web-application-architecture-the-classic-way/)
- [MyBatis](http://www.mybatis.org/mybatis-3/zh/index.html)
- [mybatis &#x2013; MyBatis 3 | Mapper XML Files](http://www.mybatis.org/mybatis-3/sqlmap-xml.html#Result_Maps)
- [Mybatis关联查询一对一和一对多的实现 - 林炳文Evankaka的专栏 - 博客频道 - CSDN.NET](http://blog.csdn.net/evankaka/article/details/45674101)
- [Mybatis 鉴别器 - jordandandan的专栏 - 博客频道 - CSDN.NET](http://blog.csdn.net/jordandandan/article/details/50253893)
- [Exception Handling in Spring MVC](http://spring.io/blog/2013/11/01/exception-handling-in-spring-mvc)
- [Spring Boot中Web应用的统一异常处理 | 程序猿DD](http://didispace.com/springbootexception/)
- [java - Spring Boot REST service exception handling - Stack Overflow](http://stackoverflow.com/questions/28902374/spring-boot-rest-service-exception-handling)
- [Getting Started · Managing Transactions](http://spring.io/guides/gs/managing-transactions/)
- [HTTP Tutorial](https://www.tutorialspoint.com/http/index.htm)
- [ResponseEntity (Spring Framework 4.3.4.RELEASE API)](http://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/http/ResponseEntity.html)
- [ServletUriComponentsBuilder (Spring Framework 4.3.4.RELEASE API)](http://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/servlet/support/ServletUriComponentsBuilder.html)
- [Optional (Java Platform SE 8 )](https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html)
- [Java 8 Optional类深度解析 - ImportNew](http://www.importnew.com/6675.html)
- [Spring REST: Exception handling on a @Controller level](http://fruzenshtein.com/spring-rest-exception-handling-1/)
- [Spring REST: Exception handling on a @ControllerAdvice level](http://fruzenshtein.com/spring-rest-exception-handling-2/)
- [Spring REST: Exception handling on a @ControllerAdvice level](http://fruzenshtein.com/spring-rest-exception-handling-3/)
- [Spring MVC中文翻译文档](http://mvc.linesh.tw/)
- [22.&nbsp;Web MVC framework](http://docs.spring.io/spring-framework/docs/current/spring-framework-reference/html/mvc.html)
- [Spring Boot Reference Guide](http://docs.spring.io/spring-boot/docs/current/reference/html/index.html)
- [MIME 参考手册](http://www.w3school.com.cn/media/media_mimeref.asp)
- [MIME - Wikipedia](https://en.wikipedia.org/wiki/MIME)
- [多用途互联网邮件扩展 - 维基百科，自由的百科全书](https://zh.wikipedia.org/wiki/%E5%A4%9A%E7%94%A8%E9%80%94%E4%BA%92%E8%81%AF%E7%B6%B2%E9%83%B5%E4%BB%B6%E6%93%B4%E5%B1%95)
- [MIME协议分析 - 彭令鹏(bripengandre)的专栏 - 博客频道 - CSDN.NET](http://blog.csdn.net/bripengandre/article/details/2192982)
- [Difference between CR LF, LF and CR line break types? - Stack Overflow](http://stackoverflow.com/questions/1552749/difference-between-cr-lf-lf-and-cr-line-break-types)
- [Newline - Wikipedia](https://en.wikipedia.org/wiki/Newline)
- [http HEAD vs GET performance - Stack Overflow](http://stackoverflow.com/questions/16539269/http-head-vs-get-performance)
- [HTTP 缓存 &nbsp;|&nbsp; Web &nbsp;|&nbsp; Google Developers](https://developers.google.com/web/fundamentals/performance/optimizing-content-efficiency/http-caching?hl=zh-cn)
- [http - How to control web page caching, across all browsers? - Stack Overflow](http://stackoverflow.com/questions/49547/how-to-control-web-page-caching-across-all-browsers/2068407#2068407)
- [The BalusC Code: Webapplication performance tips and tricks](http://balusc.omnifaces.org/2009/09/webapplication-performance-tips-and.html)
- [Yahoo前端优化十四条军规 - 51CTO.COM](http://developer.51cto.com/art/201207/347525_all.htm)
- [Best Practices for Speeding Up Your Web Site - Yahoo Developer Network](https://developer.yahoo.com/performance/rules.html)
- [HTTP | MDN](https://developer.mozilla.org/en-US/docs/Web/HTTP)
- [解決問題的第一步: Authentication vs. Authorization](http://2010end.blogspot.com/2010/12/authentication-vs-authorization.html)
- [Repositories | GitHub Developer Guide](https://developer.github.com/v3/repos/)
- [RESTful API 设计最佳实践 - 文章 - 伯乐在线](http://blog.jobbole.com/41233/)
- [Best Practices for Designing a Pragmatic RESTful API | Vinay Sahni](http://www.vinaysahni.com/best-practices-for-a-pragmatic-restful-api)
- [POST /eff/you/this/is/the/right/url - RESTful API Design](http://blog.cloud-elements.com/post-effyouthisistherighturl-restful-api-design)
- [418: I'm a teapot, and other bad API responses - RESTful API Design](http://blog.cloud-elements.com/418-im-a-teapot-and-other-bad-api-responses-restful-api-design)
- [Error Handling: RESTful API Design Part III](http://blog.cloud-elements.com/error-handling-restful-api-design-part-iii)
- [11.&nbsp;Aspect Oriented Programming with Spring](http://docs.spring.io/spring/docs/current/spring-framework-reference/html/aop.html)
- [Chapter&nbsp;6.&nbsp;&#20351;&#29992;Spring&#36827;&#34892;&#38754;&#21521;&#20999;&#38754;&#32534;&#31243;&#65288;AOP&#65289;](http://shouce.jb51.net/spring/aop.html)
- [AOP with Spring Framework](https://www.tutorialspoint.com/spring/aop_with_spring.htm)
- [StopWatch (Apache Commons Lang 3.4 API)](https://commons.apache.org/proper/commons-lang/javadocs/api-3.4/org/apache/commons/lang3/time/StopWatch.html)