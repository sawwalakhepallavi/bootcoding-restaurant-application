package com.bootcoding.restaurant.service;

import com.bootcoding.restaurant.dao.VendorDao;
import com.bootcoding.restaurant.model.Vendor;
import com.bootcoding.restaurant.utils.AddressGenerator;
import com.bootcoding.restaurant.utils.EmailIdGenerator;
import com.bootcoding.restaurant.utils.PhoneNumberGenerator;
import com.bootcoding.restaurant.utils.RestaurantCategoryGenerator;

public class VendorService {
    private VendorDao vendorDAO;
    private VendorMenuItemService menuItemService;

    public VendorService(){
        vendorDAO = new VendorDao();
        menuItemService = new VendorMenuItemService();
        menuItemService.createTable();
    }

    public void createVendors(){
        for(int i = 0; i < 100; i++){
            Vendor vendor = new Vendor();
            vendor.setVendorId(i + 1);
            vendor.setName(RestaurantCategoryGenerator.getName());
            vendor.setAddress(AddressGenerator.getAddress());
            vendor.setEmailId(EmailIdGenerator.
                    getEmailId(vendor.getName()));
            vendor.setCity("Nagpur");
            vendor.setState("Maharashtra");
            vendor.setPhoneNumber(PhoneNumberGenerator.getPhoneNumber());
            vendor.setCategory(RestaurantCategoryGenerator.getCategory(vendor.getName()));

            vendorDAO.insertVendorDao(vendor);

            addMenuItemsOfVendor(vendor);
        }
    }

    public void addMenuItemsOfVendor(Vendor vendor){
        menuItemService.createMenuItems(vendor);
    }

    public void createTable() {
        vendorDAO.createTable();
    }
}
