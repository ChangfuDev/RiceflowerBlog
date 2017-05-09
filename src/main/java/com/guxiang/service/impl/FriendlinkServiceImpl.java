package com.guxiang.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.guxiang.common.PageConfig;
import com.guxiang.common.PageInfoResult;
import com.guxiang.dao.IFriendDao;
import com.guxiang.pojo.Friendlink;
import com.guxiang.service.IFriendlinkService;
import com.guxiang.util.ReturnUtil;

import java.util.Date;
import java.util.List;

/**
 * Created by guxiang  .
 */
@Service("iFriendlinkService")
public class FriendlinkServiceImpl implements IFriendlinkService {

    @Autowired
    private IFriendDao iFriendDao;

    /**
     * 添加
     *
     * @param friendlink
     * @return 操作结果
     */
    @Override
    public boolean add(Friendlink friendlink) {
        if(friendlink==null){
            return false;
        }
        friendlink.setAddTime(new Date());
        friendlink.setHits(0);
        int result = iFriendDao.insert(friendlink);
        return ReturnUtil.returnResult(result);
    }

    /**
     * 分页获取
     *
     * @param pageConfig
     * @return 分页结果
     */
    @Override
    public PageInfoResult<Friendlink> pagingList(PageConfig pageConfig) {
        List<Friendlink> list = iFriendDao.selectBy(pageConfig);
        int count = iFriendDao.selectCountBy();
        PageInfoResult<Friendlink> pageInfoResult = new PageInfoResult<>(list,pageConfig,count);
        return pageInfoResult;
    }

    /**
     * 获取所有
     *
     * @return 所有记录
     */
    @Override
    public List<Friendlink> list() {
        List<Friendlink> list = iFriendDao.selectBy(null);
        return list;
    }

    @Override
    public Friendlink get(int fId) {
        Friendlink friendlink = iFriendDao.selectById(fId);
        return friendlink;
    }

    @Override
    public boolean delete(int fId) {
        int result = iFriendDao.deleteById(fId);
        return ReturnUtil.returnResult(result);
    }

    @Override
    public boolean update(Friendlink friendlink) {
        int result = iFriendDao.update(friendlink);
        return ReturnUtil.returnResult(result);
    }

    @Override
    public boolean hits(int id) {
        Friendlink friendlink = iFriendDao.selectById(id);
        friendlink.setHits(friendlink.getHits()+1);
        iFriendDao.updateHits(friendlink);
        return true;
    }
}
