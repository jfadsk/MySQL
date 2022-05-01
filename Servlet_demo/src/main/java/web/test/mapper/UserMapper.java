package web.test.mapper;

import org.apache.ibatis.annotations.Param;
import web.test.pojo.User;

public interface UserMapper {
    /**
     * 根据用户名和密码查询登录对象
     * @param username
     * @param password
     * @return
     */
    User select(@Param("username")String username, @Param("password")String password);

    User selectByUserName(@Param("username")String username);

    void insert(User user);
}