// Exercise 10.8 Solution: PayrollSystemTest.java
// Employee hierarchy test program.
import java.util.Scanner; // program uses Scanner to obtain user input

public class PayrollSystemTest 
{
   public static void main( String[] args ) 
   {
      // create subclass objects
      SalariedEmployee salariedEmployee = 
         new SalariedEmployee( 
         "John", "Smith", "111-11-1111", 1, 15, 1944, 2,1,2000, 400.00 );
      SalariedEmployee salariedEmployee1 = 
    	         new SalariedEmployee( 
    	         "Sam", "Kim", "111-12-3411", 2, 15, 1947, 4,17,2001, 600.00 );
      SalariedEmployee salariedEmployee2 = 
    	         new SalariedEmployee( 
    	         "Dan", "David", "351-13-1251", 3, 25, 1954, 4,7,2002, 800.00 );
      HourlyEmployee hourlyEmployee = 
         new HourlyEmployee( 
         "Karen", "Price", "222-22-2222", 4, 29, 1960,3,6,2003 ,12.75, 40 );
      HourlyEmployee hourlyEmployee1 = 
    	         new HourlyEmployee( 
    	         "Lim", "Deep", "462-22-2522", 5, 29, 1940,2,6,2004 ,14.75, 40 );
      HourlyEmployee hourlyEmployee2 = 
    	         new HourlyEmployee( 
    	         "Koo", "Cold", "364-23-2352", 6, 29, 1960,3,6,2005 ,16.75, 40 );
      CommissionEmployee commissionEmployee = 
         new CommissionEmployee( 
         "Sue", "Jones", "333-33-3333", 7, 8, 1954,7,3,2006, 5000, .06 );
      CommissionEmployee commissionEmployee1 = 
    	         new CommissionEmployee( 
    	         "Soo", "Kim", "333-33-1113", 8, 8, 1954,7,3,2007, 10000, .06 );
      
      BasePlusCommissionEmployee basePlusCommissionEmployee = 
         new BasePlusCommissionEmployee( 
         "Bob", "Lewis", "444-44-4444", 9, 2, 1965,8,24,2008, 5000, .03, 400 );
      BasePlusCommissionEmployee basePlusCommissionEmployee1 = 
    	         new BasePlusCommissionEmployee( 
    	         "Moon", "King", "263-34-2984", 10, 2, 1965,8,24,2009, 10000, .04, 300 );

      System.out.println( "Employees processed individually:\n" );
      
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

      // create four-element Employee array
      Employee[] employees = new Employee[ 10 ]; 

      // initialize array with Employees
      employees[ 0 ] = salariedEmployee;
      employees[ 1 ] = salariedEmployee1;
      employees[ 2 ] = salariedEmployee2;
      employees[ 3 ] = hourlyEmployee;
      employees[ 4 ] = hourlyEmployee1;
      employees[ 5 ] = hourlyEmployee2;
      employees[ 6 ] = commissionEmployee;
      employees[ 7 ] = commissionEmployee1; 
      employees[ 8 ] = basePlusCommissionEmployee;
      employees[ 9 ] = basePlusCommissionEmployee1;
      

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

      System.out.println( "Employees processed polymorphically:\n" );
      
      // generically process each element in array employees
      for ( Employee currentEmployee : employees ) 
      {
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
         
         
      } // end for

      // get type name of each object in employees array
      for ( int j = 0; j < employees.length; j++ )
         System.out.printf( "Employee %d is a %s\n", j, 
            employees[ j ].getClass().getName() ); 
   } // end main
} // end class PayrollSystemTest

/**************************************************************************
 * (C) Copyright 1992-2010 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
