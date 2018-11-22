package app;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class TestAspect {
    //przed wykonaniem aspektu
    @Before("@annotation(MyAdnontation)" )
    public void before(){
        System.out.println("!!!!!!!!!!!!!!!!!!");
    }
    @After("@annotation(MyAdnontation)")
    public void after(){
        System.out.println("AFTER??????????????");
    }
    @AfterReturning(value = "@annotation(MyAdnontation)",returning = "retValue")
    public void afterReturn(JoinPoint joinPoint,String retValue){
        System.out.println("AFTERRETURN??????????????"+retValue);
    }
    @AfterThrowing(value = "@annotation(MyAdnontation)",throwing ="retValue")
    public void afterThrowing(JoinPoint joinPoint, RuntimeException retValue){
        System.out.println("AFTERThrowing"+retValue.getMessage());
    }

}
