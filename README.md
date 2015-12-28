## JFinal-jade4j
JFinal的jade模板插件

## 使用
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
```

## 交流群
如梦技术：[`237587118`](http://shang.qq.com/wpa/qunwpa?idkey=f78fcb750b4f72c92ff4d375d2884dd69b552301a1f2681af956bd32700eb2c0)

## License

( The MIT License )
