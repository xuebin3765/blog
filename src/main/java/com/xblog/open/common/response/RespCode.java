package com.xblog.open.common.response;

import com.xblog.open.common.annotation.RespMeg;

/**
 * @Author guodandan
 * @Date 2019/9/24 23:09
 */
public class RespCode {
    @RespMeg("成功")
    public static final String success = "000000";
    @RespMeg("系统内部错误")
    public static final String error = "999999";
}
