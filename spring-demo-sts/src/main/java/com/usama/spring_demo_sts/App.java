package com.usama.spring_demo_sts;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    
//    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    	System.out.println(context.isActive());
    	HelloWorldService hwsObject = context.getBean(HelloWorldService.class);
    	hwsObject.message();
    	System.out.println(hwsObject);
    	System.out.println(context.getStartupDate());
    	context.close();
    	System.out.println(context.isActive());
    	
    	Employee e = new Engineer();
    	e.doWork();	
    	Employee e2 = new Manager();
    	e2.doWork();
    	
    	
    	Employee enginner = (Employee) context.getBean( Engineer.class);
//    	Employee enginner = (Employee) context.getBean( "engineer");
    	
    	Employee manager =  (Employee) context.getBean( Manager.class );
//    	Employee manager =  (Employee) context.getBean( "manager");
    	enginner.doWork();
    	manager.doWork();
    	
//    	Address address = (Address)context.getBean(Address.class);
//    	System.out.println(String.format("id is %d, city is %s", address.getId(), address.getCity()));
    	
    	Address a = new Address();
    	a.setCity("Delhi");
    	a.setId(1);
    	System.out.println(String.format("id is %d, city is %s", a.getId(), a.getCity()));
    	
    	context.close();
    	
    	
    }
}
