package com.xblog.open.controller.admin;

import com.commons.validator.ValidResult;
import com.commons.validator.ValidatorFactory;
import com.xblog.open.common.base.BaseController;
import com.xblog.open.common.response.MenuRespCode;
import com.xblog.open.common.response.RespCode;
import com.xblog.open.common.utils.JsonUtil;
import com.xblog.open.entity.sys.Menu;
import com.xblog.open.service.MenuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/menu")
public class MenuController extends BaseController {

    @Resource
    private MenuService menuService;

    @PostMapping("/add")
    public ModelAndView add(@RequestBody Menu menu){

        debug("step into add(), menu: {}", JsonUtil.toStringNoRelation(menu));

        String successView = "/admin/menu/list", errorView = "/admin/menu/addMenu";
        String respCode = RespCode.error;

        ValidResult validResult = ValidatorFactory.validBean(menu);
        if (!validResult.isHasErrors()){

            Menu oldMenu = menuService.findByTitleOrUrl(menu.getTitle(), menu.getUrl());

            if (null != oldMenu){
                debug("menu exist, title: {}, url: {}", oldMenu.getTitle(), menu.getUrl());
                return errorView(errorView, MenuRespCode.MENU_TITLE_OR_URL_REPEAT, oldMenu);
            }

            menu = menuService.add(menu);

            if (null != menu){
                debug(" return success, view: {}", successView);
                return successView(successView, menu);
            }
            respCode = MenuRespCode.MENU_ADD_ERROR;
        }
        debug(" return error, view: {}", errorView);
        return errorView(successView, respCode, validResult.getErrorMsgs());
    }

    /**
     * 修改
     * @param menu 菜单数据
     * @return update
     */
    @PostMapping("/update")
    public ModelAndView update(@RequestBody Menu menu){

        debug("step into update(), menu: {}", JsonUtil.toStringNoRelation(menu));

        String successView = "/admin/menu/list", errorView = "/admin/menu/updateMenu";
        String respCode = RespCode.error;

        if (menu != null){
            Menu oldMenu = menuService.findById(menu.getId());
            if (oldMenu != null){
                if (StringUtils.isNotBlank(menu.getTitle()) || StringUtils.isNotBlank(menu.getUrl())){
                    // 要修改标题和url
                    Menu oldMenuByTitleOrUrl = menuService.findByTitleOrUrl(menu.getTitle(), menu.getUrl());
                    if (null != oldMenuByTitleOrUrl){
                        debug("menu exist, title: {}, url: {}", oldMenu.getTitle(), menu.getUrl());
                        return errorView(errorView, MenuRespCode.MENU_TITLE_OR_URL_REPEAT, oldMenu);
                    }
                    // 设置标题
                    if (StringUtils.isNotBlank(menu.getTitle())){
                        oldMenu.setTitle(menu.getTitle());
                    }
                    // 设置url
                    if (StringUtils.isNotBlank(menu.getUrl())){
                        oldMenu.setUrl(menu.getUrl());
                    }
                }

                // 设置父目录
                if (null != menu.getParentId()){
                    oldMenu.setParentId(menu.getParentId());
                }
                // 设置权限
                if (null != menu.getRole()){
                    oldMenu.setRole(menu.getRole());
                }
                // 设置描述信息
                if (StringUtils.isNotBlank(menu.getDesc())){
                    oldMenu.setDesc(menu.getDesc());
                }
                menu = menuService.add(menu);
                debug(" return success, view: {}", successView);
                return successView(successView, menu);
            }
            respCode = MenuRespCode.MENU_NOT_EXIST;
        }
        debug(" return error, view: {}", errorView);
        return errorView(successView, respCode);
    }

}
