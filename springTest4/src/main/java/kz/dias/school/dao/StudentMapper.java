package kz.dias.school.dao;

import kz.dias.school.models.Student;
import kz.dias.school.mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentMapper {
    @Transactional
    public int saveStudent(Student student){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        session.insert("insertStudent", student);
        session.commit();
        session.close();
        return student.getId();
    }

    public void deleteStudent(int studentId){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        session.delete("deleteStudent", studentId);
        session.commit();
        session.close();
    }
    public List<Student> getAllStudents() {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        List<Student> studentList = session.selectList("getAllStudents");
        session.commit();
        session.close();
        return studentList;
    }
}
