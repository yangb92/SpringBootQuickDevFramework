# Spring Boot 工程快速开发模板 :rocket:

快速开发一个响应Http请求的工程, 提供 RESTful API

## 功能介绍

**(1) 权限管理**

使用 Spring Security 权限管理框架经过适合于本项目的定制, 特点如下

* 所有交互采用json的方式
* 自动在参数列表注入登录用户对象

**(2) 数据库操作**

* mybatis 扩展 tk.mybatis
* PageHelper 分页
* generator 插件生成dao, entity, mapper.xml 文件

## API 接口

**(1) 登录**

`POST` /login

| 参数     | 说明        | 必填 |
| -------- | ----------- | ---- |
| username | 用户名 - yb | 是   |
| password | 密码 - 123  | 是   |

## 开发指南

**1) 结果视图包装 `ResultVo`**

> 相对于之前项目的 ObjectResultEx和 ResultEx 做了优化, 统一包装成 ResultVo , 结果和消息视图包装可以用同一个,  并且提供了静态方法, 不需要通过new来创建结果对象

```java
ResultVo.makeSuccess("删除成功");
ResultVo.makeSuccess("查询成功", new Object());
ResultVo.makeFailed("操作失败");
ResultVo.makeFailed(500, "服务内部错误");
```

**(2) 糊涂工具包(hutool)**

项目集成了国内开源的流行工具包`hutool`

> 官方介绍: Hutool是一个小而全的Java工具类库，通过静态方法封装，降低相关API的学习成本，提高工作效率，使Java拥有函数式语言般的优雅，让Java语言也可以“甜甜的”。

[使用文档](https://www.hutool.cn/docs)

**(3) 微信openid API**

```bash
# 开发 hosts 配置
127.0.0.1 zjnkkj.com

# 跳转code
https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxexxxxxxxxx&redirect_uri=http://zjnkkj.com&response_type=code&scope=snsapi_base&state=123&connect_redirect=1#wechat_redirect

# 获取openid
https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxe88656209c6cf6fb&secret=secret&code=001C7NR90fbxGz1G47
```

**(3) 获取登录用户对象**

Controller 中获取已登陆用户信息,在参数列表中添加`@CurrentUser AppUser user` 框架自动将当前登陆用户注入AppUser

```java
@RequestMapping("/admin")
public ResultVo admin(@CurrentUser AppUser user) {
    return ResultVo.makeSuccess(user);
}
```

**(4) 接口添加权限**

用户的权限定义在 `app_permission` 表

| id   | code       | description | url         |
| ---- | ---------- | ----------- | ----------- |
| 1    | ROLE_ADMIN | 管理员      | /admin/user |

在方法上使用 `@Secured("ROLE_ADMIN")` 注解标记方法的权限

```java
@RequestMapping("/order/admin")
@Secured("ROLE_ADMIN")
public ResultVo admin(@CurrentUser AppUser user){
    return ResultVo.makeSuccess(user);
}
```

**(5) tk.mybatis 使用**

```java
Example example = new Example(AppUser.class);
example.createCriteria().andEqualTo("username","lisi");
List<AppUser> appUsers = appUserMapper.selectByExample(example);
```

**(6) PageHelper 使用**

```java
PageHelper.startPage(1, 10); //设置分页
Example example = new Example(AppUser.class);
example.createCriteria().andEqualTo("username","lisi");
PageInfo<AppUser> pageInfo = new PageInfo<>(appUserMapper.selectByExample(example));

```

**(7) 使用generator生成代码**

`resource/generator/generatorConfig.xml`文件中配置自动生成entity,dao和mapper.xml

mapper.xml 生成在`resource/mapper/`目录.