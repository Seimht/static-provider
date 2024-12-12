package com.fullstack.demo.Sale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }

    public Sale getSaleById(Long id) {
        return saleRepository.findById(id).orElse(null);
    }

    public Sale addSale(Sale sale) {
        return saleRepository.save(sale);
    }

    public Sale updateSale(Long saleId, Sale updatedSale) {
        return saleRepository.findById(saleId)
                .map(sale -> {
                    sale.setProductId(updatedSale.getProductId());
                    sale.setQuantity(updatedSale.getQuantity());
                    sale.setTotal(updatedSale.getTotal());
                    sale.setDate(updatedSale.getDate());
                    return saleRepository.save(sale);
                })
                .orElseGet(() -> {
                    updatedSale.setSaleId(saleId);
                    return saleRepository.save(updatedSale);
                });
    }

    public void deleteSale(Long id) {
        saleRepository.deleteById(id);
    }

    // New Statistics Methods
    public double getTotalRevenue() {
        return saleRepository.findAll()
                .stream()
                .mapToDouble(Sale::getTotal)
                .sum();
    }

    public long getTotalSalesCount() {
        return saleRepository.count();
    }

    public double getAverageSaleValue() {
        List<Sale> sales = saleRepository.findAll();
        return sales.isEmpty() ? 0 : sales.stream().mapToDouble(Sale::getTotal).average().orElse(0);
    }

    public Map<Long, Long> getSalesPerProduct() {
        return saleRepository.findAll()
                .stream()
                .collect(Collectors.groupingBy(Sale::getProductId, Collectors.counting()));
    }
}
