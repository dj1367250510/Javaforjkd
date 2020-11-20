package com.neusoft.dao;

import com.neusoft.domain.Admin;
import java.util.List;

public interface AdminDao {
    public Admin getAdminByNameAndPassword(String adminName,String password);
}
