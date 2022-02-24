package com.seckill.controller;

import com.seckill.entity.User;
import com.seckill.service.GoodsService;
import com.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author zhanbo
 * @Description TODO
 * @Date 2022-02-23 19:42
 * @Version 1.0
 **/
@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/list")
    public String list(Model model, User user) {
        model.addAttribute("user", user);
        //查询商品列表
        List<GoodsVo> goodsList = goodsService.goodsList();
        model.addAttribute("goodsList", goodsList);
        return "goods_list";
    }

    @GetMapping("/detail/{goodsId}")
    public String detail(Model model, User user, @PathVariable("goodsId") Long goodsId) {
        model.addAttribute("user", user);
        //查询商品列表
        GoodsVo goodsVo = goodsService.getGoodsDetailById(goodsId);
        model.addAttribute("goods", goodsVo);
        int miaoshaStatus;
        int remainSeconds;
        long startAt = goodsVo.getStartDate().getTime();
        long endAt = goodsVo.getEndDate().getTime();
        long now = System.currentTimeMillis();
        if(now < startAt ) {//秒杀还没开始，倒计时
            miaoshaStatus = 0;
            remainSeconds = (int)((startAt - now )/1000);
        }else  if(now > endAt){//秒杀已经结束
            miaoshaStatus = 2;
            remainSeconds = -1;
        }else {//秒杀进行中
            miaoshaStatus = 1;
            remainSeconds = 0;
        }
        model.addAttribute("miaoshaStatus", miaoshaStatus);
        model.addAttribute("remainSeconds", remainSeconds);
        return "goods_detail";
    }
}
