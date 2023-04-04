package com.bank.transation.demo.config;

/**
 * The {@code CustomException} class is a custom exception class in the
 * {@code com.bank.transation.demo.config} package. It extends the
 * {@code Exception}
 * class and provides additional constructors to allow for more flexible
 * instantiation
 * of exception objects with custom messages and causes.
 *
 * <p>
 * Usage:
 * </p>
 * 
 * <pre>
 * {@code
 * try {
 *     // some code that might throw an exception
 * } catch (Exception e) {
 *     throw new CustomException("Custom error message", e);
 * }
 * }
 * </pre>
 *
 * <p>
 * Constructors:
 * </p>
 * <ul>
 * <li>{@code CustomException()}: Default constructor with no message or
 * cause.</li>
 * <li>{@code CustomException(String message)}: Constructor with a custom
 * message.</li>
 * <li>{@code CustomException(Throwable reason)}: Constructor with a cause.</li>
 * <li>{@code CustomException(String message, Throwable reason)}: Constructor
 * with a custom message and a cause.</li>
 * <li>{@code CustomException(String message, Throwable reason, boolean isSuppressed, boolean writableStackTrace)}:
 * Constructor with a custom message, a cause, and flags for suppression and
 * stack trace writability.</li>
 * </ul>
 */
public class CustomException extends Exception {

    public CustomException() {
        super();
    }

    public CustomException(String message) {
        super(message);
    }

    public CustomException(Throwable reason) {
        super(reason);
    }

    public CustomException(String message, Throwable reason) {
        super(message, reason);
    }

    public CustomException(String message, Throwable reason, boolean isSuppressed, boolean writableStackTrace) {
        super(message, reason, isSuppressed, writableStackTrace);
    }
}
