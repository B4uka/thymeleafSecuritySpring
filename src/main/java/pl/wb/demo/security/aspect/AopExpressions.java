package pl.wb.demo.security.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    // setup pointcut declarations  https://www.baeldung.com/spring-aop-pointcut-tutorial
    @Pointcut("execution(* pl.wb.demo.security.controller.*.*(..))")
    private void forControllerPackage() {
    }

    @Pointcut("execution(* pl.wb.demo.security.service.*.*(..))")
    private void forServicePackage() {
    }

    @Pointcut("within(pl.wb.demo.security.dao.*)") //
    private void forDaoPackage() {
    }

    @Pointcut("execution(public void pl.wb.demo.security.service.UserService.save(pl.wb.demo.security.user.CrmUser))")
    public void forSavingNewAccount() {
    }

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    public void forAppFlow() {
    }
}
