package cn.code.yafanet.mapper;

import cn.code.yafanet.model.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author AllenHe
 * @date 2022/3/23
 * @apiNote
 */
public interface UserMapper {

    /**
     * 新增用户
     * @param user
     * @return
     */
    int save(User user);

    /**
     * 根据手机号查找用户
     * @param phone
     * @return
     */
    User findByPhone(@Param("phone") String phone);

    /**
     * 根据手机号和密码查找用户
     * @param phone
     * @param pwd
     * @return
     */
    User findByPhoneAndPwd(@Param("phone") String phone,@Param("pwd") String pwd);

    /**
     * 根据用户Id查询用户信息
     * @param userId
     * @return
     */
    User findByUserId(@Param("user_id") Integer userId);
}
