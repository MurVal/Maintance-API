package bg.murval.maintenanceapi.configuration;

import bg.murval.maintenanceapi.interceptors.LoginInterceptor;
import bg.murval.maintenanceapi.services.AuthService;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {

    private final AuthService authService;

    public AppConfig(final AuthService authService) {
        this.authService = authService;
    }

    @Override
    public void addInterceptors(final InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor(authService));
    }
} 