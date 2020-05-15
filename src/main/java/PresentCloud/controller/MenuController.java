package PresentCloud.controller;

import PresentCloud.pojo.Menu;
import PresentCloud.mapper.MenuMapper;
import PresentCloud.mapper.UserCourseMapper;
import PresentCloud.mapper.UserMapper;
import PresentCloud.tool.RedisUtil;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
public class MenuController {

    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisUtil redisUtil;

    @PostMapping("menu")
    public Tool addMenu(HttpServletRequest request) {
        Tool result = new Tool<>();
        String MenuName = request.getParameter("MenuName");
        String Icon = request.getParameter("Icon");
        String url = request.getParameter("url");
        int ParentMenuID = Integer.parseInt(request.getParameter("ParentMenuID"));
        int isPage = Integer.parseInt(request.getParameter("isPage"));
        String order = request.getParameter("Order");
        int id = Integer.parseInt(String.valueOf(redisUtil.get(request.getHeader("token"))));
        String Createby = userMapper.queryUserById(id).getName();
        Menu menu=new Menu();
        menu.setName(MenuName);
        menu.setCreateby(Createby);
        menu.setCreateDate(new Date());
        menu.setIcon(Icon);
        menu.setUrl(url);
        menu.setFatherId(ParentMenuID);
        menu.setIsPage(isPage);
        menu.setOrder(order);
        menuMapper.addMenu(menu);
        result.setMessage("添加菜单成功");
        result.setFlag("true");
        result.setCode(2000);
        return result;
    }
}
