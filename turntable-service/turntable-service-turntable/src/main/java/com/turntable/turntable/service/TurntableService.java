package com.turntable.turntable.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.turntable.turntable.bean.TurntableBean;
import com.turntable.turntable.entity.Turntable;

import java.util.List;

/**
 * 转盘业务层接口
 * @Author:Wukh
 */
public interface TurntableService extends IService<Turntable> {

    /**
     * 加载数据列表
     * @return
     */
    List<Turntable> findList();

    /**
     * 加载树状图数据列表
     * @return
     */
    List<Turntable> findTreeList();

    /**
     * 添加转盘
     * @param turntable 转盘属性
     */
    void add(Turntable turntable);

    /**
     * 删除转盘
     * @param id 转盘主键id
     */
    void delete(Long id);

    /**
     * 修改转盘
     * @param turntableBean
     */
    void edit(TurntableBean turntableBean);
}
