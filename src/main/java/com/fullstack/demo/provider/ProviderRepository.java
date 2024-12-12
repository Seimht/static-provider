package com.fullstack.demo.provider;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderRepository extends JpaRepository<Provider, Integer> {
    Provider findByEmail(String email);
}
