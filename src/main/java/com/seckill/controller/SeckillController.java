package com.seckill.controller;

import com.seckill.entity.User;
import com.seckill.service.GoodsService;
import com.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author zhanbo
 * @Description TODO
 * @Date 2022-02-24 19:41
 * @Version 1.0
 **/
@Controller
@RequestMapping("/seckill")
public class SeckillController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping
    public String seckill(Model model, User user, Long goodsId) {
        model.addAttribute("user", user);
        if(user==null){
            return "login";
        }
        GoodsVo goodsVo = goodsService.getGoodsDetailById(goodsId);
        Integer stockCount = goodsVo.getStockCount();
        if(stockCount<0){
            model.addAttribute("errmsg","商品已秒杀完");
            return "seckill_fail";
        }
        //进项秒杀 下订单 减库存
        //OrderInfo orderInfo = miaoshaService.seckill(user, goods);
        //model.addAttribute("orderInfo", orderInfo);
        model.addAttribute("goods", goodsVo);
        return "order_detail";
    }
}
