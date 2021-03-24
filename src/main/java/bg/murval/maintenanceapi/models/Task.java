package bg.murval.maintenanceapi.models;

import bg.murval.maintenanceapi.utils.Status;

public class Task extends TaskRequest {
    private final int id;

    public Task(final int id, final String name, final String description, final Status status) {
        super(name, description, status);
        this.id = id;
    }

    public int getId() {
        return id;
    }

}
