package com.turntable.turntable.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.turntable.turntable.entity.Ranking;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 排行榜持久层接口
 * @Author:Wukh 
 */
public interface RankingMapper extends BaseMapper<Ranking> {

    /**
     * 查询排行榜所有数据
     * @return
     */
    @Select("select t.title as 'option',count(*),r.title_id from ranking r\n" +
            "left join turntable t on r.title_id = t.id\n" +
            "group by title,r.title_id\n" +
            "order by count(*) desc")
    List<Ranking> findList();

    /**
     * 根据转盘id查询对应排行榜信息
     * @param id
     * @return
     */
    @Select("select count(*) count, r.awards_name from ranking r\n" +
            "left join turntable t on t.id = r.title_id\n" +
            "where r.title_id = #{id}\n" +
            "group by awards_name\n" +
            "order by count(*) desc")
    List<Map<String, Object>> findByTurntableId(@Param("id") Long id);

    /**
     * 获取今日抽取排行榜信息
     * @param today 参数
     * @return
     */
    @Select(" select t.title as 'option',count(*),r.title_id from ranking r\n" +
            " left join turntable t on t.id = r.title_id\n" +
            " where r.create_time like '${today} %'\n" +
            " group by title,r.title_id\n" +
            " order by count(*) desc")
    List<Ranking> findByToDay(@Param("today") String today);

    /**
     * 根据转盘id查询当天数据
     * @param titleId 转盘id
     * @param day 当前日期
     * @return
     */
    @Select("select count(*) count, r.awards_name from ranking r\n" +
            "left join turntable t on t.id = r.title_id\n" +
            "where r.title_id = #{titleId} and r.create_time like '${day} %'\n" +
            "group by awards_name\n" +
            "order by count(*) desc")
    List<Map<String, Object>> findByDay(@Param("titleId") Long titleId, @Param("day")String day);
}
