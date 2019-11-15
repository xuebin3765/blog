package com.xblog.open.service.impl;

import com.xblog.open.common.base.BaseLogs;
import com.xblog.open.entity.sys.Menu;
import com.xblog.open.repository.sys.MenuRepository;
import com.xblog.open.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * desc: 菜单操作工具类
 * author: xuebin3765@163.com
 * date: 2019/11/15
 */
@Service
public class MenuServiceImpl extends BaseLogs implements MenuService {

    @Resource
    private MenuRepository menuRepository;

    /**
     * 新增菜单
     * @param menu 菜单对象
     * @return saved menu
     */
    @Override
    public Menu add(Menu menu) {
        if (null == menu)
            return null;
        menu.setCreateTime(System.currentTimeMillis());
        return menuRepository.save(menu);
    }

    /**
     * 查询相同标题或者url的菜单是否存在
     * @param title 菜单标题
     * @param url 菜单url
     * @return menu
     */
    @Override
    public Menu findByTitleOrUrl(String title, String url) {
        List<Menu> menuList = menuRepository.findAllByTitleOrUrlOrderByCreateTimeAsc(title, url);
        if (null != menuList && menuList.size() > 0){
            return menuList.get(0);
        }
        return null;
    }

    @Override
    public Menu findById(int id) {
        return menuRepository.findById(id).orElse(null);
    }
}
