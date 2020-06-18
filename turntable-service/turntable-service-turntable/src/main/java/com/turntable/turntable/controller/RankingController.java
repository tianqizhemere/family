package com.turntable.turntable.controller;

import com.turntable.turntable.bean.RankingBean;
import com.turntable.turntable.entity.Ranking;
import com.turntable.turntable.service.RankingService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * 排行榜controller
 * @Author:Wukh
 */
@RestController("rankingController")
@RequestMapping("/ranking")
@CrossOrigin
public class RankingController {

    @Autowired
    private RankingService rankingService;

    /**
     * 加载数据列表
     * @return
     */
    @GetMapping(value = "/list")
    public Result<List<Ranking>> list(){
        List<Ranking> list = rankingService.findList();
        return new Result<>(true, StatusCode.OK, "查询排行榜数据成功", list);
    }

    @PostMapping(value = "/findByTurntableId")
    public Result<List<Map<String, Object>>> findByTurntableId(@RequestParam("id") Long id){
        List<Map<String, Object>> list = rankingService.findByTurntableId(id);
        return new Result<>(true, StatusCode.OK, "条件查询成功", list);
    }

    /**
     * 新增排行榜
     * @param rankingBean 排行榜信息
     * @return
     */
    @PostMapping(value = "/add")
    public Result add(@RequestBody RankingBean rankingBean){
        rankingService.add(rankingBean);
        return new Result<>(true, StatusCode.OK, "数据插入成功");
    }


    /**
     * 查询每天抽取的排行榜信息
     * @return
     */
    @GetMapping(value = "/day")
    public Result<List<Ranking>> findByDay() {
        List<Ranking> list = rankingService.findByDay();
        return new Result<>(true, StatusCode.OK, "条件查询成功", list);
    }
}
