package net.qiujuer.web.italker.push.service;

import net.qiujuer.web.italker.push.bean.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * @Author shiqiang
 **/
// 访问路径为:127.0.0.1/api/account/... ...
@Path("/account")
public class AccountService {

    // GET请求的路径为: 127.0.0.1/api/account/login
    @GET
    @Path("/login")
    public String get() {
        return "You get the login.";
    }

    // POST请求的路径为: 127.0.0.1/api/account/login
    @POST
    @Path("/login")
    // 指定请求与返回的相应体为Json
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User post() {
        User user = new User();
        user.setName("可爱的小美女");
        user.setSex(2);
        return user;
    }

}
