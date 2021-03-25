package bg.murval.maintenanceapi.services;

import bg.murval.maintenanceapi.models.PageConfig;
import bg.murval.maintenanceapi.repository.PageConfigRepository;
import org.springframework.stereotype.Service;

@Service
public class PageConfigService {

    private final PageConfigRepository pageConfigRepository;

    public PageConfigService(final PageConfigRepository pageConfigRepository) {
        this.pageConfigRepository = pageConfigRepository;
    }

    public void updateConfig(final PageConfig requestPage) {
        final PageConfig pageConfig = pageConfigRepository.findById(1L).orElse(new PageConfig());

        pageConfig.setId(1);
        final String title = requestPage.getTitle();
        if (title != null) {
            pageConfig.setTitle(title);
        }
        final String description = requestPage.getDescription();
        if (description != null) {
            pageConfig.setDescription(description);
        }

        pageConfigRepository.save(requestPage);
    }

    public void setConfig(final PageConfig requestPage) {
        requestPage.setId(1);
        pageConfigRepository.save(requestPage);
    }

    public PageConfig getPageConfig() {
        return pageConfigRepository.findById(1L).orElse(new PageConfig());
    }
}
