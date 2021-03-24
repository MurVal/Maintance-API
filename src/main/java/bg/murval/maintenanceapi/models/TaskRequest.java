package bg.murval.maintenanceapi.models;

import bg.murval.maintenanceapi.utils.Status;

public class TaskRequest {
    private final String name;
    private final String description;
    private final Status status;

    public TaskRequest(final String name, final String description, final Status status) {
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }
}
