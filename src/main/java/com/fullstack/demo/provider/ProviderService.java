package com.fullstack.demo.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProviderService {

    @Autowired
    private ProviderRepository providerRepository;

    public List<Provider> getAllProviders() {
        return providerRepository.findAll();
    }

    public Provider getProviderById(int id) {
        return providerRepository.findById(id).orElse(null);
    }

    public Provider addProvider(Provider provider) {
        return providerRepository.save(provider);
    }

    public Provider updateProvider(int id, Provider updatedProvider) {
        return providerRepository.findById(id)
                .map(provider -> {
                    provider.setName(updatedProvider.getName());
                    provider.setEmail(updatedProvider.getEmail());
                    provider.setPassword(updatedProvider.getPassword());
                    return providerRepository.save(provider);
                }).orElseGet(() -> {
                    updatedProvider.setProviderId(id);
                    return providerRepository.save(updatedProvider);
                });
    }

    public void deleteProvider(int id) {
        providerRepository.deleteById(id);
    }

    public Provider loginProvider(String email, String password) {
        Provider provider = providerRepository.findByEmail(email);
        if (provider != null && provider.getPassword().equals(password)) {
            return provider;
        }
        return null;
    }
}
