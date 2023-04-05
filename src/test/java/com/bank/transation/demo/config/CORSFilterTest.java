package com.bank.transation.demo.config;

import com.bank.transation.demo.config.CORSFilter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.mockito.Mockito.*;

class CORSFilterTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private FilterChain filterChain;

    private CORSFilter corsFilter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        corsFilter = new CORSFilter();
    }

    @Test
    void testDoFilter() throws IOException, ServletException {
        corsFilter.doFilter(request, response, filterChain);

        verify(response).setHeader("Access-Control-Allow-Origin", "*");
        verify(response).setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE, PATCH");
        verify(response).setHeader("Access-Control-Max-Age", "3600");
        verify(response).setHeader("Access-Control-Allow-Headers", "Origin, Content-Type, Accept");
        verify(response).setHeader("Access-Control-Expose-Headers", "Location");
        verify(filterChain).doFilter(request, response);
    }
}
