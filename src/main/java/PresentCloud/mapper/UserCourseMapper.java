package PresentCloud.mapper;

import PresentCloud.pojo.UserCourse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper

@Repository
public interface UserCourseMapper {

    List<UserCourse> queryCourseIdbyUserid(int uerid); //查询用户加入的课程
    //    List<UserCourse> queryCourseIdbyCreater(String username);//查询用户创建的课程
    int userAddCourse(UserCourse userCourse);
    List<UserCourse> queryListbyCourseID(int courseid);
    int deletemember(UserCourse userCourse);

}
