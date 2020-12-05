package com.yangb.project.quickdev.entity;

import javax.persistence.*;

@Table(name = "app_permission")
public class AppPermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "parent_id")
    private Integer parentId;

    @Column(name = "permission_code")
    private String permissionCode;

    private String name;

    private String url;

    private String icon;

    @Column(name = "permission_order")
    private Integer permissionOrder;

    @Column(name = "permission_type")
    private Integer permissionType;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return parent_id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * @return permission_code
     */
    public String getPermissionCode() {
        return permissionCode;
    }

    /**
     * @param permissionCode
     */
    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     * @param icon
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * @return permission_order
     */
    public Integer getPermissionOrder() {
        return permissionOrder;
    }

    /**
     * @param permissionOrder
     */
    public void setPermissionOrder(Integer permissionOrder) {
        this.permissionOrder = permissionOrder;
    }

    /**
     * @return permission_type
     */
    public Integer getPermissionType() {
        return permissionType;
    }

    /**
     * @param permissionType
     */
    public void setPermissionType(Integer permissionType) {
        this.permissionType = permissionType;
    }
}