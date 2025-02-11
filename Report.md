# Report for Payroll Generator

This report helps you demonstrate your understanding of the concepts. You should write this report after you have completed the project. 

## Technical Questions

1. What does CSV stand for? 

   A comma-separated values file.

2. Why would you declare `List<IEmployee>` instead of `ArrayList<HourlyEmployee>`?

    Casuse it's easier to iterate through one list than to iterate through two serparte lists, `ArrayList<HourlyEmployee>` and `ArrayList<SalaryEmployee>`. And once the data is sent to the Builder class, Builder will create different IEmployee objects based on the employee type, so it's not necessary to create two seperate lists.

3. When you have one class referencing another object, such as storing that object as one of the attributes of the first class - what type of relationship is that called (between has-a and is-a)?

    It's a has-a relationship.

4. Can you provide an example of a has-a relationship in your code (if one exists)?

    AbstractEmployee --> PayStub : has a

5. Can you provide an example of an is-a relationship in your code (if one exists)?

    AbstractEmployee <|-- HourlyEmployee : extends
    AbstractEmployee <|-- SalaryEmployee : extends 

6. What is the difference between an interface and an abstract class?

    An interface is like a contract. It is used to specify what a class should do but no details in implementing methods..
    An abstract class is like a manual. It not noly show you what a class should do, but also show you how to implemt methods.

7. What is the advantage of using an interface over an abstract class?

    Interface is more flexiable than Abstract class. Cause a concrete class can implements multiple interfaces, while it can only inherit one abstract class.

8. Is the following code valid or not? `List<int> numbers = new ArrayList<int>();`, explain why or why not. If not, explain how you can fix it. 

    It's not valid. Cause generic types cannot use primitive types. It should be rewritten as `List<Integer> numbers = new ArrayList<Integer>();`

9. Which class/method is described as the "driver" for your application? 

    The main() method in the PayrollGenerator class is the "driver".

10. How do you create a temporary folder for JUnit Testing? 

    First "import org.junit.jupiter.api.io.TempDir", and then use @TempDir annotation in your test code.

## Deeper Thinking 

Salary Inequality is a major issue in the United States. Even in STEM fields, women are often paid less for [entry level positions](https://www.gsb.stanford.edu/insights/whats-behind-pay-gap-stem-jobs). However, not paying equal salary can hurt representation in the field, and looking from a business perspective, can hurt the company's bottom line has diversity improves innovation and innovation drives profits. 

Having heard these facts, your employer would like data about their salaries to ensure that they are paying their employees fairly. While this is often done 'after pay' by employee surveys and feedback, they have the idea that maybe the payroll system can help them ensure that they are paying their employees fairly. They have given you free reign to explore this idea.

Think through the issue / making sure to cite any resources you use to help you better understand the topic. Then write a paragraph on what changes you would need to make to the system. For example, would there be any additional data points you would need to store in the employee file? Why? Consider what point in the payroll process you may want to look at the data, as different people could have different pretax benefits and highlight that. 

The answer to this is mostly open. We ask that you cite at least two sources to show your understanding of the issue. The TAs will also give feedback on your answer, though will be liberal in grading as long as you show a good faith effort to understand the issue and making an effort to think about how your design to could help meet your employer's goals of salary equity. 


According to the Stanford report[^1] provided in the passage above, self-confidence might be the reason why women is paid less than men in entry level positions. And another reason why women is paid less than men might be that women tend not to negotiate a higher salary.[^2] Therefore, what we can do to fix this problem is that we can add a performance point to the employee file and make the base salary align if two employee both have the same position or title. But what's a performance point? A performance point is a way to view your performance and it's given to you by your colleagues. If you perform well in porjects and show your leadership skill more often, your colleagues might give you points. And the more you get, the more confident you will become. Make the base salary align in same position is critical too. This might fix the problem that women tend not to negotiate a higher salary and erase the salary gap. I beleive that implementing these two method would help erasing the salary gap, and we should use them in the runPayroll method in the AbstractEmployee class. First, make sure the base salary is aligned in same position, then compare the performance point between every employee and give them the corresponding amount of salary. After doing this, we then calculate the net pay and taxes. Last, we generate the pay stub.




[^1]: https://www.gsb.stanford.edu/insights/whats-behind-pay-gap-stem-jobs
[^2]: https://ravio.com/blog/3-reasons-why-there-is-a-gender-pay-gap