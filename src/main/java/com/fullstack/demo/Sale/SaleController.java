package com.fullstack.demo.Sale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping("/all")
    public String getAllSales(Model model) {
        model.addAttribute("saleList", saleService.getAllSales());
        return "Sale-list";
    }

    @GetMapping("/view/{id}")
    public String viewSale(@PathVariable("id") Long id, Model model) {
        Sale sale = saleService.getSaleById(id);
        model.addAttribute("sale", sale);
        return "Sale-details";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Sale sale = saleService.getSaleById(id);
        model.addAttribute("sale", sale);
        return "Sale-update";
    }

    @GetMapping("/new")
    public String showCreateSaleForm(Model model) {
        model.addAttribute("sale", new Sale());  // Add an empty Sale object
        return "Sale-create";
    }

    @PostMapping("/new")
    public String addSale(@ModelAttribute Sale sale) {
        saleService.addSale(sale);
        return "redirect:/api/sales/all";
    }

    @PostMapping("/update")
    public String updateSale(@ModelAttribute Sale sale) {
        saleService.updateSale(sale.getSaleId(), sale);
        return "redirect:/api/sales/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteSale(@PathVariable("id") Long id) {
        saleService.deleteSale(id);
        return "redirect:/api/sales/all";
    }

    // New Endpoint for Statistics
    @GetMapping("/statistics")
    public String getSalesStatistics(Model model) {
        model.addAttribute("totalRevenue", saleService.getTotalRevenue());
        model.addAttribute("totalSalesCount", saleService.getTotalSalesCount());
        model.addAttribute("averageSaleValue", saleService.getAverageSaleValue());
        model.addAttribute("salesPerProduct", saleService.getSalesPerProduct());
        return "Sales-statistics";
    }
}
