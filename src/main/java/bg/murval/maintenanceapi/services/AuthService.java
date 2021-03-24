package bg.murval.maintenanceapi.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class AuthService {

    @Value("Bearer ${web.token}")
    private String authToken;

    public void checkAuth(String token){

        if (!StringUtils.hasText(token) || !token.equals(authToken)) {
            throw new RuntimeException("Invalid Token");
        }
    }
}
