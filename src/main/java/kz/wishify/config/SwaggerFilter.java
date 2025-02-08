package kz.wishify.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

@Component
public class SwaggerFilter extends OncePerRequestFilter {

    private static final String TOKEN = "hI3e2roN1icn9toeO%NN!s$%Z";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String requestURI = request.getRequestURI();

        if (requestURI.equals("/swagger-ui/index.html")) {
            String queryString = request.getQueryString();
            if (queryString == null || !queryString.contains("token=" + TOKEN)) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid or missing token");
                return;
            }
        }

        filterChain.doFilter(request, response);
    }
}
