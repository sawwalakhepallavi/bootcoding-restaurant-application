package com.bootcoding.restaurant.service;

import com.bootcoding.restaurant.dao.MenuItemDao;
import com.bootcoding.restaurant.model.MenuItem;
import com.bootcoding.restaurant.model.Vendor;
import com.bootcoding.restaurant.utils.MenuItemGenerator;
import com.bootcoding.restaurant.utils.MenuPriceGenerator;

public class VendorMenuItemService {
    private MenuItemDao menuItemDAO;

    public VendorMenuItemService(){
        menuItemDAO = new MenuItemDao();
    }

    public void createMenuItems(Vendor vendor){
        for(int i = 0; i < 10; i++){
            MenuItem menuItem = new MenuItem();
            menuItem.setMenuItemId(vendor.getVendorId() * 100 + (i+1));
            menuItem.setVendorId(vendor.getVendorId());
            menuItem.setCategory(vendor.getCategory());
            menuItem.setMenuItem(MenuItemGenerator.getMenuItemByVendorCategory(vendor.getCategory()));
            menuItem.setVeg(false); // TODO For you
            menuItem.setPrice(MenuPriceGenerator.getPrice());
            menuItemDAO.insertMenuItemDao(menuItem);
        }
    }

    public void createTable() {
        menuItemDAO.createTable();
    }
}
