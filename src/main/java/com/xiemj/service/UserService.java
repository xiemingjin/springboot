package com.xiemj.service;

import com.xiemj.dao.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private UserService service;


    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public  void  add()
    {
        Map<String ,Object> user=new HashMap<>();
        user.put("uid",1005);
        user.put("username","小明de");
        user.put("password","111ssss");
        userDao.saveUser(user);
        throw  new RuntimeException(
                "ssss"
        );

    }



@Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public  void  update()
    {
        Map<String ,Object> user=new HashMap<>();
        user.put("uid",1006);
        user.put("username","dede");
        user.put("password","111111ssss");
        userDao.saveUser(user);
    }


    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public  void  update1()
    {
        Map<String ,Object> user=new HashMap<>();
        user.put("uid",11111);
        user.put("username","222");
        user.put("password","22");
        userDao.saveUser(user);
    }


    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = RuntimeException.class)
    public void test() throws RuntimeException
    {
        service.update();
        throw new RuntimeException("sss");
    }
}
