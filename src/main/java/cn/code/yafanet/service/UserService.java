package cn.code.yafanet.service;

import cn.code.yafanet.model.entity.User;
import cn.code.yafanet.model.entity.VideoOrder;

import java.util.Map;

/**
 * @author AllenHe
 * @date 2022/3/23
 * @apiNote
 */
public interface UserService {

    /**
     * 新增用户
     * @param userInfo
     * @return
     */
    int save(Map<String, String> userInfo);

    /**
     * 根据手机号和密码查询用户
     * @param phone
     * @param pwd
     * @return
     */
    String findByPhoneAndPwd(String phone, String pwd);

    /**
     * 根据用户Id查询用户信息
     * @param userId
     * @return
     */
    User findByUserId(Integer userId);


}
