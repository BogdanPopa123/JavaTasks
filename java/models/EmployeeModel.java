package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EmployeeModel {

    private int id;
    private String fullName;
    private String occupation;
    private int salary;
    private Date dateOfEmployment;

    @Override
    public String toString() {
        return "EmployeeModel{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", occupation='" + occupation + '\'' +
                ", salary=" + salary +
                ", dateOfEmployment=" + dateOfEmployment +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

//    public void setDateOfEmployment(String dateOfEmployment) {
//
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//        try {
//            this.dateOfEmployment = sdf.parse(dateOfEmployment);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        String s;
//        s = sdf.format(new Date() );
//        System.out.println(s);
//
//
//    }


    public void setDateOfEmployment(Date dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }
}
