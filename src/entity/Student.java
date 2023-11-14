package entity;

import java.util.Scanner;

public class Student {
    private int studentId;
    private String studentName;
    private int age;
    private String address;
    private boolean status;

    public Student() {
    }

    public Student(int studentId, String studentName, int age, String address, boolean status) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.address = address;
        this.status = status;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String toString(){
        return "StudentID: "+this.studentId+" - StudentName: "+this.studentName+" - Age: "+this.age;
    }

    public void inputData(Scanner scanner){
        System.out.println("Nhập vào tên sinh viên:");
        this.studentName = scanner.nextLine();
        System.out.println("Nhập vào tuổi sinh viên:");
        this.age = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập vào địa chỉ sinh viên:");
        this.address = scanner.nextLine();
        System.out.println("Nhập vào trạng thái sinh viên:");
        this.status = Boolean.parseBoolean(scanner.nextLine());
    }
}
