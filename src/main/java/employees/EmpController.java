package employees;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Controller
public class EmpController {

    @RequestMapping("/empform")
    public ModelAndView showform(){
        return new ModelAndView("empform","command",new Emp());
    }

    @RequestMapping(value="/save",method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("emp") Emp emp){
        System.out.println(emp.getName()+" "+emp.getSalary()+" "+emp.getDesignation());
        return new ModelAndView("redirect:/viewemp");
    }

    @RequestMapping("/viewemp")
    public ModelAndView viewemp(){
        List<Emp> list=new ArrayList<Emp>();
        list.add(new Emp(1,"Jakub",35000f,"Trener"));
        list.add(new Emp(2,"Adam",25000f,"Siatkarz"));
        list.add(new Emp(3,"Robert",55000f,"YouTuber"));

        return new ModelAndView("viewemp","list",list);
    }
}