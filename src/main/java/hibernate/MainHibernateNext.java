package hibernate;

import java.util.Date;
import java.util.List;

//MainHibernate z wykorzystaniem interfejsu
public class MainHibernateNext {
    public static void main(String[] args) {
        HibernateDao hibernateDao = new HibernateDao();
        Employees employee = new Employees("Test", "Test", "Test", "Test", 1000, 18 , new Date(), 1);
        hibernateDao.save(employee);
        List<Employees> employeesList = (List<Employees>) hibernateDao.getEntities("Employees", Employees.class);
        //ta funkcja zrobiona dla zabawy, bo nie wiem czy aż taka abstrakcja w funkcji jest dobrym wyjściem :)

        Employees employeeToUpdate = employeesList.get(1);
        employeeToUpdate.setSalary(9999);

        hibernateDao.update(employeeToUpdate);
        employeesList.forEach(System.out::println);

        Phones phones = new Phones("Sony", "Xperia 10");

        hibernateDao.save(phones);
        hibernateDao.getEntities("Phones", Phones.class).forEach(System.out::println);
    }
}