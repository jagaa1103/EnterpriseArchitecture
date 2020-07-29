package edu.mum.aspect;

import edu.mum.domain.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;


@Aspect
@Component
public class AuctionAspect {

//    @Pointcut("execution(* edu.mum.service..*())")
//    @Pointcut("within(edu.mum.service..*)")
    @Pointcut("within(edu.mum.service..*) && args(user)")
    public void applicationMethod(User user){}

//    @Before("applicationMethod()")
//    public void printMethodName(JoinPoint joinPoint){
//        System.out.println("" + joinPoint.getSignature().getName());
//    }

    @Before("applicationMethod(user)")
    public void logResourceName(JoinPoint joinPoint, User user){
        System.out.println("User: " + user.getFirstName());
    }
}
