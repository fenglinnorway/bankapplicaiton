package com.bank.transation.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The {@code LogObjectBefore} annotation is a custom annotation designed to be
 * applied to methods and types (classes and interfaces) in Java applications.
 * When used in conjunction with an aspect or an interceptor, this annotation
 * can
 * be used to indicate that specific logging behavior should be executed before
 * the annotated method is called or the annotated type is instantiated.
 *
 * <p>
 * Usage:
 * </p>
 * 
 * <pre>
 * {@code
 * \@LogObjectBefore
 * public class MyClass {
 *     // class implementation
 * }
 *
 * \@LogObjectBefore
 * public void myMethod() {
 *     // method implementation
 * }
 * }
 * </pre>
 *
 * <p>
 * Components:
 * </p>
 * <ul>
 * <li>{@code @Retention(RetentionPolicy.RUNTIME)}: Specifies the retention
 * policy of the annotation. With {@code RUNTIME} retention, the annotation is
 * available at runtime through Java Reflection.</li>
 * <li>{@code @Target({ElementType.METHOD, ElementType.TYPE})}: Defines the
 * target elements of the annotation. It indicates that the annotation can be
 * applied to both methods and types (classes and interfaces).</li>
 * </ul>
 *
 * <p>
 * Note:
 * </p>
 * <p>
 * The {@code LogObjectBefore} annotation itself does not provide the logging
 * functionality.
 * You must implement an aspect or an interceptor that processes this annotation
 * and performs
 * the desired logging action. This can be done using AspectJ, Spring AOP, or
 * other AOP frameworks in Java.
 * </p>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.TYPE })
public @interface LogObjectBefore {
}
