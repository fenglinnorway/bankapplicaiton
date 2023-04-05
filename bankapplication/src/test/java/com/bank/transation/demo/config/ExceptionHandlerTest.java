package com.bank.transation.demo.config;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class ExceptionHandlerTest {

    @Test
    void testExceptionHandlerForNullPointerException() {
        // Given a NullPointerException is thrown
        NullPointerException ex = new NullPointerException();

        // When exceptionHandler method is called
        ResponseEntity<ExceptionResponse> responseEntity = ExceptionHandler.exceptionHandler(ex);

        // Then the status code should be BAD_REQUEST
        assertThat(responseEntity.getStatusCode(), is(HttpStatus.BAD_REQUEST));

        // And the response body message should be "Issue during Processing request,
        // Please contact Application team"
        assertThat(responseEntity.getBody().getMessage(),
                is(ExceptionHandler.ISSUE_DURING_PROCESSING_REQUEST_PLEASE_CONTACT_APPLICATION_TEAM));
    }

    @Test
    void testExceptionHandlerForIllegalAccessException() {
        // Given an IllegalAccessException is thrown
        IllegalAccessException ex = new IllegalAccessException();

        // When exceptionHandler method is called
        ResponseEntity<ExceptionResponse> responseEntity = ExceptionHandler.exceptionHandler(ex);

        // Then the status code should be FORBIDDEN
        assertThat(responseEntity.getStatusCode(), is(HttpStatus.FORBIDDEN));

        // And the response body message should be "Access issue, please contact
        // Application team"
        assertThat(responseEntity.getBody().getMessage(), is("Access issue, please contact Application team"));
    }

    @Test
    void testExceptionHandlerForRuntimeException() {
        // Given a RuntimeException is thrown
        RuntimeException ex = new RuntimeException();

        // When exceptionHandler method is called
        ResponseEntity<ExceptionResponse> responseEntity = ExceptionHandler.exceptionHandler(ex);

        // Then the status code should be INTERNAL_SERVER_ERROR
        assertThat(responseEntity.getStatusCode(), is(HttpStatus.INTERNAL_SERVER_ERROR));

        // And the response body message should be "Issue during Processing request,
        // Please contact Application team"
        assertThat(responseEntity.getBody().getMessage(),
                is(ExceptionHandler.ISSUE_DURING_PROCESSING_REQUEST_PLEASE_CONTACT_APPLICATION_TEAM));
    }

    @Test
    void testExceptionHandlerForException() {
        // Given an Exception is thrown
        Exception ex = new Exception();

        // When exceptionHandler method is called
        ResponseEntity<ExceptionResponse> responseEntity = ExceptionHandler.exceptionHandler(ex);

        // Then the status code should be INTERNAL_SERVER_ERROR
        assertThat(responseEntity.getStatusCode(), is(HttpStatus.INTERNAL_SERVER_ERROR));

        // And the response body message should be "Issue during Processing request,
        // Please contact Application team"
        assertThat(responseEntity.getBody().getMessage(),
                is(ExceptionHandler.ISSUE_DURING_PROCESSING_REQUEST_PLEASE_CONTACT_APPLICATION_TEAM));
    }
}
