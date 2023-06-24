package me.moon.ticketReservation.performance.entity;

public enum Genre {
    MUSICAL("MUSICAL", "뮤지컬")
    , OPERA("OPERA", "오페라")
    , PLAY("PLAY", "연극")
    , CONCERT("CONCERT", "음악회");
    private String englishName;
    private String koreanName;

    Genre(String englishName, String koreanName) {
        this.englishName = englishName;
        this.koreanName = koreanName;
    }
}
