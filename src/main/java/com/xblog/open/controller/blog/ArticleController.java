package com.xblog.open.controller.blog;

import com.xblog.open.common.controller.BaseController;
import com.xblog.open.common.response.ResponseBean;
import com.xblog.open.dto.ArticleReqDTO;
import com.xblog.open.entity.blog.Article;
import com.xblog.open.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author xuebin@si-tech.com.cn
 * @Description
 * @date 2019/08/04
 */
@RestController
@RequestMapping("/api/article")
public class ArticleController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Resource
    private ArticleService articleService;

    @ResponseBody
    @RequestMapping(value = "v1/addOrUpdate", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE , MediaType.TEXT_PLAIN_VALUE})
    public ResponseBean add(
            @RequestBody @Validated ArticleReqDTO articleReqDTO,
            HttpServletRequest request){
        logger.info(String.format("request_log_param=%s", articleReqDTO.toString()));
        Article article = articleService.add(articleReqDTO);
        if (null == article){
            return error("add article failed !", article);
        }
        return success("success", article);
    }

    @ResponseBody
    @RequestMapping(value = "v1/delete", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE , MediaType.TEXT_PLAIN_VALUE})
    public ResponseBean delete(@RequestParam("id") Integer id){
        logger.info(String.format("request_log_param: id = %d", id));
        Article article = articleService.delete(id);
        if (null == article){
            return error("add article failed !", article);
        }
        return success("success", article);
    }
}
