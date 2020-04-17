# Spring Boot 分布式框架 

加入了Spring Security + Redis会话共享.适合分布式部署.

文档: <http://book.yangb.xyz/program/SpringSecurity/ContextRepository.html>

## 框架介绍

|模块名称|描述|
|--- | --- |
|Spring Security|权限框架,使用restful,适合前后分离的项目|
|tk.mybatis|使用tk.mybatis框架,简化数据库操作。|
|PageHelper|分页插件|
|generator|自动生成Entity,Mapper和Dao|

### Spring Security

提供restful接口

登陆: `post localhost:8080/login`
```json
// 登陆成功
{
    "message": "登陆成功",
    "status": 200,
    "success": true
}
//登陆失败
{
    "message": "密码错误",
    "status": 500,
    "success": false
}
```

退出: `GET localhost:8080/logout`
```json
{
    "message": "退出成功",
    "status": 200,
    "success": false
}

```


Controller 中获取已登陆用户信息,在参数列表中添加`@CurrentUser AppUser user` 框架自动将当前登陆用户注入AppUser
```java
@RequestMapping("/admin")
public ResultVo admin(@CurrentUser AppUser user) {
    return ResultVo.makeSuccess(user);
}
```

为方法添加授权,例: 只有`ROLE_ADMIN`资源的能够调用此方法
```java
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public ResultVo admin(@CurrentUser AppUser user) {
    return ResultVo.makeSuccess(user);
}
```

### tk.mybatis
```java
Example example = new Example(AppUser.class);
example.createCriteria().andEqualTo("username","lisi");
List<AppUser> appUsers = appUserMapper.selectByExample(example);
```

### PageHelper
```java
PageHelper.startPage(1, 10);
Example example = new Example(AppUser.class);
example.createCriteria().andEqualTo("username","lisi");
PageInfo<AppUser> pageInfo = new PageInfo<>(appUserMapper.selectByExample(example));

```

### generator

`resource/generator/generatorConfig.xml`文件中配置自动生成实体,Dao和mapper.xml

mapper.xml 生成在`resource/mapper/`目录

### 统一结果类型

接口返回请使用ResultVo包装: `com.yangb.project.quickdev.common.ResultVo` 

