package com.kdg.refactoring.kdgservice.travel.entity;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TripData {

    public static class DateArr {
        private String detailId;
        private String title;
        private String money;
        private String traffic;
        private String startCity;
        private String endCity;
        private LocalTime startTime;
        private LocalTime endTime;
        private String description;
        private List<GhImages> imgList;
        private String position;
        private String creatType;
        private String dayTab;
        // Getters and Setters

        public String getDetailId() {
            return detailId;
        }

        public void setDetailId(String detailId) {
            this.detailId = detailId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public String getTraffic() {
            return traffic;
        }

        public void setTraffic(String traffic) {
            this.traffic = traffic;
        }

        public String getStartCity() {
            return startCity;
        }

        public void setStartCity(String startCity) {
            this.startCity = startCity;
        }

        public String getEndCity() {
            return endCity;
        }

        public void setEndCity(String endCity) {
            this.endCity = endCity;
        }

        public LocalTime getStartTime() {
            return startTime;
        }

        public void setStartTime(LocalTime startTime) {
            this.startTime = startTime;
        }

        public LocalTime getEndTime() {
            return endTime;
        }

        public void setEndTime(LocalTime endTime) {
            this.endTime = endTime;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public List<GhImages> getImgList() {
            return imgList;
        }

        public void setImgList(List<GhImages> imgList) {
            this.imgList = imgList;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getCreatType() {
            return creatType;
        }

        public String getDayTab() {
            return dayTab;
        }

        public void setDayTab(String dayTab) {
            this.dayTab = dayTab;
        }

        public void setCreatType(String creatType) {
            this.creatType = creatType;
        }

        // trimSeconds 方法的实现
        public void trimSeconds() {
            this.startTime = this.startTime.withSecond(0);
            this.endTime = this.endTime.withSecond(0);
        }
    }

    public static class MouthData {
        private List<DateArr> dateArr = new ArrayList<>();  // 初始化为一个新的ArrayList

        public List<DateArr> getDateArr() {
            return dateArr;
        }

        public void setDateArr(List<DateArr> dateArr) {
            this.dateArr = dateArr;
        }
    }


    public static class Data {
        private List<MouthData> mouthData;

        public Data() {
            this.mouthData = new ArrayList<>();
        }

        public List<MouthData> getMouthData() {
            return mouthData;
        }

        public void setMouthData(List<MouthData> mouthData) {
            this.mouthData = mouthData;
        }
    }

}
