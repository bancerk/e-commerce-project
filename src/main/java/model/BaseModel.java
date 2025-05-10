package model;

import java.time.LocalDateTime;

public class BaseModel {

    private Long id;
    private LocalDateTime createddate;
    private LocalDateTime updateddate;
    private User createdUser;
    private User updatedUser;

    public User getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(User createdUser) {
        this.createdUser = createdUser;
    }

    public User getUpdatedUser() {
        return updatedUser;
    }

    public void setUpdatedUser(User updatedUser) {
        this.updatedUser = updatedUser;
    }

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
