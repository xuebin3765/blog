package com.xblog.open.dto;

import lombok.Data;
import lombok.NonNull;

/**
 * @author xuebin@si-tech.com.cn
 * Description 文章描述
 * date 2019/08/04
 */
@Data
public class ArticleReqDTO {

    @NonNull
    private int userId;
    @NonNull
    private String title;          // 标题

    private String imgUrl;         // 封面图
    @NonNull
    private int type;              // 原创，转载，翻译

    private String label;          // 标签，多个将id拼接起来

    private String loadUrl;        // 转载的url

    private String decoration;     // 描述，不填获取正文前半部分内容
    @NonNull
    private String context;        // 正文
}
