public class Course {
    int course_Id;
    String department_name;
    String start_date;
    String end_date;
    String no_of_semester;

    public Course(int course_Id, String department_name, String start_date, String end_date, String no_of_semester) {
        this.course_Id = course_Id;
        this.department_name = department_name;
        this.start_date = start_date;
        this.end_date = end_date;
        this.no_of_semester = no_of_semester;

    }

    public Course() {
    }

    public int getCourse_Id() {
        return course_Id;
    }

    public void setCourse_Id(int course_Id) {
        this.course_Id = course_Id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getno_of_semester() {
        return no_of_semester;
    }

    public void setno_of_semester(String no_of_Semester) {
        this.no_of_semester = no_of_Semester;
    }

}
