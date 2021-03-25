package bg.murval.maintenanceapi.interceptors;

import bg.murval.maintenanceapi.services.AuthService;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.AsyncHandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements AsyncHandlerInterceptor {

    private final AuthService authService;

    public LoginInterceptor(final AuthService authService) {
        this.authService = authService;
    }

    @Override
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler) {
        final HandlerMethod handlerMethod = (HandlerMethod) handler;
        final LoginRequired loginRequired = handlerMethod.getMethod().getAnnotation(LoginRequired.class);
        if (loginRequired == null) {
            return true;
        }

        final String token = request.getHeader("Authorization");
        authService.checkAuth(token);

        return true;
    }


}