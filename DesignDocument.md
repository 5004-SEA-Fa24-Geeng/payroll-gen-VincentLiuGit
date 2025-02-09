# Payroll Generator Design Document


This document is meant to provide a tool for you to demonstrate the design process. You need to work on this before you code, and after have a finished product. That way you can compare the changes, and changes in design are normal as you work through a project. It is contrary to popular belief, but we are not perfect our first attempt. We need to iterate on our designs to make them better. This document is a tool to help you do that.


## (INITIAL DESIGN): Class Diagram

Place your class diagram below. Make sure you check the fil in the browser on github.com to make sure it is rendering correctly. If it is not, you will need to fix it. As a reminder, here is a link to tools that can help you create a class diagram: [Class Resources: Class Design Tools](https://github.com/CS5004-khoury-lionelle/Resources?tab=readme-ov-file#uml-design-tools)

```mermaid
---
title: payroll gen UML
---
classDiagram
    direction LR
    Builder --> IEmployee : uses
    Builder --> ITimeCard : uses
    IEmployee --> IPayStub : uses
    PayrollGenerator --> Arguments : has a
    PayrollGenerator --> FileUtil : uses
    PayrollGenerator --> IEmployee : has a
    PayrollGenerator --> ITimeCard : has a    
    PayrollGenerator --> IPayStub : has a  
    class IEmployee {
        <<interface>>
        + getName() : String
        + getID() : String
        + getPayRate() : double
        + getEmployeeType() : String
        + getYTDEarnings() : double
        + getYTDTaxesPaid() : double
        + getPretaxDeductions() : double
        + runPayroll(double hoursWorked) : IPayStub 
    }
    class IPayStub {
        <<interface>>
        + getPay() : double
        + getTaxesPaid() : double
        + toCSV() : String
    }
    class ITimeCard {
        <<interface>>
        + getEmployeeID() : String
        + getHoursWorked() : double
    }        
    class PayrollGenerator {
        - DEFAULT_EMPLOYEE_FILE : String
        - DEFAULT_PAYROLL_FILE : String
        - DEFAULT_TIME_CARD_FILE : String
        - PayrollGenerator()
        + main(String[] args) : void
    }
    class Arguments {
        - employeeFile : String
        - payrollFile : String
        - timeCards : String
        - Arguments()
        + getEmployeeFile() : String
        + getPayrollFile() : String
        + getTimeCards() : String
        + printHelp() : void
        + process(String[] args) : Arguments
    }    
    class Builder {
        - Builder()
        + buildEmployeeFromCSV(String csv) : IEmployee
        + buildTimeCardFromCSV(String csv) : ITimeCard
    }
    class FileUtil {
        + EMPLOYEE_HEADER : String
        + PAY_STUB_HEADER : String
        - FileUtil()
        + readFileToList(String file) : List<String>
        + writeFile(String outFile, List<String> lines) : void
        + writeFile(String outFile, List<String> lines, boolean backup) : void
    }

```



## (INITIAL DESIGN): Tests to Write - Brainstorm

Write a test (in english) that you can picture for the class diagram you have created. This is the brainstorming stage in the TDD process. 

> [!TIP]
> As a reminder, this is the TDD process we are following:
> 1. Figure out a number of tests by brainstorming (this step)
> 2. Write **one** test
> 3. Write **just enough** code to make that test pass
> 4. Refactor/update  as you go along
> 5. Repeat steps 2-4 until you have all the tests passing/fully built program

You should feel free to number your brainstorm. 

1. Test that the `Employee` class properly returns `name` from `getName()`
2. Test that the `Employee` class properly returns `id` from `getId()`
3. continue to add your brainstorm here (you don't need to super formal - this is a brainstorm) - yes, you can change the bullets above to something that fits your design.



## (FINAL DESIGN): Class Diagram

Go through your completed code, and update your class diagram to reflect the final design. Make sure you check the file in the browser on github.com to make sure it is rendering correctly. It is normal that the two diagrams don't match! Rarely (though possible) is your initial design perfect. 

> [!WARNING]
> If you resubmit your assignment for manual grading, this is a section that often needs updating. You should double check with every resubmit to make sure it is up to date.

```mermaid
---
title: payroll gen UML
---
classDiagram
    direction LR
    Builder --> HourlyEmployee : has a
    Builder --> SalaryEmployee : has a
    Builder --> TimeCard : has a
    IEmployee --> IPayStub : has a
    IEmployee <|-- AbstractEmployee : implements
    AbstractEmployee <|-- HourlyEmployee : extends
    AbstractEmployee <|-- SalaryEmployee : extends 
    AbstractEmployee --> TypeOfEmployee : has a       
    AbstractEmployee --> PayStub : has a    
    ITimeCard <|-- TimeCard : implements       
    IPayStub <|-- PayStub : implements   
    PayStub --> IEmployee : has a        
    PayrollGenerator --> Arguments : has a
    PayrollGenerator --> FileUtil : uses
    PayrollGenerator --> IEmployee : has a
    PayrollGenerator --> ITimeCard : has a    
    PayrollGenerator --> IPayStub : has a  
    class IEmployee {
        <<interface>>
        + getName() : String
        + getID() : String
        + getPayRate() : double
        + getEmployeeType() : String
        + getYTDEarnings() : double
        + getYTDTaxesPaid() : double
        + getPretaxDeductions() : double
        + runPayroll(double hoursWorked) : IPayStub 
    }
    class AbstractEmployee {
        <<abstract>>
        + employeeType : TypeOfEmployee
        + employeeName : String
        + employeeId : String
        + payRate : double
        + ytdEarnings : double
        + ytdTaxesPaid : double
        + pretaxDeductions : double
        + AbstractEmployee(TypeOfEmployee employeeType, String employeeName, String employeeId, double payRate, double ytdEarnings, double ytdTaxesPaid, double pretaxDeductions)
        + checkStringValue(String val, String var) : void
        + checkValue(double val, String var) : void
        + getName() : String
        + getID() : String
        + getPayRate() : double
        + getEmployeeType() : String
        + getYTDEarnings() : double
        + getYTDTaxesPaid() : double
        + getPretaxDeductions() : double
        + calculateGrossPay(double hoursWorked) : double
        + roundValue(double val) : double
        + runPayroll(double hoursWorked) : IPayStub
        + toCSV() : String
    }
    class HourlyEmployee {
        + HourlyEmployee(String employeeName, String employeeId, double payRate, double ytdEarnings, double ytdTaxesPaid, double pretaxDeductions)
        + calculateGrossPay(double hoursWorked) : double 
    }
    class SalaryEmployee {
        + SalaryEmployee(String employeeName, String employeeId, double payRate, double ytdEarnings, double ytdTaxesPaid, double pretaxDeductions)
        + calculateGrossPay(double hoursWorked) : double 
    }
    class TypeOfEmployee {
        <<enum>>
        + HOURLY
        + SALARY
    }    
    class IPayStub {
        <<interface>>
        + getPay() : double
        + getTaxesPaid() : double
        + toCSV() : String
    }
    class PayStub {
        + employee : IEmployee
        + netPay : double
        + taxes : double
        + PayStub(IEmployee employee, double netPay, double taxes)
        + getPay() : double
        + getTaxesPaid() : double
        + toCSV() : String
    }
    class ITimeCard {
        <<interface>>
        + getEmployeeID() : String
        + getHoursWorked() : double
    }        
    class TimeCard {
        + employeeId : String
        + hoursWorked : double
        + TimeCard(String employeeId, double hoursWorked)
        + checkStringValue(String val, String var) : void
        + getEmployeeID() : String
        + getHoursWorked() : double
    }         
    class PayrollGenerator {
        - DEFAULT_EMPLOYEE_FILE : String
        - DEFAULT_PAYROLL_FILE : String
        - DEFAULT_TIME_CARD_FILE : String
        - PayrollGenerator()
        + main(String[] args) : void
    }
    class Arguments {
        - employeeFile : String
        - payrollFile : String
        - timeCards : String
        - Arguments()
        + getEmployeeFile() : String
        + getPayrollFile() : String
        + getTimeCards() : String
        + printHelp() : void
        + process(String[] args) : Arguments
    }    
    class Builder {
        - Builder()
        + buildEmployeeFromCSV(String csv) : IEmployee
        + buildTimeCardFromCSV(String csv) : ITimeCard
    }
    class FileUtil {
        + EMPLOYEE_HEADER : String
        + PAY_STUB_HEADER : String
        - FileUtil()
        + readFileToList(String file) : List<String>
        + writeFile(String outFile, List<String> lines) : void
        + writeFile(String outFile, List<String> lines, boolean backup) : void
    }

```


## (FINAL DESIGN): Reflection/Retrospective

> [!IMPORTANT]
> The value of reflective writing has been highly researched and documented within computer science, from learning new information to showing higher salaries in the workplace. For this next part, we encourage you to take time, and truly focus on your retrospective.

Take time to reflect on how your design has changed. Write in *prose* (i.e. do not bullet point your answers - it matters in how our brain processes the information). Make sure to include what were some major changes, and why you made them. What did you learn from this process? What would you do differently next time? What was the most challenging part of this process? For most students, it will be a paragraph or two. 


    When I did my initial design, I did not read the starter code carefully. I just browsed through all the constructers and methods, and draw a UML diagram based on the info I gathered. But when I was writing the test cases, I realized that I needed to add more classes and methods to make the test cases run. As a result, I added an abstract class, AbstractEmployee, to implement the IEMployee interface and 2 classes, HourlyEmployee and SalaryEmployee, to inherit from the AbstractEmployee class. Furthermore, I added 2 more classes, PayStub and TimeCard, to implement the IPayStub and ITimeCard interface, and I created an enum class to store "HOURLY" and "SALARY". 

    During these two weeks, I have been rewirting my classes and test cases a lot. That's because I did not read the the starter code thoroughly. I would spend more time on the starter code during my first glance next time instead of just browse through it. This would give me a better picture of what the starter code try to accompilsh and give me a better perspective to help me design. 
