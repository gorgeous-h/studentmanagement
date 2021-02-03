package com.yhpt.studentmanagement.mapper;

import com.yhpt.studentmanagement.entity.Student;
import com.yhpt.studentmanagement.vo.StudentVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface StudentMapper {

    List<StudentVO> getStudents(Map<String, Object> params);

    int getStudentsCount(Map<String, Object> params);

    void insertStudent(StudentVO studentVO);

    void updateStudent(StudentVO studentVO);

    StudentVO getStudentVO(Integer studentId);

    void deleteStudent(Integer studentId);

}
