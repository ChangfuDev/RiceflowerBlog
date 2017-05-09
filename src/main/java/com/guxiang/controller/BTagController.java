package com.guxiang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.guxiang.common.CommonConstant;
import com.guxiang.common.CommonResult;
import com.guxiang.pojo.Article;
import com.guxiang.pojo.Tag;
import com.guxiang.service.IBArticleService;
import com.guxiang.service.IBTagService;
import com.guxiang.vo.ArticleVo;
import com.guxiang.vo.TagVo;

import java.util.List;

/**
 *
 */
@RequestMapping(value = "")
@Controller
public class BTagController {
    @Autowired
    private IBTagService iTagService;
    @Autowired
    private IBArticleService iArticleService;

    @ResponseBody
    @RequestMapping(value = "/blog/tag",method = RequestMethod.GET)
    public CommonResult listTags(){
        List<TagVo> listTags = iTagService.getAllVoBy(CommonConstant.ACTICLE_STATUS_BLOG);
        return new CommonResult(CommonConstant.SUCCESS_CODE,"",listTags);
    }
    @ResponseBody
    @RequestMapping(value = "/blog/tag/{name:.+}",method = RequestMethod.GET)
    public CommonResult listTagArticle(@PathVariable("name")String name){
        List<ArticleVo> listArticles = iArticleService.getAllByTagName(name);
        return new CommonResult(CommonConstant.SUCCESS_CODE,"",listArticles);
    }




    /*管理url开始*/
    @ResponseBody
    @RequestMapping(value = "/manage/tag", method = RequestMethod.GET)
    public CommonResult listMTags() {
        List<TagVo> listTags = iTagService.getAllVoBy(null);
        return new CommonResult(CommonConstant.SUCCESS_CODE, "", listTags);
    }

    @ResponseBody
    @RequestMapping(value = "/manage/tag", method = RequestMethod.PUT)
    public CommonResult updateTag(@RequestBody Tag tag) {
        Boolean result = iTagService.edit(tag);
        return new CommonResult(CommonConstant.SUCCESS_CODE, "", result);
    }

    @ResponseBody
    @RequestMapping(value = "/manage/tag", method = RequestMethod.POST)
    public CommonResult saveTag(@RequestBody Tag tag) {
        Boolean result = iTagService.add(tag);
        ;
        return new CommonResult(CommonConstant.SUCCESS_CODE, "", result);
    }

    @ResponseBody
    @RequestMapping(value = "/manage/tag/{tagId}", method = RequestMethod.GET)
    public CommonResult listTagArticles(@PathVariable("tagId") Integer tagId) {
        List<Article> listTagArticles = iArticleService.getAllByTagId(tagId, null);
        return new CommonResult(CommonConstant.SUCCESS_CODE, "", listTagArticles);
    }

    @ResponseBody
    @RequestMapping(value = "/manage/tag/{tagId}", method = RequestMethod.DELETE)
    public CommonResult deleteTag(@PathVariable("tagId") Integer tagId) {
        Boolean result = iTagService.deleteById(tagId);
        return new CommonResult(CommonConstant.SUCCESS_CODE, "", result);
    }

    @ResponseBody
    @RequestMapping(value = "/manage/tag/{tagId}/{articleId}", method = RequestMethod.DELETE)
    public CommonResult deleteTag(@PathVariable Integer tagId, @PathVariable Integer articleId) {
        Boolean result = iArticleService.deleteTag(tagId, articleId);
        return new CommonResult(CommonConstant.SUCCESS_CODE, "", result);
    }

}
