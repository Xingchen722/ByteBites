package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "canteens")
public class Canteen {
    @Id
    private String id;

    @Column(nullable = false)
    @NotBlank(message = "餐厅名称不能为空")
    private String name;

    @Column(nullable = false)
    @NotBlank(message = "位置不能为空")
    private String location;

    private String image;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "description_en", columnDefinition = "TEXT")
    private String descriptionEn;

    @Column(name = "description_zh", columnDefinition = "TEXT")
    private String descriptionZh;

    @Column(name = "operating_hours")
    private String operatingHours;

    @Column(nullable = false)
    @DecimalMin(value = "-90.0", message = "纬度范围错误")
    @DecimalMax(value = "90.0", message = "纬度范围错误")
    private Double latitude;

    @Column(nullable = false)
    @DecimalMin(value = "-180.0", message = "经度范围错误")
    @DecimalMax(value = "180.0", message = "经度范围错误")
    private Double longitude;

    // 菜单项目
    @ElementCollection
    @CollectionTable(name = "canteen_menu",
            joinColumns = @JoinColumn(name = "canteen_id"))
    @Column(name = "menu_item")
    private List<String> menu;

    // 餐厅分类
    @ElementCollection
    @CollectionTable(name = "canteen_categories",
            joinColumns = @JoinColumn(name = "canteen_id"))
    @Column(name = "category")
    private List<String> categories;

    // 环境图片
    @ElementCollection
    @CollectionTable(name = "canteen_images",
            joinColumns = @JoinColumn(name = "canteen_id"))
    @Column(name = "image_url")
    private List<String> environmentImages;

    // 公告
    @Column(columnDefinition = "TEXT")
    private String announcement;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // 动态计算的评分（不存储在数据库中）
    @Transient
    private Double rating = 0.0;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    // 构造函数
    public Canteen() {}

    public Canteen(String id, String name, String location, Double latitude, Double longitude) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getDescriptionEn() { return descriptionEn; }
    public void setDescriptionEn(String descriptionEn) { this.descriptionEn = descriptionEn; }

    public String getDescriptionZh() { return descriptionZh; }
    public void setDescriptionZh(String descriptionZh) { this.descriptionZh = descriptionZh; }

    public String getOperatingHours() { return operatingHours; }
    public void setOperatingHours(String operatingHours) { this.operatingHours = operatingHours; }

    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }

    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }

    public List<String> getMenu() { return menu; }
    public void setMenu(List<String> menu) { this.menu = menu; }

    public List<String> getCategories() { return categories; }
    public void setCategories(List<String> categories) { this.categories = categories; }

    public List<String> getEnvironmentImages() { return environmentImages; }
    public void setEnvironmentImages(List<String> environmentImages) {
        this.environmentImages = environmentImages;
    }

    public String getAnnouncement() { return announcement; }
    public void setAnnouncement(String announcement) { this.announcement = announcement; }

    public Double getRating() { return rating; }
    public void setRating(Double rating) { this.rating = rating; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}