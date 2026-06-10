# Report for Payroll Generator

This report helps you demonstrate your understanding of the concepts. You should write this report after you have completed the project. 

## Technical Questions

1. What does CSV stand for? 
   Comma-Separated Value. It is a file format which stores data records. Each text field is separated by ",".

2. Why would you declare `List<IEmployee>` instead of `ArrayList<HourlyEmployee>`?
    Declaring IEmployee interface allows the object to store any class that implements the IEmployee
interface. It accepts both HourlyEmployee and SalaryEmployee. However, declaring the object to be ArrayList<HourlyEmployee>
means that the object cannot accepts SalaryEmployee. In addition, declaring List which is an interface instead of ArrayList which is a concrete class
allows future implementation more flexible.

3. When you have one class referencing another object, such as storing that object as one of the attributes of the first class - what type of relationship is that called (between has-a and is-a)?
    has-a

4. Can you provide an example of a has-a relationship in your code (if one exists)?
   private IEmployee employee mentioned in instructions

5. Can you provide an example of an is-a relationship in your code (if one exists)?
    HourlyEmployee is-a AbstractEmployee.

6. What is the difference between an interface and an abstract class?
    interface has method signature. Abstract class can have fields, constructors, abstract method and concrete method.
    Interface can be implemented by abstract class.

7. What is the advantage of using an interface over an abstract class?
    A class can implements multiple interface, but it can only extend one abstract class.

8. Is the following code valid or not? `List<int> numbers = new ArrayList<int>();`, explain why or why not. If not, explain how you can fix it. 
    <> cannot accept primitive type. List<Integer> numbers = new ArrayList<Integer>();

9. Which class/method is described as the "driver" for your application? 
    PayrollGenerator class and its main() method.


10. How do you create a temporary folder for JUnit Testing?
    @TempDir
    static Path tempDir;

## Deeper Thinking 

Salary Inequality is a major issue in the United States. Even in STEM fields, women are often paid less for [entry level positions](https://www.gsb.stanford.edu/insights/whats-behind-pay-gap-stem-jobs). However, not paying equal salary can hurt representation in the field, and looking from a business perspective, can hurt the company's bottom line has diversity improves innovation and innovation drives profits. 

Having heard these facts, your employer would like data about their salaries to ensure that they are paying their employees fairly. While this is often done 'after pay' by employee surveys and feedback, they have the idea that maybe the payroll system can help them ensure that they are paying their employees fairly. They have given you free reign to explore this idea.

Think through the issue / making sure to cite any resources you use to help you better understand the topic. Then write a paragraph on what changes you would need to make to the system. For example, would there be any additional data points you would need to store in the employee file? Why? Consider what point in the payroll process you may want to look at the data, as different people could have different pretax benefits and highlight that. 

The answer to this is mostly open. We ask that you cite at least two sources to show your understanding of the issue. The TAs will also give feedback on your answer, though will be liberal in grading as long as you show a good faith effort to understand the issue and making an effort to think about how your design to could help meet your employer's goals of salary equity. 

Pay disparities have been studied over the past century. One of the major factors is the gender wage gap. According to the Economic Policy Institute, the gender wage gap widened slightly in 2025. Women are earning approximately 18.6% less than men on average(Gould & Kandra, 2025). Research has also shown that women receive less pay than men even after controlling for variables such as educational background and work experience (Wingfield, 2025). This gap can be further amplified by ethnicity, marital status, nature of industry sector and many other factors. Thus, investigating whether pay inequality exists in a company requires more classification information. The employee file would need to store additional categorical data such as gender, ethnicity, education background, job level, employment type (full-time or part-time), and department.

Before calling the runPayroll() method, an additional method should be introduced. Since different employees may have different pretax deductions, gross pay should be used as the basis for comparison. The average gross pay among employees of the same department and job level should be calculated. Each employee's gross pay is then compared to this average. If the pay deviates from the mean by a certain threshold, such as 2 standard deviations, it would be denoted as an outlier. The method could then return a string variable such as "UNDERPAY" or "OVERPAY" to alert the company for further review.


Citations:
Cohn, E. and Gould, E. (2026) The gender pay gap widened slightly in 2025: How trump’s first year in office hurt women and what states can do to fix it. Available at: https://www.epi.org/blog/the-gender-pay-gap-widened-slightly-in-2025-how-trumps-first-year-in-office-hurt-women-and-what-states-can-do-to-fix-it/ (Accessed: 08 June 2026).
Wingfield, A.H. (2025) The gender wage gap is widening again-can our policies explain why?, Forbes. Available at: https://www.forbes.com/sites/adiaharveywingfield/2025/10/29/the-gender-wage-gap-is-widening-again-can-our-policies-explain-why/ (Accessed: 08 June 2026). 