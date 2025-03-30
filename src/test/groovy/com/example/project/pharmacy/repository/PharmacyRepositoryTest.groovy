package com.example.project.pharmacy.repository

import com.example.project.AbstractIntegrationContainerBaseTest
import com.example.project.pharmacy.entity.Pharmacy
import org.springframework.beans.factory.annotation.Autowired


class PharmacyRepositoryTest extends AbstractIntegrationContainerBaseTest {

    @Autowired
    private PharmacyRepository pharmacyRepository;

    def setup(){
        pharmacyRepository.deleteAll()
    }

    def "PharmacyRepository save"(){
        given:
        String name = "하늘약국"
        String address = "서울 성북구"
        double latitude = 111.2
        double longitude = 43.2

        def pharmacy = Pharmacy.builder()
            .pharmacyName(name)
            .pharmacyAddress(address)
            .latitude(latitude)
            .longitude(longitude)
            .build()

        when:
        def result = pharmacyRepository.save(pharmacy);

        then:
        result.getPharmacyName() == name
        result.getPharmacyAddress() == address
        result.getLatitude() == latitude
        result.getLongitude() == longitude

    }

    def "PharmacyRepository saveAll 메소드 테스트"(){
        given:
        String name = "땅약국"
        String address = "서울 성북구"
        double latitude = 121.2
        double longitude = 53.2

        def pharmacy = Pharmacy.builder()
                .pharmacyName(name)
                .pharmacyAddress(address)
                .latitude(latitude)
                .longitude(longitude)
                .build()

        when:
        pharmacyRepository.saveAll(Arrays.asList(pharmacy))
        def result = pharmacyRepository.findAll()

        then:
        result.size() == 1
    }
}
