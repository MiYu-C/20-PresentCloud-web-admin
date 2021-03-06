package PresentCloud.controller;

import PresentCloud.mapper.UserMapper;
import PresentCloud.pojo.User;
import PresentCloud.tool.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    private UserMapper userMapper;
    @PostMapping("login/pwd")  //校验密码
    public  Tool verifyPassword(@RequestBody Map<String, Object> userMap){

        Tool result = new Tool<>();
        int  id = (int) userMap.get("userId");
        String password=(String) userMap.get("password");
        User user =userMapper.queryUserById(id);
        if (password.equals(user.getPassword())){
            result.setMessage("密码正确");
            result.setFlag("true");
            result.setCode(200);
            return  result;
        }else{
            result.setMessage("密码错误");
            result.setFlag("true");
            result.setCode(400);
            return  result;
        }

    }

    @PutMapping("login/pwd")  //修改密码
    public  Tool updatePassword(@RequestBody Map<String, Object> userMap){
        Tool result = new Tool<>();
        int  id = (int) userMap.get("userId");
        String password=(String) userMap.get("password");
        String newPassword=(String) userMap.get("newPassword");
        String confirmPassword=(String) userMap.get("confirmPassword");

        User user =userMapper.queryUserById(id);
        if (! password.equals(user.getPassword())){
            result.setMessage("密码错误");
            result.setFlag("false");
            result.setCode(400);
        }
        if (! newPassword.equals(confirmPassword)) {
            result.setMessage("新密码与确认密码不一致");
            result.setFlag("false");
            result.setCode(400);
        }
        user.setPassword(password);
        userMapper.updateUser(user);
        result.setMessage("修改密码成功");
        result.setFlag("true");
        result.setCode(200);
        return  result;
    }
}
