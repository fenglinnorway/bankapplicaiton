/**
 * The CORSFilter class is a custom filter that allows Cross-Origin Resource Sharing (CORS).
 * This filter is responsible for adding CORS headers to the HTTP response, enabling
 * client applications hosted on different domains to interact with the server.
 */
package com.bank.transation.demo.config;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CORSFilter implements Filter {

    /**
     * Initializes the CORS filter. This method is empty because no additional
     * configuration
     * is needed for this filter.
     *
     * @param filterConfig the filter configuration object
     * @throws ServletException if an error occurs during filter initialization
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    /**
     * Adds CORS headers to the HTTP response, allowing cross-origin requests from
     * client
     * applications.
     *
     * @param servletRequest  the incoming request
     * @param servletResponse the outgoing response
     * @param filterChain     the filter chain to continue processing the request
     * @throws IOException      if an I/O error occurs during filter processing
     * @throws ServletException if an error occurs during filter processing
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE, PATCH");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Origin, Content-Type, Accept");
        response.setHeader("Access-Control-Expose-Headers", "Location");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    /**
     * Destroys the CORS filter. This method is empty because no additional cleanup
     * is needed for this filter.
     */
    @Override
    public void destroy() {
    }

}
