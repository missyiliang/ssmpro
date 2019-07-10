package mybaytis;


import com.cn.hnust.pojo.User;
import com.cn.hnust.service.IUserService;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;

/**
 * @author linsa
 * @date 2019-07-09 15:24
 **/
public class TestMyBatis {

    private static Logger logger = Logger.getLogger(TestMyBatis.class);
    private ApplicationContext ac = null;

    @Resource
    IUserService userService = null;

    @Before
    public void before() {
        ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        userService = (IUserService) ac.getBean("userService");
    }

    @Test
    public void testMybatis() {
        User user = userService.getUserById(1);
        logger.info(user.getUserName() + "," + user.getAge());
    }
}
