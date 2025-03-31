package com.example.project.api.service;

import com.example.project.pharmacy.entity.Pharmacy;
import com.example.project.pharmacy.repository.PharmacyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class PharmacyRepositoryService {
    private final PharmacyRepository pharmacyRepository;

    @Transactional
    public void updateAddress(Long id, String newAddress) {
        Pharmacy pharmacy = pharmacyRepository.findById(id).orElse(null);

        if (Objects.isNull(pharmacy)) {
            log.error("[PharmacyRepositoryService updateAddress] not found id: {}", id);
            return;
        }

        pharmacy.changePharmacyAddress(newAddress);
    }

/*    // Transactional을 붙이지 않았을 때
    public void updateAddressWithoutTransactional(Long id, String newAddress) {
        Pharmacy pharmacy = pharmacyRepository.findById(id).orElse(null);

        if (Objects.isNull(pharmacy)) {
            log.error("[PharmacyRepositoryService updateAddressWithoutTransactional] not found id: {}", id);
            return;
        }

        pharmacy.changePharmacyAddress(newAddress);
    }*/
}
