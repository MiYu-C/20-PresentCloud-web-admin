package PresentCloud.controller;


import PresentCloud.mapper.RoleMapper;
import PresentCloud.mapper.Transition;
import PresentCloud.mapper.UserMapper;
import PresentCloud.pojo.User;
import PresentCloud.pojo.Role;
import PresentCloud.pojo.UserRole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private Transition transition;

    @GetMapping("user/list") ///显示用户列表
    public Tool  queryUserList(){
        Tool result = new Tool<>();
        result.setMessage("用户管理列表查询成功");
        result.setFlag("true");
        result.setCode(200);
        List<User> userList=userMapper.queryUserList();
        List<String> rolenames = new ArrayList<>();
        List users=new ArrayList<>();///最终得到的一个个放入
        for (User user:userList) {
            int userId=user.getId();
            List<UserRole> userRoles=transition.getRoleIdByUserId(userId);//拿到用户ID 去查询 用户对应的角色ID
            for (UserRole userRole:userRoles) {
                int roleid=userRole.getRole_id();
                List<Role> roleList=roleMapper.queryRoleNameByRoleId(roleid);///用角色ID 查询 用户的角色
                for (Role role:roleList) {
                    ///一层只查询一种角色
                    rolenames.add(role.getName());
                }
            }
            ///得到用户角色数组 rolenames
            ///resuser 代表 返回中的data
            Map resuser=new HashMap();
            resuser.put("roleType",rolenames);
            resuser.put("id",userId);
            resuser.put("account",user.getAccount());
            resuser.put("name",user.getName());

            users.add(resuser);
            ///获取用户对应角色 加入到roleType中

        }
        result.setData(users);
        return result;
    }

    //添加用户
    @PostMapping("user")
    public Tool  addUser(HttpServletRequest request){
        Tool result = new Tool<>();
        String userAccount=request.getParameter("userAccount");
        String sex=request.getParameter("sex");
        String  nickname=request.getParameter("nickname");
        String phone=request.getParameter("phone");
        String academy=request.getParameter("academy");
        String password=request.getParameter("password");
        String schoolid=request.getParameter("schoolid");   //表示学号 或者教师工号
        ///当前操作用户
        String creater="朱";
        Date date=new Date();
//        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        User user=new User();
//        user.setAcademy(academy);
//        user.setUserAccount(userAccount);
//        user.setSex(sex);
        user.setName(nickname);;
//        user.setPhone(phone);
        user.setPassword(password);
//        user.setSchoolid(schoolid);
        user.setCreater(creater);
        user.setCreatetime(date);
        userMapper.addUser(user);
        result.setMessage("新增用户成功");
        result.setFlag("true");
        result.setCode(200);
        return result;
    }
}
