package model;

import java.time.LocalDateTime;

public class BaseModel {

    private Long id;
    private LocalDateTime createddate;
    private LocalDateTime updateddate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getcreateddate() {
        return createddate;
    }

    public void setcreateddate(LocalDateTime createddate) {
        this.createddate = createddate;
    }

    public LocalDateTime getupdateddate() {
        return updateddate;
    }

    public void setupdateddate(LocalDateTime updateddate) {
        this.updateddate = updateddate;
    }
}
