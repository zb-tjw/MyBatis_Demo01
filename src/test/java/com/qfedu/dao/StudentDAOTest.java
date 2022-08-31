package com.qfedu.dao;

import com.qfedu.pojo.Student;
import com.qfedu.utils.MyBatisUtil;
import junit.framework.TestCase;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class StudentDAOTest {

    @org.junit.Test
    public void insertStudent() {

        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try {
            StudentDAO studentDAO = sqlSession.getMapper(StudentDAO.class);
            Student student = new Student(0, "10006", "老八", "男", 48);
            int i = studentDAO.insertStudent(student);
            sqlSession.commit();
            System.out.println(i);
            System.out.println(student);
        } catch (Exception e) {
           sqlSession.rollback();
        }
    }

    @org.junit.Test
    public void deleteStudent() {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(is);
            SqlSession sqlSession = factory.openSession();
            StudentDAO studentDAO = sqlSession.getMapper(StudentDAO.class);
            int i = studentDAO.deleteStudent("10001");
            sqlSession.commit();
            System.out.println(i);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void updateStudent() {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(is);
            SqlSession sqlSession = factory.openSession();
            StudentDAO studentDAO = sqlSession.getMapper(StudentDAO.class);
            int i = studentDAO.updateStudent(new Student(0, "10001", "李四", "女", 22));
            sqlSession.commit();
//            System.out.println(i);
//            TestCase.assertEquals(1, i);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void selectStudent() {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(is);
            SqlSession sqlSession = factory.openSession();
            StudentDAO studentDAO = sqlSession.getMapper(StudentDAO.class);
            List<Student> list = studentDAO.listStudents();
            for (Student stu:list) {
                System.out.println(stu);
            }
//            sqlSession.commit();//查询不需要commit操作即可
            TestCase.assertNotNull(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void queryStudent() {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(is);
            SqlSession sqlSession = factory.openSession();
            StudentDAO studentDAO = sqlSession.getMapper(StudentDAO.class);
            Student student = studentDAO.queryStudent("10001");
            System.out.println(student);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void testGetCount() {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(is);
            SqlSession sqlSession = factory.openSession();
            StudentDAO studentDAO = sqlSession.getMapper(StudentDAO.class);
            int count = studentDAO.getCount();
            System.out.println(count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void testListStudentsByPage() {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(is);
            SqlSession sqlSession = factory.openSession();
            StudentDAO studentDAO = sqlSession.getMapper(StudentDAO.class);
//            HashMap<String, Integer> map = new HashMap<String, Integer>();
//            map.put("start",0);
//            map.put("pageSize",2);
//            List<Student> list = studentDAO.listStudentsByPage(map);
            List<Student> list = studentDAO.listStudentsByPage(0, 2);
            for (Student stu:list) {
                System.out.println(stu);
            }
//            sqlSession.commit();
            TestCase.assertNotNull(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}