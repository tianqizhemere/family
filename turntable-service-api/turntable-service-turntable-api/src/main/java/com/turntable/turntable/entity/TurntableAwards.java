package com.turntable.turntable.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

/**
 * 转盘与子选择关联关系
 * @Author:Wukh
 */
@TableName(value = "turntable_awards")
public class TurntableAwards {

    @TableId(type = IdType.AUTO)
    private Long id;
    private Date createTime;
    private Date modifyTime;
    private Long turntableId;
    private Long awardsId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Long getTurntableId() {
        return turntableId;
    }

    public void setTurntableId(Long turntableId) {
        this.turntableId = turntableId;
    }

    public Long getAwardsId() {
        return awardsId;
    }

    public void setAwardsId(Long awardsId) {
        this.awardsId = awardsId;
    }
}
