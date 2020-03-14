package com.turntable.turntable.controller;

import com.turntable.turntable.entity.Turntable;
import com.turntable.turntable.service.TurntableService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * turntableController
 * @Author:Wukh
 * @Date 2020/2/22
 */
@RestController("turntableController")
@RequestMapping("/turntable")
@CrossOrigin
public class TurntableController {

    @Autowired
    private TurntableService turntableService;


    /**
     * 加载数据列表
     * @return
     */
    @GetMapping(value = "/list")
    public Result<Turntable> list() {
        List<Turntable> list = turntableService.findList();
        return new Result<>(true, StatusCode.OK, "查询数据成功", list);
    }

    /**
     * 加载树状图数据列表
     * @return
     */
    @GetMapping(value = "/treeList")
    public  Result<Turntable> treeList() {
        List<Turntable> list = turntableService.findTreeList();
        return new Result<>(true, StatusCode.OK, "获取树状图数据成功", list);
    }

    /**
     * 添加转盘
     * @param turntable 添加属性
     * @return
     */
    @PostMapping(value = "/add")
    public Result addTurntable(@RequestBody Turntable turntable) {
        turntableService.add(turntable);
        return new Result<>(true, StatusCode.OK, "添加数据成功");
    }


    /**
     * 删除转盘
     * @param id 转盘主键id
     * @return
     */
    @PostMapping(value = "/delete")
    public Result delete(@RequestParam("id") Long id){
        turntableService.delete(id);
        return new Result<>(true, StatusCode.OK, "数据删除成功");
    }
}
