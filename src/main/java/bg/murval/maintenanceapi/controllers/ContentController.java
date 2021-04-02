package bg.murval.maintenanceapi.controllers;

import bg.murval.maintenanceapi.interceptors.LoginRequired;
import bg.murval.maintenanceapi.models.PageConfig;
import bg.murval.maintenanceapi.services.PageConfigService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/config")
public class ContentController {

    private final PageConfigService configService;

    public ContentController(final PageConfigService configService) {
        this.configService = configService;
    }

    @GetMapping("/")
    @CrossOrigin(origins = "https://maint.amhost.bg")
    public PageConfig getConfig() {
        return configService.getPageConfig();
    }

    @LoginRequired
    @PostMapping("/")
    public void saveConfig(@RequestBody final PageConfig pageConfig) {
        configService.setConfig(pageConfig);
    }

    @LoginRequired
    @PutMapping(path = "/")
    public void updateTask(@RequestBody final PageConfig pageConfig) {
        configService.updateConfig(pageConfig);
    }

}
