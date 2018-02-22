package edu.ordersystem.service.impl;

import edu.ordersystem.dao.VIPCardDao;
import edu.ordersystem.entity.VIPCard;
import edu.ordersystem.exception.UserException;
import edu.ordersystem.service.IVIPCardService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 处理VIPCard相关业务的实现类
 */
@Service("vipCardService")
@Transactional(propagation = Propagation.REQUIRED)
public class VIPCardServiceImpl implements IVIPCardService {

    //声明Dao
    @Resource
    private VIPCardDao vipCardDao;

    /**
     * 新增VIPCard
     * @param card
     */
    @Override
    public void saveVIPCard(VIPCard card) {
        if(findVIPCardByAccount(card.getAccount())!=null) throw new UserException("该VIP卡账号已存在.");
        try {
            vipCardDao.saveVIPCard(card);
        } catch (RuntimeException e){
            throw new UserException("输入信息有误,请检查.");
        }
    }

    /**
     * 根据账号查询VIPCard
     * @param account
     * @return
     */
    @Override
    public VIPCard findVIPCardByAccount(String account) {
        return vipCardDao.findVIPCardByAccount(account);
    }

    public void setVipCardDao(VIPCardDao vipCardDao) {
        this.vipCardDao = vipCardDao;
    }
}
