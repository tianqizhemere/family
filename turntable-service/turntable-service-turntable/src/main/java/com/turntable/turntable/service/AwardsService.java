package com.turntable.turntable.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.turntable.turntable.entity.Awards;
import com.turntable.turntable.entity.Turntable;

import java.util.List;

/**
 * 转盘业务层接口
 * @Author:Wukh
 */
public interface AwardsService extends IService<Awards> {

    /**
     * 加载数据列表
     * @return
     */
    List<Awards> findList();

    /**
     * 根据转盘id查询子选择属性信息
     * @param turntableId 转盘名称id
     * @return
     */
    List<Awards> findByTurntableId(Long turntableId);

    /**
     * 添加子选择
     * @param awards
     * @return
     */
    Integer add(Awards awards);
}
