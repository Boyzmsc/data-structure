// Exercise 10.8 Solution: Employee.java
// Employee abstract superclass.

public abstract class Employee implements Comparable<Employee>
{
   private String firstName;
   private String lastName;
   private int socialSecurityNumber;
   private Date birthDate;
   private Date hiredDate;
   private Date covidDate;
   private boolean covid19;

   // six-argument constructor
   public Employee( String first, String last, int ssn, 
      int month, int day, int year, int hmonth, int hday, int hyear, int cmonth, int cday, int cyear, boolean covid)
   {
      firstName = first;
      lastName = last;
      socialSecurityNumber = ssn;
      birthDate = new Date( month, day, year );
      hiredDate = new Date( hmonth, hday, hyear);
      covidDate = new Date( cmonth, cday, cyear);
      covid19 = covid;
   } // end six-argument Employee constructor
   
   // compare by Social Security Number
   public int compareTo(Employee other) {
	   int result;
	   int a = getSocialSecurityNumber();
	   int b = other.getSocialSecurityNumber();
	   if(a == b) {
		   result = 0;
	   }else if(a < b) {
		   result = -1;
	   }else {
		   result = 1;
	   }
	   return result;
   }

   //set hired day
   public void setHiredDate(int hmonth, int hday, int hyear) {
	   hiredDate = new Date(hmonth,hday,hyear);
   }
   
   //return hired day
   public Date getHiredDate() {
	   return hiredDate;
   }
   
   //set hired day
   public void setCovidDate(int cmonth, int cday, int cyear) {
	   covidDate = new Date(cmonth,cday,cyear);
   }
   
   //return hired day
   public Date getCovidDate() {
	   return covidDate;
   }
   
   //set covid19
   public void setCovid(boolean covid) {
	   covid19 = covid;
   }
   
   //return covid19
   public boolean getCovid() {
	   return covid19;
   }
   // set first name
   public void setFirstName( String first )
   {
      firstName = first;
   } // end method setFirstName

   // return first name
   public String getFirstName()
   {
      return firstName;
   } // end method getFirstName

   // set last name
   public void setLastName( String last )
   {
      lastName = last;
   } // end method setLastName

   // return last name
   public String getLastName()
   {
      return lastName;
   } // end method getLastName

   // set social security number
   public void setSocialSecurityNumber( int ssn )
   {
      socialSecurityNumber = ssn;  // should validate
   } // end method setSocialSecurityNumber

   // return social security number
   public int getSocialSecurityNumber()
   {
      return socialSecurityNumber;
   } // end method getSocialSecurityNumber

   // set birth date
   public void setBirthDate( int month, int day, int year )
   {
      birthDate = new Date( month, day, year );
   } // end method setBirthDate

   // return birth date
   public Date getBirthDate()
   {
      return birthDate;
   } // end method getBirthDate

   
   // return String representation of Employee object
   @Override
   public String toString()
   {
      return String.format( "%s %s\n%s: %d\n%s: %s\n%s: %s\n%s: %s (%b)", 
         getFirstName(), getLastName(), 
         "social security number", getSocialSecurityNumber(), 
         "birth date", getBirthDate(),"hired date", getHiredDate(),"covid date", getCovidDate(),getCovid());
   } // end method toString

   // abstract method overridden by subclasses
   public abstract double earnings();
} // end abstract class Employee

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