package com.xblog.open.common.base;

import com.xblog.open.common.response.RespCode;
import com.xblog.open.model.RespEntity;

/**
 * desc:
 * author: xuebin3765@163.com
 * date: 2019/09/23
 */
public class BaseController extends BaseLogs {

    /**
     * 返回成功页面
     * @param view 页面地址
     * @return 页面地址
     */
    public String successView(String view){
        return view;
    }

    public String success(Object object){
        return RespEntity.success(object).toString();
    }

    public String success(){
        return RespEntity.success().toString();
    }

    public String success(Object object, String respCode, String respMsg){
        return RespEntity.success(object).toString();
    }

    public String error(){
        return RespEntity.error().toString();
    }



    public String error(String respMsg){
        return RespEntity.error(respMsg).toString();
    }

    protected String error(String respCode, String respMsg){
        return RespEntity.error(respCode, respMsg).toString();
    }

    public String errorView(String view){
        return view;
    }

    /**
     * 调转到登录页面
     * @param loginView 登录页面地址
     * @return 登录页面
     */
    public String login(String loginView){
        return loginView;
    }
}
