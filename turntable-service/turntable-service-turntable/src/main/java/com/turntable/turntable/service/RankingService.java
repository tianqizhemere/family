package com.turntable.turntable.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.turntable.turntable.entity.Ranking;

import java.util.List;
import java.util.Map;

/**
 * 排行榜业务层接口
 * @Author:Wukh
 */
public interface RankingService extends IService<Ranking> {


    /**
     * 新增排行榜
     * @param ranking
     * @return
     */
    Integer add(Ranking ranking);

    /**
     * 查询排行榜所有数据
     * @return
     */
    List<Ranking> findList();

    /**
     * 根据转盘id查询子选项次数及名称
     * @param id 转盘id
     * @return
     */
    List<Map<String, Object>> findByTurntableId(Long id);

    /**
     * 查询每日抽取的排行榜信息
     * @return
     */
    List<Ranking> findByDay();
}
