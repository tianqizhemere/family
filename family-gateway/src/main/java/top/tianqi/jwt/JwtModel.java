package top.tianqi.jwt;

import java.util.List;

/**
 * Jwt 模型
 * @Author wkh
 * @Date 2020/8/10 16:45
 */
public class JwtModel {
    /** 用户名 */
    private String userName;
    /** 角色 */
    private List<String> roleIdList;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getRoleIdList() {
        return roleIdList;
    }

    public void setRoleIdList(List<String> roleIdList) {
        this.roleIdList = roleIdList;
    }

    public JwtModel() {

    }

    public JwtModel(String userName, List<String> roleIdList) {
        this.userName = userName;
        this.roleIdList = roleIdList;
    }
}
