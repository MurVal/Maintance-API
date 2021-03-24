package bg.murval.maintenanceapi.models;

import bg.murval.maintenanceapi.utils.Status;

public class TaskRequest {
    private String name;
    private String description;
    private Status status;

    public TaskRequest(final String name, final String description, final Status status) {
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(final Status status) {
        this.status = status;
    }
}
