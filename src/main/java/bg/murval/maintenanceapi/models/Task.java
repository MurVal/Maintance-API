package bg.murval.maintenanceapi.models;

import bg.murval.maintenanceapi.utils.Status;

public class Task extends TaskRequest {
    private final long id;

    public Task(final long id, final String name, final String description, final Status status) {
        super(name, description, status);
        this.id = id;
    }

    public long getId() {
        return id;
    }

}
