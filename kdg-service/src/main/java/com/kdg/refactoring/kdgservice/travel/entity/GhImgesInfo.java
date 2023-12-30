package com.kdg.refactoring.kdgservice.travel.entity;

import java.util.List;

/**
 * @Author 86136
 * @create 2023/12/9 19:28
 */

public class GhImgesInfo extends GhTripDetails{

    private List<GhImages> imgList;

    public List<GhImages> getImgList() {
        return imgList;
    }

    public void setImgList(List<GhImages> imgList) {
        this.imgList = imgList;
    }

}
