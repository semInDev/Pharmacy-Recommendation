package com.example.project.api.service

import com.example.project.AbstractIntegrationContainerBaseTest
import org.springframework.beans.factory.annotation.Autowired

class KakaoAddressSearchServiceTest extends AbstractIntegrationContainerBaseTest {

    @Autowired
    private KakaoAddressSearchService kakaoAddressSearchService

    def "address 파라미터 값이 null이면, requestAddressSearch 메소드는 null을 리턴"() {
        given:
        String address = null

        when:
        def result = kakaoAddressSearchService.requestAddressSearch(address)

        then:
        result == null
    }

    def "주소값이 valid하면, requestAddressSearch 메소드는 document를 리턴"(){
        given:
        def address = "서울 성북구 종암로 10길"

        when:
        def result = kakaoAddressSearchService.requestAddressSearch(address)

        then:

        result.metaDto.totalCount > 0
        // result.addressName.equals(address) // 이렇게 안 됨! KakaoApiResponseDto로 먼저 받아서 쪼개지기 때문에
        // result.documentDtoList.get(0).addressName.equals(address)
        result.documentDtoList.get(0).addressName != null
        result.documentDtoList.size() > 0

    }
}
