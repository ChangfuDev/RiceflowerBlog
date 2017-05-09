package com.guxiang.service;

import com.guxiang.common.PageConfig;
import com.guxiang.common.PageInfoResult;
import com.guxiang.pojo.Recommend;

/**
 * Created by guxiang  .
 */
public interface IRecommendService {

    long add(Recommend recommendVo);
    long edit(Recommend recommendVo);
    boolean remove(long id);
    PageInfoResult<Recommend> list(PageConfig pageConfig, Recommend recommend);
    boolean hits(Long id);

    Recommend get(long id);
}