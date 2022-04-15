package cn.code.yafanet.controller;

import cn.code.yafanet.model.entity.VideoOrder;
import cn.code.yafanet.model.request.VideoOrderRequest;
import cn.code.yafanet.service.VideoOrderService;
import cn.code.yafanet.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author AllenHe
 * @date 2022/3/27
 * @apiNote 下单
 */
@RestController
@RequestMapping("/api/v1/pri/order")
public class VideoOrderController {

    @Autowired
    private VideoOrderService videoOrderService;

    /**
     * 下单接口
     * @return
     */
    @RequestMapping("save")
    public JsonData savaOrder(@RequestBody VideoOrderRequest videoOrderRequest, HttpServletRequest request){

        Integer userId = (Integer) request.getAttribute("user_id");

        int rows = videoOrderService.save(userId,videoOrderRequest.getVideoId());

        return  rows !=0? JsonData.buildSuccess(0,"下单成功"):JsonData.buildError("下单失败");

    }

    /**
     * 用户订单列表
     * @param request
     * @return
     */
    @GetMapping("list")
    public JsonData listOrder(HttpServletRequest request){
        Integer userId = (Integer) request.getAttribute("user_id");

        List<VideoOrder> videoOrderlist = videoOrderService.listOrderByUserId(userId);

        return  JsonData.buildSuccess(videoOrderlist);
    }

    /**
     * 是否有追剧订单查询
     * @return
     */
    @GetMapping("find_User_Payed")
    public JsonData findUserPayed(@RequestParam(value = "video_id",required = true)int videoId, HttpServletRequest request){
        Integer userId = (Integer) request.getAttribute("user_id");
        if(userId == null){
            return JsonData.buildError(-1,"查询失败,未登录");
        }

        VideoOrder videoOrder = videoOrderService.findUserPayed(videoId,userId);

        return videoOrder !=null ? JsonData.buildError(1,"已追剧"):JsonData.buildSuccess() ;
    }
}
