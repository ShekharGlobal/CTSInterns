package com.cts.SpringAopDemo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Aspect class that contains advice for handling banking operations such as 
 * validating PIN before withdrawals, logging after PIN changes, and handling 
 * exceptions when invalid PIN is used.
 * 
 * This class contains several types of advice:
 * - @Before: Executed before the method execution.
 * - @AfterReturning: Executed after the method execution if no exception occurs.
 * - @AfterThrowing: Executed if an exception is thrown in the advised method.
 * - @Around: Allows control over the method execution and can prevent it.
 */
@Aspect
@Component
public class LoginAspect {
    
    private EasyBank easyBank;

    public EasyBank getEasyBank() {
        return easyBank;
    }

    @Autowired
    public void setEasyBank(EasyBank easyBank) {
        this.easyBank = easyBank;
    }

    /**
     * Around advice for validating PIN before executing a withdraw operation.
     * 
     * @param joinPoint the join point representing the method execution
     * @throws Throwable if validation fails or an error occurs
     * 
     * The **Pointcut** here is the execution of the `doWithdraw` method in `EasyBank`. 
     * The **JoinPoint** is the actual invocation of the `doWithdraw` method that 
     * we are intercepting. This allows us to validate the PIN before allowing 
     * the withdrawal operation to proceed. The `joinPoint.proceed()` method 
     * is used to continue with the execution if the validation passes.
     * 
     * The doWithdraw(..) method is called.
2	   @Around advice intercepts the method.
3	   It checks if the entered PIN matches the stored PIN.
4	   If the PIN is incorrect → Throws an exception (withdrawal blocked).
5	   If the PIN is correct → Calls joinPoint.proceed() (withdrawal proceeds).
6	   After withdrawal, prints the remaining balance.

		
		The pointcut is "execution(public void com.cts.SpringAopDemo.EasyBank.doWithdraw(..))".
		A join point is the actual execution of doWithdraw(..).
		
		
		The (..) means that the method can take any number of arguments (including none).
		For example, it will match:
		public void doWithdraw();       // No arguments
		public void doWithdraw(double); // One argument
		public void doWithdraw(int, String); // Multiple arguments
		
		proxy object is created when this @Around advice is applied
		When you call doWithdraw(..), the proxy object intercepts the call and executes validateWithdraw(..) 
		before and after the actual method.
     */
    @Around(value = "execution(public void com.cts.SpringAopDemo.EasyBank.doWithdraw(..))")
    public void validateWithdraw(ProceedingJoinPoint joinPoint) throws Throwable {
        // Validate the entered PIN before proceeding with withdrawal
        if (easyBank.getTempPin() != easyBank.getPinCode()) {
            throw new Exception("Invalid PIN");
        } else {
            // Proceed with the method execution (withdrawal)
            joinPoint.proceed();
            System.out.println("Your remaining balance is " + easyBank.getBalance());
        }
    }
   
    /**
     * Before advice to validate PIN before showing balance or making a deposit.
     * 
     * This **Pointcut** targets the `showBalance` and `doDeposit` methods in 
     * the `EasyBank` class. The **JoinPoint** here represents the actual 
     * execution of these methods, and the advice ensures that a valid PIN 
     * is provided before these operations can proceed.
     */
    @Before("execution(public void com.cts.SpringAopDemo.EasyBank.showBalance(..)) || " +
            "execution(public void com.cts.SpringAopDemo.EasyBank.doDeposit(..))")
    public void validateBalance() {
        if (easyBank.getTempPin() != easyBank.getPinCode()) {
            throw new RuntimeException("Invalid PIN");
        }
    }

    /**
     * After advice that runs when the PIN is successfully changed.
     * 
     * The **Pointcut** expression here is the execution of the `doChangePin` method.
     * The **JoinPoint** represents the actual execution of the `doChangePin` method, 
     * and once it executes successfully, the advice prints a message indicating that 
     * the PIN change was successful.
     */
 @AfterReturning(value = "execution(public void com.cts.SpringAopDemo.EasyBank.doChangePin(..))")
    public void afterPinChange() {
        System.out.println("You have successfully changed your PIN.");
    }

    /**
     * After advice that handles any exception thrown in EasyBank methods.
     * 
     * This **Pointcut** is specified by the `within(com.cts.SpringAopDemo.EasyBank)` 
     * expression, which applies to all methods in the `EasyBank` class. The 
     * **JoinPoint** here represents any execution of a method within `EasyBank` 
     * that throws an exception. If an exception occurs, the advice handles it 
     * and prints an error message.
     */
    @AfterThrowing(value = "within(com.cts.SpringAopDemo.EasyBank)")
    public void afterWrongPin() {
        System.out.println("Invalid PIN entered.");
    }
}
