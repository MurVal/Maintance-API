package bg.murval.maintenanceapi.services;

import bg.murval.maintenanceapi.exceptions.AuthException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class AuthService {

    @Value("Bearer ${web.token:123}")
    private String authToken;

    public void checkAuth(String token) {
        if (!StringUtils.hasText(token) || !token.equals(authToken)) {
            throw new AuthException();
        }
    }
}
