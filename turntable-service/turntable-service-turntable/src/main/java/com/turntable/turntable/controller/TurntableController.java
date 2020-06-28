package com.turntable.turntable.controller;

import com.turntable.turntable.bean.TurntableBean;
import com.turntable.turntable.entity.Turntable;
import com.turntable.turntable.service.TurntableService;
import utils.Result;
import utils.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * turntableController
 * @Author:Wukh
 * @Date 2020/2/22
 */
@RestController("turntableController")
@RequestMapping("/turntable")
@CrossOrigin
@Api(value = "转盘类控制器", tags = "用户类控制器")
public class TurntableController {

    @Resource(name = "turntableServiceImpl")
    private TurntableService turntableService;


    /**
     * 加载数据列表
     * @return 响应结果集
     */
    @GetMapping(value = "/list")
    @ApiOperation(value = "获取所有转盘列表", notes = "获取所有转盘列表")
    public Result<List<Turntable>> list() {
        List<Turntable> list = turntableService.findList();
        return new Result<>(true, StatusCode.OK, "查询数据成功", list);
    }

    /**
     * 加载树状图数据列表
     * @return 响应结果集
     */
    @GetMapping(value = "/treeList")
    @ApiOperation(value = "获取树状图数据列表", notes = "获取树状图数据列表")
    public  Result<List<Turntable>> treeList() {
        List<Turntable> list = turntableService.findTreeList();
        return new Result<>(true, StatusCode.OK, "获取树状图数据成功", list);
    }

    /**
     * 添加转盘
     * @param turntable 添加属性
     * @return 响应结果集
     */
    @PostMapping(value = "/add")
    @ApiOperation(value = "添加转盘", notes = "添加转盘")
    public Result<Object> addTurntable(@RequestBody Turntable turntable) {
        turntableService.add(turntable);
        return new Result<>(true, StatusCode.OK, "添加数据成功");
    }


    /**
     * 物理删除转盘
     * @param id 转盘主键id
     * @return 响应结果集
     */
    @PostMapping(value = "/delete")
    @ApiOperation(value = "物理删除转盘信息", notes = "物理删除转盘信息")
    @ApiParam(name = "id", value = "转盘id", required = true)
    public Result<Object> delete(@RequestParam("id") Long id){
        turntableService.delete(id);
        return new Result<>(true, StatusCode.OK, "物理删除数据成功");
    }

    /**
     * 逻辑删除
     * @param id 转盘id
     * @return 响应结果集
     */
    @PostMapping(value = "/logicDelete")
    @ApiOperation(value = "逻辑删除转盘信息", notes = "逻辑删除转盘信息")
    @ApiParam(name = "id", value = "转盘id", required = true)
    public Result<Object> logicDelete(@RequestParam("id") Long id){
        turntableService.logicDelete(id);
        return new Result<>(true, StatusCode.OK, "删除数据成功");
    }

    /**
     * 修改转盘
     * @param turntableBean 转盘Javabean
     * @return 响应结果集
     */
    @PostMapping(value = "/edit")
    public Result<Object> edit(@RequestBody TurntableBean turntableBean) {
        turntableService.edit(turntableBean);
        return new Result<>(true, StatusCode.OK, "修改数据成功");
    }
}
