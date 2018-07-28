import cn.gl.mapper.UserOrderMapper;
import cn.gl.pojo.UserOrder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserOrderMapperTest {

    SqlSessionFactory sqlSessionFactory = null;
    @Before
    public void init() throws IOException {
        String resources = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resources);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    }
    @Test
    public void getAllUsersOrdersTest(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserOrderMapper mapper = sqlSession.getMapper(UserOrderMapper.class);
        List<UserOrder> allUsersOrders = mapper.getAllUsersOrders();
        for (UserOrder uo : allUsersOrders){
            System.out.println(uo);
        }
    }
}
