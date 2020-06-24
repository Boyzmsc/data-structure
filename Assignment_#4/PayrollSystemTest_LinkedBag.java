// Employee hierarchy test program.
import java.util.Scanner; // program uses Scanner to obtain user input

public class PayrollSystemTest_LinkedBag
{
	public static void main( String[] args ) 
	{
		
		BagInterface<Employee> aBag = new LinkedBag<>();
		BagInterface<Employee> bBag = new LinkedBag<>();
		
		// create subclass objects
	    SalariedEmployee salariedEmployee = 
	       new SalariedEmployee( 
	       "John", "Smith", "111-11-1111", 1, 15, 1944, 2,1,2000,1,1,2020,true, 400.00 );
	    SalariedEmployee salariedEmployee1 = 
	            new SalariedEmployee( 
	            "Sam", "Kim", "111-12-3411", 2, 15, 1947, 4,17,2001,2,1,2020,false, 600.00 );
	    SalariedEmployee salariedEmployee2 = 
	            new SalariedEmployee( 
	            "Dan", "David", "351-13-1251", 3, 25, 1954, 4,7,2002,2,2,2020,true, 800.00 );
	    HourlyEmployee hourlyEmployee = 
	    		new HourlyEmployee( 
	    		"Karen", "Price", "222-22-2222", 4, 29, 1960,3,6,2003 ,2,3,2020,true,12.75, 40 );
	    HourlyEmployee hourlyEmployee1 = 
	            new HourlyEmployee( 
	            "Lim", "Deep", "462-22-2522", 5, 29, 1940,2,6,2004 ,3,1,2020,false,14.75, 40 );
	    HourlyEmployee hourlyEmployee2 = 
	    		new HourlyEmployee( 
	    	    "Koo", "Cold", "364-23-2352", 6, 29, 1960,3,6,2005 ,4,1,2020,true,16.75, 40 );
	    CommissionEmployee commissionEmployee = 
	    		new CommissionEmployee( 
	    		"Sue", "Jones", "333-33-3333", 7, 8, 1954,7,3,2006,3,22,2020,false, 5000, .06 );
	    CommissionEmployee commissionEmployee1 = 
	    		new CommissionEmployee( 
	    		"Soo", "Kim", "333-33-1113", 8, 8, 1954,7,3,2007,4,2,2020,true, 10000, .06 );
	      
	    BasePlusCommissionEmployee basePlusCommissionEmployee = 
	    		new BasePlusCommissionEmployee( 
	    		"Bob", "Lewis", "444-44-4444", 9, 2, 1965,8,24,2008,3,27,2020,false, 5000, .03, 400 );
	    BasePlusCommissionEmployee basePlusCommissionEmployee1 = 
	    		new BasePlusCommissionEmployee( 
	    		"Moon", "King", "263-34-2984", 10, 2, 1965,8,24,2009, 1,1,2020,false,10000, .04, 300 );

	    /**System.out.println( "\nEmployees processed individually:\n" );
	      
	    System.out.printf( "%s\n%s: $%,.2f\n\n", 
	    		salariedEmployee, "earned", salariedEmployee.earnings() );
	    System.out.printf( "%s\n%s: $%,.2f\n\n", 
	    		salariedEmployee1, "earned", salariedEmployee1.earnings() );
	    System.out.printf( "%s\n%s: $%,.2f\n\n", 
	    		salariedEmployee2, "earned", salariedEmployee2.earnings() );
	    System.out.printf( "%s\n%s: $%,.2f\n\n",
	    		hourlyEmployee, "earned", hourlyEmployee.earnings() );
	    System.out.printf( "%s\n%s: $%,.2f\n\n",
	    		hourlyEmployee1, "earned", hourlyEmployee1.earnings() );
	    System.out.printf( "%s\n%s: $%,.2f\n\n",
	    		hourlyEmployee2, "earned", hourlyEmployee2.earnings() );
	    System.out.printf( "%s\n%s: $%,.2f\n\n",
	    		commissionEmployee, "earned", commissionEmployee.earnings() );
	    System.out.printf( "%s\n%s: $%,.2f\n\n",
	    		commissionEmployee1, "earned", commissionEmployee1.earnings() );
	    System.out.printf( "%s\n%s: $%,.2f\n\n", 
	    		basePlusCommissionEmployee, 
	    		"earned", basePlusCommissionEmployee.earnings() );
	    System.out.printf( "%s\n%s: $%,.2f\n\n", 
	    		basePlusCommissionEmployee1, 
	    		"earned", basePlusCommissionEmployee1.earnings() );
		**/
	    
	    aBag.add(salariedEmployee);
	    aBag.add(salariedEmployee1);
	    aBag.add(salariedEmployee2);
	    aBag.add(hourlyEmployee);
	    aBag.add(hourlyEmployee1);
	    aBag.add(hourlyEmployee2);
	    aBag.add(commissionEmployee);
	    aBag.add(commissionEmployee1);
	    aBag.add(basePlusCommissionEmployee);
	    aBag.add(basePlusCommissionEmployee1);

	    Scanner input = new Scanner( System.in ); // to get current month
	    int currentMonth;
	    int currentYear;
	    int currentDay;
	    Date currentDate;
	      
	    // get and validate current month
	    do
	    {
	    	System.out.print("Enter the current year: ");
	    	currentYear = input.nextInt();
	        System.out.print( "Enter the current month (1 - 12): " );
	        currentMonth = input.nextInt();
	        System.out.print("Enter the current day: ");
	        currentDay = input.nextInt();
	        System.out.println();
	        currentDate = new Date(currentMonth, currentDay, currentYear);
	         
	     } while ( (( currentMonth < 1 ) || ( currentMonth > 12 )) || (currentDate.getYear() < 0) || (currentDate.getDay() == -1));
	      
	     System.out.printf("Current Date : %s\n\n",currentDate.toString());

	     
	     
	     int lengthOfaBag = aBag.getCurrentSize();
	     int numOfCovid = 0;
	     int numOfCovidBefore = 0;
	     Date nextMonth;
	     
	     if(currentMonth == 12) {
	    	 nextMonth = new Date(1, currentDay, currentYear+1);
	     }else {
	    	 nextMonth = new Date(currentMonth+1, currentDay, currentYear);
	     }
	     
	     System.out.printf("Next Month Date : %s\n\n",nextMonth.toString());
	     

	     System.out.println( "Employees processed polymorphically:\n" );
	     // generically process each element in array employees
	     for (int index = 0; index < lengthOfaBag;index++) 
	     {
	    	 Employee currentEmployee = aBag.remove();
	    	 bBag.add(currentEmployee);
	    	 Employee currentEmployeeNextMonth = bBag.remove();
	    	 System.out.printf( "Employee %d is a %s\n", index, 
	    			 currentEmployee.getClass().getName() );
	    	 System.out.println( currentEmployee ); // invokes toString

	    	 // determine whether element is a BasePlusCommissionEmployee
	    	 if ( currentEmployee instanceof BasePlusCommissionEmployee ) 
	    	 {
	    		 // downcast Employee reference to 
	    		 // BasePlusCommissionEmployee reference
	    		 BasePlusCommissionEmployee employee = 
	    				 ( BasePlusCommissionEmployee ) currentEmployee;

	    		 double oldBaseSalary = employee.getBaseSalary();
	    		 employee.setBaseSalary( 1.10 * oldBaseSalary );
	    		 System.out.printf( 
	    				 "new base salary with 10%% increase is: $%,.2f\n",
	    				 employee.getBaseSalary() );
	    	 } // end if
	    	 
	    	 
	    	 //get number of covid
	    	 if(currentEmployee.getCovid()) {
	    		 numOfCovid++;
	    	 }
	    	 
	    	 //get number of covid before 2020/4/1
	    	 if ((currentEmployee.getCovid())&&(((currentEmployee.getCovidDate().getYear()<2020))||((currentEmployee.getCovidDate().getYear()==2020&&currentEmployee.getCovidDate().getMonth()<4)))) {
	    		 numOfCovidBefore++;
	    	 }

	    	 // if month of employee's birthday, add $100 to salary
	    	 // if year of hired date over 10, add 10% of salary
	    	 if ( (currentYear - currentEmployee.getHiredDate().getYear()>10)||
	    			 ((currentYear - currentEmployee.getHiredDate().getYear() == 10) && (currentMonth-currentEmployee.getHiredDate().getMonth() > 0))||
	    			 ((currentYear - currentEmployee.getHiredDate().getYear() == 10) && (currentMonth-currentEmployee.getHiredDate().getMonth() == 0)&&(currentDay-currentEmployee.getHiredDate().getDay()>=0)))
	    	 {
	    		 if ( currentMonth == currentEmployee.getBirthDate().getMonth())
	    			 System.out.printf(
	    					 "earned $%,.2f %s %s\n\n", ((currentEmployee.earnings()*4)+100)*1.1, 
	    					 "plus $100.00 birthday bonus","plus 10% of salary bonus" );
	    		 else
	    			 System.out.printf( 
	    					 "earned $%,.2f %s\n\n", currentEmployee.earnings()*4*1.1,"plus 10% of salary bonus" );
	        	  
	    	 }else {
	        	
	    		 if ( currentMonth == currentEmployee.getBirthDate().getMonth())
	    			 System.out.printf(
	    					 "earned $%,.2f %s\n\n", (currentEmployee.earnings()*4)+100, 
	    					 "plus $100.00 birthday bonus");
	    		 else
	    			 System.out.printf( 
	    					 "earned $%,.2f \n\n", currentEmployee.earnings()*4);
	    	 }
	    	 
	    	 System.out.println("next month earning:");
	    	 
	    	 
	    	 if ( (nextMonth.getYear() - currentEmployeeNextMonth.getHiredDate().getYear()>10)||
	    			 ((nextMonth.getYear() - currentEmployeeNextMonth.getHiredDate().getYear() == 10) && (nextMonth.getMonth()-currentEmployeeNextMonth.getHiredDate().getMonth() > 0))||
	    			 ((nextMonth.getYear() - currentEmployeeNextMonth.getHiredDate().getYear() == 10) && (nextMonth.getMonth()-currentEmployeeNextMonth.getHiredDate().getMonth() == 0)&&(nextMonth.getDay()-currentEmployeeNextMonth.getHiredDate().getDay()>=0)))
	    	 {
	    		 if ( nextMonth.getMonth() == currentEmployeeNextMonth.getBirthDate().getMonth())
	    			 System.out.printf(
	    					 "earned $%,.2f %s %s\n\n", ((currentEmployeeNextMonth.earnings()*4)+100)*1.1, 
	    					 "plus $100.00 birthday bonus","plus 10% of salary bonus" );
	    		 else
	    			 System.out.printf( 
	    					 "earned $%,.2f %s\n\n", currentEmployeeNextMonth.earnings()*4*1.1,"plus 10% of salary bonus" );
	        	  
	    	 }else {
	        	
	    		 if ( nextMonth.getMonth() == currentEmployeeNextMonth.getBirthDate().getMonth())
	    			 System.out.printf(
	    					 "earned $%,.2f %s\n\n", (currentEmployeeNextMonth.earnings()*4)+100, 
	    					 "plus $100.00 birthday bonus");
	    		 else
	    			 System.out.printf( 
	    					 "earned $%,.2f \n\n", currentEmployeeNextMonth.earnings()*4);
	    	 }
	    	 
	    	 System.out.println("-------------------------------------------------------------\n");
	         
	         
	     } // end for
	     
	     System.out.printf("number of covid: %d\n",numOfCovid);
	     System.out.printf("number of covid before 2020/4/1: %d\n",numOfCovidBefore);
	     
	} //end main
}