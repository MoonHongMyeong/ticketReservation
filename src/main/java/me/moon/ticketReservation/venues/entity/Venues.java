package me.moon.ticketReservation.venues.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Venues {
    private Long id;
    private String name;
    private BuildingType type;
    private String phone;
    private String homepageUrl;
    // 주소는 kakao api 사용 도로명 검색 전제
    private String address_name; //전체 도로명 주소
    private String region_1depth_name;//지역명1
    private String region_2depth_name;//지역명2
    private String region_3depth_name;//지역명3
    private String road_name;//도로명
    private String underground_yn;//지하여부 Y or N
    private String main_building_no;//건물 본번
    private String sub_building_no;//건물 부번
    private String building_name;//건물 이름
    private String zone_no;//우편번호
    private String x;//X좌표, 경도
    private String y;//Y좌표, 위도
}
