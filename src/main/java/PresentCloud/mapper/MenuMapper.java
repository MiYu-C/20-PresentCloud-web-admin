package PresentCloud.mapper;

import PresentCloud.pojo.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper

@Repository///DAO层 使用的 也可以用com
public interface MenuMapper {
    int addMenu(Menu menu);
}
