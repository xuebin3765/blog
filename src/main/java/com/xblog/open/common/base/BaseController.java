package com.xblog.open.common.base;

import com.commons.validator.ErrorMsg;
import com.google.common.collect.Maps;
import com.xblog.open.common.response.RespCode;
import com.xblog.open.common.utils.JsonUtil;
import com.xblog.open.model.RespEntity;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * desc:
 * author: xuebin3765@163.com
 * date: 2019/09/23
 */
public class BaseController extends BaseLogs {

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

    protected ModelAndView successView(String view, Object data){

        debug("step into successView, view: {}", view);
        ModelAndView modelAndView = new ModelAndView(view);

        RespEntity respEntity = new RespEntity();
        respEntity.setData(data);
        debug("data: {}", JsonUtil.toStringNoRelation(respEntity));

        modelAndView.addAllObjects(respEntity.toMap());
        debug("step out successView, view: {}", view);
        return modelAndView;
    }

    /**
     * 跳转到错误页面
     * @param view 页面地址
     * @param respCode 响应码
     * @param errorMsg 错误描述信息
     * @return view
     */
    protected ModelAndView errorView(String view, String respCode, List<ErrorMsg> errorMsg){

        debug("step into errorView, view: {}, respCode: {}", view, respCode);
        ModelAndView modelAndView = new ModelAndView(view);

        RespEntity respEntity = new RespEntity();
        Map<String, Object> data = Maps.newHashMap();
        for (ErrorMsg error: errorMsg) {
            data.put(error.getPropertyPath(), error.getMessage());
        }
        return getModelAndView(respCode, data, modelAndView, respEntity);
    }


    /**
     * 跳转到错误页面
     * @param view 页面地址
     * @param respCode 响应码
     * @param data 错误数据
     * @return view
     */
    protected ModelAndView errorView(String view, String respCode, Object data){

        debug("step into errorView, view: {}, respCode: {}", view, respCode);
        ModelAndView modelAndView = new ModelAndView(view);

        RespEntity respEntity = new RespEntity();
        return getModelAndView(respCode, data, modelAndView, respEntity);
    }

    /**
     * 跳转到错误页面
     * @param view 页面地址
     * @param respCode 响应码
     * @return view
     */
    protected ModelAndView errorView(String view, String respCode){

        debug("step into errorView, view: {}, respCode: {}", view, respCode);
        ModelAndView modelAndView = new ModelAndView(view);

        RespEntity respEntity = new RespEntity();
        return getModelAndView(respCode, null, modelAndView, respEntity);
    }

    private ModelAndView getModelAndView(String respCode, Object data, ModelAndView modelAndView, RespEntity respEntity) {
        respEntity.setRespCode(respCode);
        respEntity.setRespMsg(RespEntity.getFileMsg(respCode));
        respEntity.setData(data);
        debug("data: {}", JsonUtil.toStringNoRelation(respEntity));

        modelAndView.addAllObjects(respEntity.toMap());
        debug("step out errorView");
        return modelAndView;
    }
}
