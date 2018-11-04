# sshweb
ssh框架整合练习  
  
`Spring`+`SpringMVC`+`Hibernate`(+`jQuery`)  
  
2018年6月

`Spring` 整合 `Hibernate` 整合什么？  
>①由 `IOC `容器来管理` Hibernate `的 `SessionFatctory  `  
②让 `Hibernate` 使用上 `Spring `的声明式事务  
>>`Hibernate`在和`Spring`整合时，大量的配置信息不会出现在自己`的hibernate.cfg.xml`配置文件中，而是会转移到`Spring`的`applicationContext.xml`配置文件，例如`连接数据库`的`基本信息`、`数据源`、`Hibernate`本身的`SessionFcatory`(通过 `Spring `提供的 `LocalSessionFactoryBean `进行配置，可以指定`Hibernate配置文件`的位置，以及`映射文件`的位置)等。`Hibernate`本身的`hibernate.cfg.xml`配置文件建议`保留`，并且在其中配置 `Hibernate` 的`基本属性`：`方言`，`SQL 显示及格式化`，`生成数据表的策略`以及`二级缓存`等。这样做修改的时候回更容易一些，就好像我们把`数据库连接的基本数据`单独放在`jdbc.properties`文件中一样。

配置与` Spring `与 `SpringMVC `的时候需要注意什么？  
>扫描部分不能重合  
>>与`Spring`一样，`SpringMVC`也有自己的一个`IOC`容器，`Spring` 的 `IOC `容器和`SpringMVC` 的 `IOC` 容器扫描的包如果有重合的部分，就会导致有 `Bean` 被创建`2`次。其中`SpringMVC`的`IOC`容器类似于`Spring`的`IOC`容器的`子集`， `SpringMVC`的`IOC` 容器中的 `Bean `可以引用 `Spring的IOC` 容器中的 `Bean`,反之则不行，于是我们不能将所有的`Bean`都交给`SpringMVC`扫描。通过之前对`SpringMVC`的学习以及理解，得知在它的工作过程中，`HandlerMapping`过程之后需要找到对应的`Controller`，于是`Controller`应该是需要由`SpringMVC`扫描，其他的可以交给`Spirng`去扫描。要实现这一点，我们只需要在`SpringMVC`配置文件`spingmvc.xml`的`component-scan`标签中添加`include-filter`，将`use-default-filters`属性置为`false`(关闭默认的扫描规则)，再指定需要扫描的`注解类型`即可。同样的，我们也需要在`Spring`的配置文件`applicationContext.xml`的`component-scan`标签中添加`exclude-filter`，再指定需要`排除`扫描的`注解类型`即可。  
其余本分变化不大，`Spring`的配置文件`applicationContext.xml`中依然需要配置`事务管理器`，`SpringMVC`的配置文件`spingmvc.xml`中需要配置`视图解析器`，也可以配置`拦截器`、`数据类型转换器`、`国际化`等。  
`jQuery`是`JavaScript`的一个库，可以让`JS`的代码变得更加简洁，实现了`write less do more`。想要使用`jQuery`只需要复制`jquery-3.3.1.min.js`文件到项目中，并在`JSP`文件中的`head`标签中使用`script`标签引入即可。
