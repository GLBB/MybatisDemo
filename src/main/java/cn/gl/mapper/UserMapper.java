package cn.gl.mapper;

import cn.gl.pojo.QueryVo;
import cn.gl.pojo.User;

import java.util.List;

public interface UserMapper {
    User selectUserById(Integer id);

    List<User> selectUserByUsername(QueryVo vo);

    Integer countUser();

    List<User> getUserBySexAndUsername(User user);

    List<User> getUsersByIds(QueryVo vo);
}
