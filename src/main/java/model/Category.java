package model;

public class Category extends BaseModel {

    private String categoryName;

    public Category() {
    }

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public Category(String categoryName, User createdUser, User updatedUser) {
        this.categoryName = categoryName;
        this.setCreatedUser(createdUser);
        this.setUpdatedUser(updatedUser);
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + getId() + '\'' +
                "categoryName=" + categoryName + '\'' +
                '}';
    }
}
