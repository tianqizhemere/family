package com.turntable.turntable.controller;

import com.turntable.turntable.entity.Awards;
import com.turntable.turntable.service.AwardsService;
import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * 子选项controller
 * @Author:Wukh
 */
@RestController("awardsController")
@RequestMapping("/awards")
@CrossOrigin
public class AwardsController {

    @Resource(name = "awardsServiceImpl")
    private AwardsService awardsService;

    /**
     * 加载数据列表
     * @return 响应结果集
     */
    @GetMapping(value = "/list")
    public Result<List<Awards>> list(){
        List<Awards> list = awardsService.findList();
        return new Result<>(true, StatusCode.OK, "查询数据成功", list);
    }

    @GetMapping(value = "/findByTurntableId/{turntableId}")
    public Result<List<Awards>> findByTurntableId(@PathVariable(value = "turntableId") Long turntableId){
        List<Awards> list = awardsService.findByTurntableId(turntableId);
        return new Result<>(true, StatusCode.OK, "条件查询成功", list);
    }
}
