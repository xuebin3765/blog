package com.xblog.open.service.impl;

import com.xblog.open.dto.ArticleReqDTO;
import com.xblog.open.entity.blog.Article;
import com.xblog.open.service.ArticleService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * desc:
 * author: xuebin3765@163.com
 * date: 2019/08/04
 */
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
    @Override
    public Article add(ArticleReqDTO articleReqDTO) {

        return null;
    }

    @Override
    public Article delete(Integer id) {
        return null;
    }
}
