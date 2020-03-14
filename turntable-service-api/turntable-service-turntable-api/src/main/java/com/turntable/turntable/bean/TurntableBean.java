package com.turntable.turntable.bean;

/**
 * 转盘JavaBean
 * @Author:Wukh
 */

public class TurntableBean {
    /** id */
    private Long id;

    /** 选项标题 */
    private String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
