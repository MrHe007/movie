## 1. 电影系统

- 页面:
    - 首页：localhost
    - druid首页：http://localhost/druid/index.html
    - 后台首页：localhost:/admin

- 缺点：
    - 系统没有做成微服务式， 前台后台耦合，都是在同一个系统中
    - Service 没有接口，都是直接的 Service 类

- 改进：
    - 用dubbo做成微服务
    - 将公共的接口文件，通用类抽取出来作为子模块，供其他模块引用    

- 配置文件:
    - application.properties: 全局配置
    - application.yml：druid 的配置

- 所用技术：

- SpringBoot
- dao : Mybatis
- 数据库连接池：druid
    - username: admin
    - password: admin
- 缓存: redis
    - 位置： linux 中
    - 作用：存放访问豆瓣连接传回的 json串
- 数据库：Mysql

    - 本地的数据库
- 前端:
    - 模板引擎：Themeleaf
    - 前端框架：Layui

## 2. 项目截图

### 1. 主页

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190623093618722.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2hpX2JpZ2d1eQ==,size_16,color_FFFFFF,t_70)



### 2. 电影列表

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190623093633780.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2hpX2JpZ2d1eQ==,size_16,color_FFFFFF,t_70)

### 3. 电影详情页面

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190623093646895.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2hpX2JpZ2d1eQ==,size_16,color_FFFFFF,t_70)

### 4. 登入后主页

![在这里插入图片描述](https://img-blog.csdnimg.cn/2019062309370072.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2hpX2JpZ2d1eQ==,size_16,color_FFFFFF,t_70)

### 5.用户详情

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190623093713261.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2hpX2JpZ2d1eQ==,size_16,color_FFFFFF,t_70)

### 6. 腾讯影院

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190623093727245.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2hpX2JpZ2d1eQ==,size_16,color_FFFFFF,t_70)

### 7. 新闻列表

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190623093753730.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2hpX2JpZ2d1eQ==,size_16,color_FFFFFF,t_70)

### 8. 新闻详情

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190623093806169.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2hpX2JpZ2d1eQ==,size_16,color_FFFFFF,t_70)

### 9. top150

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190623093818800.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2hpX2JpZ2d1eQ==,size_16,color_FFFFFF,t_70)



### 10. 增加新闻

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190623093830421.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2hpX2JpZ2d1eQ==,size_16,color_FFFFFF,t_70)

### 11. 评论管理

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190623093838998.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2hpX2JpZ2d1eQ==,size_16,color_FFFFFF,t_70)

### 12. 用户管理

![在这里插入图片描述](https://img-blog.csdnimg.cn/2019062309385058.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2hpX2JpZ2d1eQ==,size_16,color_FFFFFF,t_70)



















