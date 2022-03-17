import com.tledu.mybatis.mybatis.dao.IAddressMapper;
import com.tledu.mybatis.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class AddUser {
    private SqlSession session;
    @Before
    public void before() throws IOException {
        String resource = "mybatis-config.xml";
        // 读取总配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 获取session工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取session
        session = sqlSessionFactory.openSession();
    }
    //    动态查询
    @Test
    public void selectTest(){
        User use = new User();
        use.setUsername("龙");
        use.setNickname("小龙");
        List<User> user = session.getMapper(IAddressMapper.class).selectTest(use);
        System.out.println(user.size());
    }
    //    动态更新
    @Test
    public void updateTest(){
        User use=new User();
        use.setId(8);
        use.setUsername("LO");
        use.setNickname("LONG");
        int i = session.getMapper(IAddressMapper.class).updateTest(use);
        System.out.println("影响了"+i+"条");
    }
    //    模糊查询
    @Test
    public void selectUserLike(){
        List<User> user=session.getMapper(IAddressMapper.class).selectUserLike("龙");
        System.out.println(user.size());
    }
    //    动态增加
    @Test
    public void insertBatch(){
        List<User> userList=new ArrayList<>();
        User user1=new User("小龙龙","123456789","小龙龙龙");
        User user2=new User("小龙龙","1234eqw5","小龙龙龙");
        User user3=new User("小龙龙","127963456","小龙龙龙");
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        int i = session.getMapper(IAddressMapper.class).insertBatch(userList);
        System.out.println("影响了"+i+"条");
    }
    @After
    public void after(){
// 提交
        session.commit();
    }
}
