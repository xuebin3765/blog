package com.xblog.open.common.controller;

import com.xblog.open.common.response.ResponseBean;

/**
 * @author xuebin@si-tech.com.cn
 * @Description
 * @date 2019/08/03
 */
public class BaseController {
    public ResponseBean success(String respMsg, Object respData){
        return ResponseBean.success(respMsg, respData);
    }

    public ResponseBean success(Object respData){
        return ResponseBean.success(respData);
    }

    /**
     * 失败响应体结果
     * @param respCode 响应状态
     * @param respMsg 响应信息
     * @param respData 响应结果
     * @return ResponseBean
     */
    public static ResponseBean error(String respCode, String respMsg, Object respData){
        return ResponseBean.error(respCode, respMsg, respData);
    }

    /**
     * 失败响应体结果
     * @param respMsg 响应信息
     * @param respData 响应结果
     * @return ResponseBean
     */
    public static ResponseBean error(String respMsg, Object respData){
        return ResponseBean.error(respMsg, respData);
    }

    /**
     * 失败响应体结果
     * @param respMsg 响应信息
     * @return ResponseBean
     */
    public static ResponseBean error(String respMsg){
        return ResponseBean.error(respMsg, "");
    }
}
