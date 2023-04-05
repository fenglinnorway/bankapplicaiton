package com.bank.transation.demo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * The {@code LoggerAspect} class is an aspect in the
 * {@code com.bank.transation.demo.aop} package.
 * This aspect is intended to be used with AspectJ and Spring AOP to implement
 * logging behavior
 * in your application.
 *
 * <p>
 * Use this aspect to define pointcuts, advices, and other aspects-related
 * constructs that
 * correspond to the desired logging behavior. You can use the custom
 * annotations {@code @LogObjectBefore}
 * and {@code @LogObjectAfter} to mark the methods or types where the logging
 * should be executed
 * before or after the target method execution.
 * </p>
 *
 * <p>
 * To enable this aspect in a Spring Boot application, make sure to include the
 * {@code spring-boot-starter-aop}
 * dependency in your project and configure the {@code @EnableAspectJAutoProxy}
 * annotation in one of your
 * configuration classes.
 * </p>
 */
@Slf4j
@Aspect
@Component
public class LoggerAspect {

}
