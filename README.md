## JFinal-jade4j
JFinal的jade模板插件

## 使用
### maven引入
```xml
<dependency>
    <groupId>net.dreamlu</groupId>
    <artifactId>JFinal-jade4j</artifactId>
    <version>0.0.2</version>
</dependency>
```

### JFinal中配置
```java
me.setMainRenderFactory(new JadeRenderFactory());
// cache默认为true:缓存模板提高性能，JFinal的开发模式下为默认false
JadeRenderFactory.config.setCaching(true);
// 其他更多配置可同上
```

### 模板使用
Jade官网：http://jade-lang.com/

jade4j：https://github.com/neuland/jade4j

```java
//session的获取
#{session.xxxxx}
//自带contextPath，0.0.2添加
#{ctxPath}
```

## 说明
> 0.0.2添加request parameters，默认将请求参数带入模板中，同名会被request.setAttribute覆盖

> 0.0.2传递request and response到模板中

> 0.0.2添加ctxPath

## 交流群
如梦技术：[`237587118`](http://shang.qq.com/wpa/qunwpa?idkey=f78fcb750b4f72c92ff4d375d2884dd69b552301a1f2681af956bd32700eb2c0)

## License

( The MIT License )
