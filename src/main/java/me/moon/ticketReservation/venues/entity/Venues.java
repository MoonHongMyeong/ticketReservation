package me.moon.ticketReservation.venues.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.moon.ticketReservation.supplier.entity.Supplier;

@NoArgsConstructor
@Getter
public class Venues {
    private Long id;
    private Long managerId;
    private Supplier manager;
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

    @Builder
    public Venues(Long managerId, String name, BuildingType type, String phone, String homepageUrl, String address_name, String region_1depth_name, String region_2depth_name, String region_3depth_name, String road_name, String underground_yn, String main_building_no, String sub_building_no, String building_name, String zone_no, String x, String y){
        this.managerId = managerId;
        this.name = name;
        this.type = type;
        this.phone = phone;
        this.homepageUrl = homepageUrl;
        this.address_name = address_name;
        this.region_1depth_name = region_1depth_name;
        this.region_2depth_name = region_2depth_name;
        this.region_3depth_name = region_3depth_name;
        this.road_name = road_name;
        this.underground_yn = underground_yn;
        this.main_building_no = main_building_no;
        this.sub_building_no = sub_building_no;
        this.building_name = building_name;
        this.zone_no = zone_no;
        this.x = x;
        this.y = y;
    }
}
