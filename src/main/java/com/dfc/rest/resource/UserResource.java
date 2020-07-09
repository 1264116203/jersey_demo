package com.dfc.rest.resource;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Path("/users")
public class UserResource {
    /**
     * 存储用户
     **/
    private static Map<String, User> userMap = new HashMap<>();

    /**
     * 增加
     *
     * @param user
     */
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void createStudent(User user) {
        System.out.println("post");
        System.out.println();
        userMap.put(user.getUserId(), user);
    }

    /**
     * 删除
     *
     * @param id
     */
    @DELETE
    @Path("{id}")
    public void deleteStudent(@PathParam("id") String id) {
        System.out.println("delede");
        userMap.remove(id);
    }

    /**
     * 修改
     *
     * @param user
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void updateStudent(User user) {
        System.out.println("put");

        userMap.put(user.getUserId(), user);
    }


    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public User getUserById(@PathParam("id") String id) {
        User u = userMap.get(id);
        System.out.println("get");

        return u;
    }

    /**
     * 查询所有
     *
     * @return
     */
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        users.addAll(userMap.values());
        System.out.println("getAll");

        return users;
    }
    /**
     * 返回传入的数据
     *
     * @return
     */
    @GET
    @Path("/getUserJson")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserJson(@QueryParam("username") String username,
                            @QueryParam("userid") String userid,
                            @QueryParam("userage") String userage) {
        User user = new User();
        user.setUserId(userid);
        user.setUserAge(userage);
        user.setUserName(username);
        return user;
    }

}
