package PresentCloud.mapper;

import PresentCloud.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

//这个注解表示了这是一个mybatis的mapper类 或者在主入口函数中使用@MapperScan("PresentCloud.mapper")
@Mapper

@Repository     //DAO层 使用的 也可以用com
public interface UserMapper {
    List<User> queryUserList();
    User queryUserById(int id);
    int addUser(User user);
    int updateUser(User user);
    int deleteUser(int id);
    int resetPassword(String name);
    User queryUserByName(String name);
    User queryUseridByPhone(String phone);
    List<User> searmap(String username,String nickname,String rolename);
}
