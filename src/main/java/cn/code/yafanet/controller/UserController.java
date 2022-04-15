package cn.code.yafanet.controller;

import cn.code.yafanet.model.entity.User;
import cn.code.yafanet.model.entity.VideoOrder;
import cn.code.yafanet.model.request.LoginRequest;
import cn.code.yafanet.service.UserService;
import cn.code.yafanet.utils.JsonData;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author AllenHe
 * @date 2022/3/23
 * @apiNote
 */

@RestController
@RequestMapping("api/v1/pri/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 注册接口
     * @param userInfo
     * @return
     */
    @PostMapping("register")
    @ResponseBody
    public JsonData register(@RequestBody Map<String, String> userInfo){
        int rows = userService.save(userInfo);
        return rows == 1 ? JsonData.buildSuccess(): JsonData.buildError("注册失败，请重试");
    }

    /**
     * 登录接口
     * @param loginRequest
     * @return
     */
    @PostMapping("login")
    public JsonData login(@RequestBody LoginRequest loginRequest){

        String token = userService.findByPhoneAndPwd(loginRequest.getPhone(),loginRequest.getPwd());

        return token == null ?JsonData.buildError("登录失败,账号密码错误"):JsonData.buildSuccess(token);
    }

    /**
     * 根据用户Id查询用户信息
     * @param request
     * @return
     */
    @GetMapping("find_by_token")
    public JsonData findUserInfoByToken(HttpServletRequest request){
        Integer userId = (Integer) request.getAttribute("user_id");
        if(userId == null){
            return JsonData.buildError("查询失败");
        }

        User user = userService.findByUserId(userId);

        return JsonData.buildSuccess(user);

    }





}
