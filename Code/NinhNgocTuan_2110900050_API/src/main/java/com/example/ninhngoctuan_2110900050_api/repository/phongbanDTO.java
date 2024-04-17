package com.example.ninhngoctuan_2110900050_api;

import lombok.Getter;

public class phongbanDTO {
    @Getter
    private Integer mapb;
    @Getter
    private String tenpb;
    @Getter
    private String truongphong;
    private Boolean isDeleted;

    public void setMapb(Integer mapb) {
        this.mapb = mapb;
    }

    public void setTenpb(String tenpb) {
        this.tenpb = tenpb;
    }

    public void setTruongphong(String truongphong) {
        this.truongphong = truongphong;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}
