package com.xblog.open.service.impl;

import com.xblog.open.common.base.BaseLogs;
import com.xblog.open.dto.menu.MenuAddDTO;
import com.xblog.open.entity.sys.Menu;
import com.xblog.open.service.MenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.persistence.Converter;

/**
 * desc: 菜单操作工具类
 * author: xuebin3765@163.com
 * date: 2019/11/15
 */
@Service
public class MenuServiceImpl extends BaseLogs implements MenuService {


    @Override
    public Menu add(MenuAddDTO menuAddDTO) {
        Menu menu = new Menu();
        BeanUtils.copyProperties(menuAddDTO, menu);


        return null;
    }
}
