package com.neusoft.domain;

public class Admin {
    private Integer adminId;
    private Integer adminName;
    private String password;
    public Admin() {

    }
    public Admin(Integer adminId, Integer adminName, String password) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.password = password;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Integer getAdminName() {
        return adminName;
    }

    public void setAdminName(Integer adminName) {
        this.adminName = adminName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", adminName=" + adminName +
                ", password='" + password + '\'' +
                '}';
    }
}
