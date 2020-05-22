package PresentCloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Token {
    private int id;
    private String token;
    private int UserID;    // 登录的用户的id
    private Date LoginTime;
    private Date logoutTime;
    private int IfOverTime;
    private String LoginMethod;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public Date getLoginTime() {
        return LoginTime;
    }

    public void setLoginTime(Date loginTime) {
        LoginTime = loginTime;
    }

    public Date getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(Date logoutTime) {
        this.logoutTime = logoutTime;
    }

    public int getIfOverTime() {
        return IfOverTime;
    }

    public void setIfOverTime(int ifOverTime) {
        IfOverTime = ifOverTime;
    }

    public String getLoginMethod() {
        return LoginMethod;
    }

    public void setLoginMethod(String loginMethod) {
        LoginMethod = loginMethod;
    }
}
