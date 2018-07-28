import cn.gl.mapper.UserMapper;
import cn.gl.pojo.QueryVo;
import cn.gl.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class UserMapperTest {

    SqlSessionFactory sqlSessionFactory = null;
    @Before
    public void init() throws IOException {
        String resources = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resources);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    }

    @Test
    public void getUserById(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectUserById(10);
        System.out.println(user);
    }

    // 测试包装类型
    @Test
    public void getUserByUsername(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        QueryVo qv = new QueryVo();
        qv.setUser(new User());
        qv.getUser().setUsername("张");

        List<User> users = mapper.selectUserByUsername(qv);
        System.out.println(users);
    }

    // 查询用户条数
    @Test
    public void getUserSum(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Integer sum = mapper.countUser();
        System.out.println(sum);
    }

    // 根据性别和名字模糊查询
    @Test
    public void getUserBySexAndUsername(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
//        user.setSex('1');
//        user.setUsername("张");

        List<User> users = mapper.getUserBySexAndUsername(user);
        for (User u : users) {
            System.out.println(u);
        }

        // 改造之前： 当注释了 user.setSex('1') 或 user.setUsername("张") 其中之一，查询结果为0，不符合要求.
    }

    @Test
    public void getUsersByIds(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        QueryVo vo = new QueryVo();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(24);
        ids.add(31);
        vo.setIds(ids);

        List<User> users = mapper.getUsersByIds(vo);
        for (User user: users) {
            System.out.println(user);
        }

    }


}
