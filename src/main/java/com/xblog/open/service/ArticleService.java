package com.xblog.open.service;

import com.xblog.open.dto.ArticleReqDTO;
import com.xblog.open.entity.blog.Article;

/**
 * desc:
 * author: xuebin3765@163.com
 * date: 2019/08/04
 */
public interface ArticleService {
    Article add(ArticleReqDTO articleReqDTO);

    Article delete(Integer id);
}
