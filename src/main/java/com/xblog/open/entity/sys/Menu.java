package com.xblog.open.entity.sys;

import com.commons.validator.annotation.Max;
import com.commons.validator.annotation.Min;
import com.commons.validator.annotation.NotNull;
import lombok.Data;

import javax.persistence.*;

/**
 * 菜单
 */
@Entity
@Table
@Data
public class Menu {

    @Id
    @Column()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id; // id

    @Column
    private String title; // 菜单标题

    @Column
    private String desc; // 菜单描述

    @Column
    @Min(value = 0, message = "parentId不能小于0")
    private Integer parentId; // 父id

    @Column
    private long createTime; // 创建时间

    @Column
    @Min(1)
    @Max(3)
    private Integer role; // 菜单角色

    @Column
    @NotNull
    private String url; // 菜单路径
}
