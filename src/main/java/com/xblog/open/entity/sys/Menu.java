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
    private int id;
    @Column
    private String title;
    @Column
    private String desc;
    @Column
    private int parentId;
}
