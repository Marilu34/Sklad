package topragservice.store.Sklad.token;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Component
//public class TokenFilter extends OncePerRequestFilter {
//
//    @Autowired
//    private TokenProvider tokenProvider;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//            throws ServletException, IOException {
//        String token = tokenProvider.resolveToken(request);
//
//        if (token != null && tokenProvider.validateToken(token)) {
//            Authentication authentication = tokenProvider.getAuthentication(token);
//            if (authentication != null) {
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//            }
//        }
//
//        filterChain.doFilter(request, response);
//    }
//}
