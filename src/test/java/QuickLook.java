import cn.gl.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class QuickLook {

    SqlSessionFactory ssf = null;
    InputStream is = null;
    @Before
    public void init() throws IOException {
        String resource = "mybatis-config.xml";
        is = Resources.getResourceAsStream(resource);
        ssf = new SqlSessionFactoryBuilder().build(is);
    }

    // 通过id查询用户
    @Test
    public void getUserById() throws IOException {

        SqlSession sqlSession = ssf.openSession();

//        User cn.gl.mapper = sqlSession.getMapper(User.class);


        User user = sqlSession.selectOne("cn.gl.pojo.selectUserById", 10);

        System.out.println(user);

        sqlSession.close();

    }

    @After
    public void destroy() throws IOException {
        is.close();
    }

    // 根据用户名称模糊查询用户
    @Test
    public void getUserByUsername(){
        SqlSession sqlSession = ssf.openSession();

        List<User> users = sqlSession.selectList("cn.gl.pojo.selectUserByUsername", "小");
        System.out.println(users);

        sqlSession.close();
    }

    // 添加用户
    @Test
    public void insertUser(){
        SqlSession sqlSession = ssf.openSession();

        User user = new User();
        user.setUsername("pony");
        user.setSex('1');
        user.setBirthday(new Date());
        user.setAddress("京华大道");
        int insert = sqlSession.insert("cn.gl.pojo.insertUser", user);
        System.out.println(insert);

        sqlSession.commit();
        sqlSession.close();

        System.out.println(user.getId());  // 值Null
    }

    // 添加用户，获取刚添加用户的id
    @Test
    public void insertUserAndGetUserId(){
        SqlSession sqlSession = ssf.openSession();

        User user = new User();
        user.setUsername("jack");
        user.setSex('1');
        user.setBirthday(new Date());
        user.setAddress("杭州大道");
        int insert = sqlSession.insert("cn.gl.pojo.insertUserAndGetUserId", user);
        System.out.println(insert);

        sqlSession.commit();
        sqlSession.close();
        System.out.println("user id: " + user.getId());
    }

    // 更新用户信息
    @Test
    public void updateUser(){
        SqlSession sqlSession = ssf.openSession();

        User user = new User();
        user.setId(31);
        user.setUsername("jack");
        user.setSex('1');
        user.setBirthday(new Date());
        user.setAddress("浦发大道");

        sqlSession.update("cn.gl.pojo.updateUser", user);
        sqlSession.commit();

    }

    // 删除用户
    @Test
    public void deleteUser(){
        SqlSession sqlSession = ssf.openSession();
        sqlSession.delete("cn.gl.pojo.deleteUser", 28);
        sqlSession.commit();
    }
}
