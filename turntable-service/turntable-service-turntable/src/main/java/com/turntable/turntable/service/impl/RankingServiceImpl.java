package com.turntable.turntable.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.turntable.turntable.dao.RankingMapper;
import com.turntable.turntable.entity.Ranking;
import com.turntable.turntable.service.RankingService;
import entity.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 排行榜业务层实现
 * @author wukh
 */
@Service(value = "rankingServiceImpl")
@Transactional(rollbackFor = Exception.class)
public class RankingServiceImpl extends ServiceImpl<RankingMapper, Ranking> implements RankingService {

    @Autowired
    private RankingMapper rankingMapper;

    @Override
    public Integer add(Ranking ranking) {
        if (ranking != null && ranking.getTitleId() != null && ranking.getTitleId() != 0) {
            ranking.setCreateTime(new Date());
            ranking.setModifyTime(new Date());
            return rankingMapper.insert(ranking);
        }
        return 0;
    }

    @Override
    public List<Ranking> findList() {
        List<Ranking> list = rankingMapper.findList();
        if (list != null && list.size() != 0) {
            for (Ranking ranking : list) {
                List<Map<String, Object>> awards = findByTurntableId(ranking.getTitleId());
                ranking.setList(awards);
            }
        }
        return list;
    }

    @Override
    public List<Map<String, Object>> findByTurntableId(Long id) {
        List<Map<String, Object>> list = rankingMapper.findByTurntableId(id);
        return list;
    }

    @Override
    public List<Ranking> findByDay() {
        Date today = DateUtils.getToday();
        String day = new SimpleDateFormat("yyyy-MM-dd").format(today);
        List<Ranking> list = rankingMapper.findByToDay(day);
        if (list != null && list.size() != 0) {
            for (Ranking ranking : list) {
                List<Map<String, Object>> awards = rankingMapper.findByDay(ranking.getTitleId(), day);
                ranking.setList(awards);
            }
        }
        return list;
    }
}
