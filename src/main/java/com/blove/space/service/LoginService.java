package com.blove.space.service;

import com.blove.space.mapper.SpaceUserMapper;
import com.blove.space.model.SpaceUser;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public class LoginService {

    @Autowired
    SpaceUserMapper spaceUserMapper;

    public void slect(){
        // 创建Example
        Example example = new Example(SpaceUser.class);
        // 创建Criteria
        Example.Criteria criteria = example.createCriteria();
        // 添加条件
        criteria.andEqualTo("isDelete", 0);
        criteria.andLike("name", "%abc123%");
        List<SpaceUser> list = spaceUserMapper.selectByExample(example);
    }

}
