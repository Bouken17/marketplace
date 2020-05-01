package com.project.marketplace.service;

import com.project.marketplace.entity.Provider;
import com.project.marketplace.entity.Speciality;
import org.springframework.stereotype.Service;

@Service
public class ProxyAdmin {
    private final AdminService adminService;
    private Provider provider;
    public ProxyAdmin(AdminService adminService) {
        this.adminService = adminService;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public boolean addProvider(Provider provider) {
        if(this.provider.isAdmin()) {
            Provider provider1= this.adminService.addProvider(provider);
            if(provider1!=null)
                return true;
        }
        return false;
    }

    public boolean blockProduct(long product, long provider) {
        if(this.provider.isAdmin())
            return this.adminService.blockProduct(product, provider);
        return false;
    }

    public boolean blockProvider(long provider) {
        if(this.provider.isAdmin())
            return this.adminService.blockProvider(provider);
        return false;
    }

    public boolean addSpeciality(Speciality speciality) {
        if(this.provider.isAdmin())
            return this.adminService.addSpeciality(speciality);
        return false;
    }

    public boolean deleteSpeciality(long id) {
        if(this.provider.isAdmin())
            return this.adminService.deleteSpeciality(id);
        return false;
    }
}
