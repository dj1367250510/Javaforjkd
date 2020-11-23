package com.neusoft.view;

import com.neusoft.domain.Business;

public interface BusinessView {
    public void listAllBusiness();
    public void selectBusiness();
    public void saveBusiness();
    public void removeBusiness();
    public Business login();
    public void showBusiness(Integer businessId);
    public void updateBusiness(Integer businessId);
    public void updatePassword(Integer businessId);
}
