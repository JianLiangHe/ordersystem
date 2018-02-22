package edu.ordersystem.service;

import edu.ordersystem.entity.VIPCard;

/**
 * 定于VIPCard相关业务的接口
 */
public interface IVIPCardService {

    //新增VIPCard
    void saveVIPCard(VIPCard card);

    //根据账号查询VIPCard
    VIPCard findVIPCardByAccount(String account);
}
