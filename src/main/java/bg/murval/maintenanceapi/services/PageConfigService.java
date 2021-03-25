package bg.murval.maintenanceapi.services;

import bg.murval.maintenanceapi.models.PageConfig;
import bg.murval.maintenanceapi.repository.PageConfigRepository;
import bg.murval.maintenanceapi.utils.Status;
import org.springframework.stereotype.Service;

@Service
public class PageConfigService {

    private final PageConfigRepository pageConfigRepository;

    public PageConfigService(final PageConfigRepository pageConfigRepository) {
        this.pageConfigRepository = pageConfigRepository;
    }

    public void updateConfig(final PageConfig requestPage) {
        final PageConfig pageConfig = getPageConfig();

        final String title = requestPage.getTitle();
        if (title != null) {
            pageConfig.setTitle(title);
        }
        final String description = requestPage.getDescription();
        if (description != null) {
            pageConfig.setDescription(description);
        }
        final Status status = requestPage.getStatus();
        if (status != null) {
            pageConfig.setStatus(status);
        }
        final String pageTitle = requestPage.getPageTitle();
        if (pageTitle != null) {
            pageConfig.setPageTitle(pageTitle);
        }
        pageConfigRepository.save(pageConfig);
    }

    public void setConfig(final PageConfig requestPage) {
        requestPage.setId(1);
        pageConfigRepository.save(requestPage);
    }

    public PageConfig getPageConfig() {
        return pageConfigRepository.findById(1L).orElse(new PageConfig(1L));
    }
}
