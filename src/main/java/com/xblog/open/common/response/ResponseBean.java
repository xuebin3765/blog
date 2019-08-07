package com.xblog.open.common.response;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xblog.open.common.status.ResponseStatus;

/**
 * @author xuebin@si-tech.com.cn
 * @Description
 * @date 2019/08/03
 */
public class ResponseBean {

    private String respCode;
    private String respMsg;
    private Object respData;

    public ResponseBean() {
        this.respCode = ResponseStatus.RESP_SUCCESS;
        this.respMsg = ResponseStatus.RESP_SUCCESS_MSG;
    }

    /**
     * 成功响应体结果
     * @param respData 响应结果
     * @return ResponseBean
     */
    public static ResponseBean success(Object respData){
        return new ResponseBean(ResponseStatus.RESP_SUCCESS, ResponseStatus.RESP_SUCCESS_MSG, respData);
    }

    /**
     * 成功响应体结果
     * @param respData 响应结果
     * @param respMsg 响应信息
     * @return ResponseBean
     */
    public static ResponseBean success(String respMsg, Object respData){
        return new ResponseBean(ResponseStatus.RESP_SUCCESS, respMsg, respData);
    }

    /**
     * 失败响应体结果
     * @param respCode 响应状态
     * @param respMsg 响应信息
     * @param respData 响应结果
     * @return ResponseBean
     */
    public static ResponseBean error(String respCode, String respMsg, Object respData){
        return new ResponseBean(respCode, respMsg, respData);
    }

    /**
     * 失败响应体结果
     * @param respMsg 响应信息
     * @param respData 响应结果
     * @return ResponseBean
     */
    public static ResponseBean error(String respMsg, Object respData){
        return new ResponseBean(ResponseStatus.RESP_FAIL, respMsg, respData);
    }

    public ResponseBean(String respCode, String respMsg, Object respData) {
        this.respCode = respCode;
        this.respMsg = respMsg;
        this.respData = respData;
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespMsg() {
        return respMsg;
    }

    public void setRespMsg(String respMsg) {
        this.respMsg = respMsg;
    }

    public Object getRespData() {
        return respData;
    }

    public void setRespData(Object respData) {
        this.respData = respData;
    }

    /**
     * 响应结果转化成json
     * @return
     */
    public String toJson() {
        return JSON.toJSONString(this, SerializerFeature.DisableCircularReferenceDetect);

    }
}
