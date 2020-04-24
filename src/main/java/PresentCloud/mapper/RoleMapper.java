package PresentCloud.mapper;

import PresentCloud.pojo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper

@Repository
public interface RoleMapper {

    List <Role> queryRoleNameByRoleId(int id);
    List <Role> queryRoleList();
    Role queryRoleById(int id);
    int addRole(Role role);
    int updateRole(Role role);
    int deleteRole(int id);
}
