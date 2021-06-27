# test-springboot-vue-session

## 项目简介

用这个小项目搞清楚springboot中到底怎样维护session。



## 数据库

数据库中只有一个用户表：

```sql
create table user(
	id int primary key not null auto_increment,
    username varchar(30) not null,
    password varchar(30) not null
);
```



## 项目逻辑

前端login页面的表单来登录，登录后后端设置session，前端请求获得当前用户的用户名，应该能获得。登出之后再次用第二个账户登录，应该显示第二个用户的用户名。



前端总共两个页面：login和logout



使用nginx反向代理解决了跨域问题。



nginx.conf:

```nginx
http {
    include       mime.types;
    default_type  application/octet-stream;
    sendfile        on;
    keepalive_timeout  65;
    server{
        listen 1234;
        location /api{
            proxy_pass http://localhost:50000/api;
        }
        location /{
            proxy_pass http://localhost:8080;
        }
    }

}

```

