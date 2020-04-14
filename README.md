# Spring Boot 单体应用快速开发框架

## 框架介绍

|模块名称|描述|
|--- | --- |
|Spring Security|权限框架,使用restful,适合前后分离的项目|
|tk.mybatis|使用tk.mybatis框架,方便查询|
|PageHelper|分页插件|
|generator|自动生成Entity,Mapper和Dao|

### Spring Security

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

