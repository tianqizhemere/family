package com.turntable.turntable.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.turntable.turntable.entity.Awards;
import com.turntable.turntable.entity.Turntable;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 子选项持久层接口
 * @Author:Wukh 
 */
public interface AwardsMapper extends BaseMapper<Awards> {

    /**
     * 查询所有信息
     * @return
     */
    @Select("select * from awards")
    List<Awards> selectAll();

    /**
     * 根据转盘id查询子选择信息
     * @param turntableId 转盘名称id
     * @return
     */
    List<Awards> findByTurntableId(Long turntableId);
}
