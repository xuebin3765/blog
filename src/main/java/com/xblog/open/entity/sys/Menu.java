package com.xblog.open.entity.sys;

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
    private int parentId; // 父id
    @Column
    private long createTime; // 创建时间
    @Column
    private long role; // 菜单角色
}
