package com.kdg.refactoring.kdgservice.travel.entity;

import java.util.List;

/**
 * @Author 86136
 * @create 2023/12/9 19:28
 */

public class GhImgesInfo extends GhTripDetails{

    private List<String> imgList;

    public List<String> getImgList() {
        return imgList;
    }

    public void setImgList(List<String> imgList) {
        this.imgList = imgList;
    }

}
