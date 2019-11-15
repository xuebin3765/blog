package com.xblog.open.repository.sys;


import com.xblog.open.entity.sys.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色表
 * Created by lovebin on 2017/4/19.
 */
@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {
    List<Menu> findAllByTitleOrUrlOrderByCreateTimeAsc(String title, String url);
}
