package com.yhpt.studentmanagement.service;

import com.yhpt.studentmanagement.mapper.StudentMapper;
import com.yhpt.studentmanagement.vo.StudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: hjj
 * @Date: 2020/11/19 14:37
 * @Description:
 */
@Transactional
@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public Map<String, Object> getStudents(Map<String, Object> params) {
        Map<String, Object> map = new HashMap<>();
        map.put("rows", studentMapper.getStudents(params));
        map.put("total", studentMapper.getStudentsCount(params));
        return map;
    }

    public void saveStudent(StudentVO studentVO) {
        if(studentVO.getId()==null){
            studentMapper.insertStudent(studentVO);
        } else {
            studentMapper.updateStudent(studentVO);
        }
    }

    public StudentVO getStudentVO(Integer studentId) {
        return studentMapper.getStudentVO(studentId);
    }

    public void deleteStudent(Integer studentId) {
        studentMapper.deleteStudent(studentId);
    }

}
