package com.turntable.turntable.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.turntable.turntable.dao.AwardsMapper;
import com.turntable.turntable.entity.Awards;
import com.turntable.turntable.service.AwardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 子选项服务层实现
 * @author wukh
 */
@Service(value = "awardsServiceImpl")
@Transactional(rollbackFor = Exception.class)
public class AwardsServiceImpl extends ServiceImpl<AwardsMapper, Awards> implements AwardsService {

    @Autowired
    private AwardsMapper awardsMapper;

    @Override
    public List<Awards> findList() {
        return awardsMapper.selectAll();
    }

    @Override
    public List<Awards> findByTurntableId(Long turntableId) {
        return awardsMapper.findByTurntableId(turntableId);
    }

    @Override
    public Integer add(Awards awards) {
        return null;
    }
}
