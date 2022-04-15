package cn.code.yafanet.model.request;

/**
 * @author AllenHe
 * @date 2022/3/24
 * @apiNote 登录 Request
 */
public class LoginRequest {

    private  String phone;

    private  String pwd;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
