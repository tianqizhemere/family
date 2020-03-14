package com.turntable.turntable.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.turntable.turntable.entity.TurntableAwards;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 中间关联表持久层
 */
public interface TurntableAwardsMapper extends BaseMapper<TurntableAwards> {

    /**
     * 根据转盘id查找中间表信息
     * @param id 转盘id
     * @return
     */
    @Select("select * from turntable_awards where turntable_id = #{id}")
    List<TurntableAwards> findByTurntableId(@Param("id") Long id);
}
