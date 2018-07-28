package cn.gl.mapper;

import cn.gl.pojo.OrderUser;

import java.util.List;

// 为了 一对一 映射
public interface OrderUserMapper {
    List<OrderUser> getAllOrderUser();
}
