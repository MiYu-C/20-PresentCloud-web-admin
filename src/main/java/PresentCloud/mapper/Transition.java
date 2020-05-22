package PresentCloud.mapper;

import PresentCloud.pojo.User;
import PresentCloud.pojo.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

//这个注解表示了这是一个mybatis的mapper类 或者在主入口函数中使用@MapperScan("PresentCloud.mapper")
@Mapper

@Repository   //DAO层 使用的 也可以用com
public interface Transition {
    List<UserRole> getRoleIdByUserId(int id);
    int addUserRole(UserRole userRole);
    int deleteUserRole(int id);
}
