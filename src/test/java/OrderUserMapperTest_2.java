import cn.gl.mapper.OrderUserMapper_2;
import cn.gl.pojo.OrderUser;
import cn.gl.pojo.OrderUser_2;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class OrderUserMapperTest_2 {

    SqlSessionFactory sqlSessionFactory = null;
    @Before
    public void init() throws IOException {
        String resources = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resources);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    }

    @Test
    public void getOrderUser_2(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderUserMapper_2 mapper = sqlSession.getMapper(OrderUserMapper_2.class);
        List<OrderUser_2> allOderUsers = mapper.getAllOrderUser_2();

        for (OrderUser_2 ou2 : allOderUsers){
            System.out.println(ou2);
        }
    }
}
