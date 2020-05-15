package PresentCloud.controller;

import PresentCloud.mapper.RoleMapper;
import PresentCloud.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import PresentCloud.tool.RedisUtil;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
public class RoleController {
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("role2/list") ///显示用户列表
    public Tool  queryRoleList(){
        Tool result = new Tool<>();
        List<Role> roleList=new ArrayList<>();
        roleList=roleMapper.queryRoleList();
        List resroles=new ArrayList();
        for (Role role:roleList
        ) {
            Map resrole=new HashMap();
            resrole.put("id",role.getId());
            resrole.put("name",role.getRolename());
            resroles.add(resrole);
        }
        result.setData(resroles);
        result.setCode(2000);
        result.setFlag("true");
        result.setMessage("角色列表查询成功");
        return result;
    }

    @GetMapping("role")
    public Tool  queryRoleById(HttpServletRequest request){
        Tool result = new Tool<>();
        int id=Integer.parseInt(request.getParameter("id"));
        Role role=roleMapper.queryRoleById(id);
        Map res=new HashMap();
        res.put("id",role.getId());
        res.put("name",role.getName());
        result.setData(res);
        result.setCode(2000);
        result.setFlag("true");
        result.setMessage("角色查询成功");
        return result;
    }

    @PostMapping("role")
    public Tool  addRole(HttpServletRequest request){
        Tool result = new Tool<>();
        Role role=new Role();
        String name=request.getParameter("name");
        String creater=String.valueOf(redisUtil.get(request.getHeader("token")));
        Date date=new Date();
        role.setName(name);
        role.setCreater(creater);
        role.setCreatetime(date);
        roleMapper.addRole(role);
        result.setCode(2000);
        result.setFlag("true");
        result.setMessage("角色添加成功");
        return result;
    }

    @DeleteMapping("role")
    public Tool  DeleteRole(HttpServletRequest request){
        Tool result = new Tool<>();
        int id=Integer.parseInt(request.getParameter("id"));
        roleMapper.deleteRole(id);
        result.setCode(2000);
        result.setFlag("true");
        result.setMessage("角色删除成功");
        return result;
    }


}
