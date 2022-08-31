package com.qfedu.dao;

import com.qfedu.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDAO {

    public int insertStudent(Student student);
    public int deleteStudent(String stuNum);
    public int updateStudent(Student student);
    public List<Student> listStudents();
    public Student queryStudent(String stuNum);
    public int getCount();//获取总记录数
//    public List<Student> listStudentsByPage(HashMap<String, Integer> map);//分页查询
    public List<Student> listStudentsByPage(@Param("start") int start, @Param("pageSize") int pageSize);//分页查询
}
