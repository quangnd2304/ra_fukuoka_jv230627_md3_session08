package presentation;

import bussiness.StudentBussiness;
import bussiness.StudentBussinessImp;
import entity.Student;

import java.util.List;
import java.util.Scanner;

public class StudentManagement {
    private static StudentBussiness studentBussiness = new StudentBussinessImp();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("***********STUDENT MANAGEMENT************");
            System.out.println("1. Hiển thị thông tin sinh viên");
            System.out.println("2. Thêm mới sinh viên");
            System.out.println("3. Cập nhật sinh viên");
            System.out.println("4. Xóa sinh viên");
            System.out.println("5. Thống kê sinh viên theo trạng thái");
            System.out.println("6. Thoát");
            System.out.print("Sự lựa chọn của bạn:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    //1: studentBussiness.getAllStudent()
                    //6: List<Student> listStudent = studentBussiness.getAllStudent()
                    List<Student> listStudent = studentBussiness.getAllStudent();
                    //Hien thi thong tin sinh viên
                    listStudent.stream().forEach(st-> System.out.println(st.toString()));
                    break;
                case 2:
                    Student studentNew = new Student();
                    studentNew.inputData(scanner);
                    boolean result = studentBussiness.createStudent(studentNew);
                    if (result){
                        System.out.println("Thêm mới thành công");
                    }else{
                        System.err.println("Có lỗi trong quá trình thêm mới sinh viên");
                    }
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("Nhập vào trạng thái sinh viên cần thống kê");
                    boolean status = Boolean.parseBoolean(scanner.nextLine());
                    int cntStudent = studentBussiness.getCntStudentByStatus(status);
                    System.out.println("Số sinh viên theo giới tính là: "+cntStudent);
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.err.println("Vui lòng chọn từ 1 đến 5");
            }
        }while (true);
    }
}
