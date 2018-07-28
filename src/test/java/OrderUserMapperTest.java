import cn.gl.mapper.OrderUserMapper;
import cn.gl.pojo.OrderUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class OrderUserMapperTest {
    SqlSessionFactory sqlSessionFactory = null;
    @Before
    public void init() throws IOException {
        String resources = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resources);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    }
    @Test
    public void getAllOrderUser(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderUserMapper mapper = sqlSession.getMapper(OrderUserMapper.class);
        List<OrderUser> allOrderUser = mapper.getAllOrderUser();

        for (OrderUser ou : allOrderUser){
            System.out.println(ou);
        }

    }

}
