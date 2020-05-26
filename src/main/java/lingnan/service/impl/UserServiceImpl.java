package lingnan.service.impl;

import lingnan.mapper.UserMapper;
import lingnan.pojo.User;
import lingnan.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    public List<User> getList() {
        return userMapper.getList();
    }




}
