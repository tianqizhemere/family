package com.turntable.turntable.controller;

import com.turntable.turntable.entity.Awards;
import com.turntable.turntable.service.AwardsService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @Author:Wukh
 */
@RestController("awardsController")
@RequestMapping("/awards")
@CrossOrigin
public class AwardsController {

    @Autowired
    private AwardsService awardsService;

    /**
     * 加载数据列表
     * @return
     */
    @GetMapping(value = "/list")
    public Result<List<Awards>> list(){
        List<Awards> list = awardsService.findList();
        return new Result<>(true, StatusCode.OK, "查询数据成功", list);
    }

    @GetMapping(value = "/findByTurntableId/{turntableId}")
    public Result<List<Awards>> findByTurntableId(Long turntableId){
        List<Awards> list = awardsService.findByTurntableId(turntableId);
        return new Result<>(true, StatusCode.OK, "条件查询成功", list);
    }
}
