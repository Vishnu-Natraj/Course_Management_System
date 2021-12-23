public class Student {
    String Student_Id;
    String Student_name;
    int Address_Id;
    int Course_Id;
    int Age;
    String DOB;
    int Fees;
    String Gender;
    String Phone_Number;
    int Mark_1;
    int Mark_2;
    int Mark_3;
    String Email;
    String Attendance;
    int GPA;

    public Student(String student_Id, String student_name, int address_Id, int course_Id, int age, String dOB, int fees,
            String gender, String phone_Number, int mark_1, int mark_2, int mark_3, String email, String attendance,
            int gPA) {
        Student_Id = student_Id;
        Student_name = student_name;
        Address_Id = address_Id;
        Course_Id = course_Id;
        Age = age;
        DOB = dOB;
        Fees = fees;
        Gender = gender;
        Phone_Number = phone_Number;
        Mark_1 = mark_1;
        Mark_2 = mark_2;
        Mark_3 = mark_3;
        Email = email;
        Attendance = attendance;
        GPA = gPA;

    }

    public String getStudent_Id() {
        return Student_Id;
    }

    public void setStudent_Id(String student_Id) {
        Student_Id = student_Id;
    }

    public String getStudent_name() {
        return Student_name;
    }

    public void setStudent_name(String student_name) {
        Student_name = student_name;
    }

    public int getAddress_Id() {
        return Address_Id;
    }

    public void setAddress_Id(int address_Id) {
        Address_Id = address_Id;
    }

    public int getCourse_Id() {
        return Course_Id;
    }

    public void setCourse_Id(int course_Id) {
        Course_Id = course_Id;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String dOB) {
        DOB = dOB;
    }

    public int getFees() {
        return Fees;
    }

    public void setFees(int fees) {
        Fees = fees;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getPhone_Number() {
        return Phone_Number;
    }

    public void setPhone_Number(String phone_Number) {
        Phone_Number = phone_Number;
    }

    public int getMark_1() {
        return Mark_1;
    }

    public void setMark_1(int mark_1) {
        Mark_1 = mark_1;
    }

    public int getMark_2() {
        return Mark_2;
    }

    public void setMark_2(int mark_2) {
        Mark_2 = mark_2;
    }

    public int getMark_3() {
        return Mark_3;
    }

    public void setMark_3(int mark_3) {
        Mark_3 = mark_3;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAttendance() {
        return Attendance;
    }

    public void setAttendance(String attendance) {
        Attendance = attendance;
    }

    public int getGPA() {
        return GPA;
    }

    public void setGPA(int gPA) {
        GPA = gPA;
    }

}
