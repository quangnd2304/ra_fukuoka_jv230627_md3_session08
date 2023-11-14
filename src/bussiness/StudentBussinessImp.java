package bussiness;

import entity.Student;
import util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class StudentBussinessImp implements StudentBussiness{
    @Override
    public List<Student> getAllStudent() {
        //2 - 3. Tạo đối tượng Connnection để làm việc với CSDL
        Connection conn = null;
        //4: Tạo đối tượng CallableStatement gọi procedure lấy danh sách sinh viên
        CallableStatement callSt = null;
        List<Student> listStudent = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call getAllStudent()}");
            //Thực hiện procedure
            ResultSet rs = callSt.executeQuery();
            listStudent = new ArrayList<>();
            //Duyet rs de lay du lieu add vao listStudent
            while (rs.next()){
                Student student = new Student();
                student.setStudentId(rs.getInt("student_id"));
                student.setStudentName(rs.getString("student_name"));
                student.setAge(rs.getInt("age"));
                student.setAddress(rs.getString("address"));
                student.setStatus(rs.getBoolean("student_status"));
                listStudent.add(student);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            //Đóng kết nối khi làm xong việc
            ConnectionDB.closeConnection(conn,callSt);
        }
        return listStudent;
    }

    @Override
    public boolean createStudent(Student student) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call createStudent(?,?,?,?)}");
            //set gia tri tham so vao
            callSt.setString(1,student.getStudentName());
            callSt.setInt(2,student.getAge());
            callSt.setString(3,student.getAddress());
            callSt.setBoolean(4,student.isStatus());
            //dang ky kieu du lieu cua tham so tra ra
            //Thuc hien procedure
            callSt.executeUpdate();
            result = true;
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return result;
    }

    @Override
    public boolean updateStudent(Student student) {
        return false;
    }

    @Override
    public boolean deleteStudent(int studentId) {
        return false;
    }

    @Override
    public int getCntStudentByStatus(boolean status) {
        Connection conn = null;
        CallableStatement callSt = null;
        int cnt = -1;
        try{
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call getCountStudentByStatus(?,?)}");
            //set gia trị cho tham số vào
            callSt.setBoolean(1,status);
            //đăng ký kiểu dữ liệu cho các tham số trả ra
            callSt.registerOutParameter(2, Types.INTEGER);
            //Thuc hien procedure
            callSt.execute();
            //Lay du lieu cua tham so tra ra
            cnt = callSt.getInt(2);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return cnt;
    }
}
