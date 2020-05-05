import models.EmployeeModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext springContext = new ClassPathXmlApplicationContext("SpringFile.xml");
        EmployeeModel model;
        model = springContext.getBean("EmployeeId", EmployeeModel.class);
        System.out.println(model);

    }


}
