package com.kdg.refactoring.kdgservice.travel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kdg.refactoring.kdgservice.picgo.minio.util.MinioUtils;
import com.kdg.refactoring.kdgservice.travel.entity.GhImages;
import com.kdg.refactoring.kdgservice.travel.entity.GhImgesInfo;
import com.kdg.refactoring.kdgservice.travel.entity.TripData.Data;
import com.kdg.refactoring.kdgservice.travel.entity.TripData.DateArr;
import com.kdg.refactoring.kdgservice.travel.entity.TripData.MouthData;
import com.kdg.refactoring.kdgservice.travel.mapper.GhImagesMapper;
import com.kdg.refactoring.kdgservice.travel.mapper.GhTripDetailsMapper;
import com.kdg.refactoring.kdgservice.travel.entity.GhTripDetails;
import com.kdg.refactoring.kdgservice.travel.service.GhImagesService;
import com.kdg.refactoring.kdgservice.travel.service.GhTripDetailsService;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用于存储每个元素的详细信息(GhTripDetails)表服务实现类
 *
 * @author couei
 * @since 2023-12-08 01:09:04
 */
@Service("ghTripDetailsService")
public class GhTripDetailsServiceImpl extends
    ServiceImpl<GhTripDetailsMapper, GhTripDetails> implements GhTripDetailsService {

    @Autowired
    private GhTripDetailsMapper ghTripDetailsMapper;

    @Autowired
    private GhImagesMapper ghImagesMapper;

    @Autowired
    private GhTripDetailsService ghTripDetailsService;
    @Autowired
    private GhImagesService ghImagesService;

    @Autowired
    private MinioUtils minioUtils;

    // 重写接口方法
    @Override
    public List<Data> selectTripList(GhTripDetails ghTripDetails) {
        // 使用 MyBatis Plus 的 QueryWrapper 进行条件查询
        QueryWrapper<GhTripDetails> queryWrapper = new QueryWrapper<>(ghTripDetails);
        queryWrapper.eq("day_tab", ghTripDetails.getDayTab());
        queryWrapper.orderByAsc("start_time");
        List<GhTripDetails> tripList = ghTripDetailsMapper.selectList(queryWrapper);

        List<Data> dataList = new ArrayList<>();

        for (GhTripDetails tripDetails : tripList) {
            // 创建一个新的 Data 对象
            Data data = new Data();
            data.setMouthData(new ArrayList<>());

            // 创建一个新的 MouthData 对象
            MouthData mouthData = new MouthData();
            mouthData.setDateArr(new ArrayList<>());  // 初始化 dateArr 列表

            // 创建一个新的 DateArr 对象
            DateArr dateArr = new DateArr();

            // 将 GhTripDetails 的属性赋值给 DateArr
            if (tripDetails.getDayId() != null) {
                convertToDataArr(tripDetails, dateArr);
                // 将 DateArr 添加到 MouthData 中的 dateArr 列表
                mouthData.getDateArr().add(dateArr);

                // 将 MouthData 直接添加到 Data 中的 mouthData 列表
                data.getMouthData().add(mouthData);

                // 将 Data 直接添加到 Data 列表
                dataList.add(data);
            }
        }

        return dataList;
    }

    /**
     * 添加行程详情
     *
     * @param ghTripDetails
     * @return
     */
    @Override
    public boolean addDetailsInfo(GhImgesInfo ghTripDetails) {
        GhTripDetails details = new GhTripDetails();
        details.setDetailId(ghTripDetails.getDetailId());
        details.setTitle(ghTripDetails.getTitle());
        details.setDescription(ghTripDetails.getDescription());
        details.setMoney(ghTripDetails.getMoney());
        details.setStartCity(ghTripDetails.getStartCity());
        details.setEndCity(ghTripDetails.getEndCity());
        details.setStartTime(ghTripDetails.getStartTime());
        details.setEndTime(ghTripDetails.getEndTime());
        details.setPosition(ghTripDetails.getPosition());
        details.setTraffic(ghTripDetails.getTraffic());
        details.setCreatType(ghTripDetails.getCreatType());
        details.setDayId(ghTripDetails.getDayId());
        details.setDayTab(ghTripDetails.getDayTab());
        // 保存行程详情
        boolean saveDetails = ghTripDetailsService.save(details);

        String detailId = details.getDetailId();

        // 添加图片
        List<GhImages> imgList = ghTripDetails.getImgList();
        if (imgList != null && !imgList.isEmpty()) {
            // 使用 stream 进行遍历，并将每个图片信息设置为对应的 detailId 后保存
            for (GhImages images : imgList) {
                GhImages ghImages = new GhImages();
                ghImages.setImageId(UUID.randomUUID().toString());
                ghImages.setDetailId(detailId);
                ghImages.setUrl(images.getUrl());
                ghImages.setFileName(images.getFileName());
                ghImagesService.save(ghImages);
            }
            // 如果保存图片成功，返回 true；否则返回 false
        }
        return saveDetails;
    }

    @Override
    public boolean updDetailsInfo(GhImgesInfo ghTripDetails) {
        GhTripDetails details = new GhTripDetails();
        details.setDetailId(ghTripDetails.getDetailId());
        details.setTitle(ghTripDetails.getTitle());
        details.setDescription(ghTripDetails.getDescription());
        details.setMoney(ghTripDetails.getMoney());
        details.setStartCity(ghTripDetails.getStartCity());
        details.setEndCity(ghTripDetails.getEndCity());
        details.setStartTime(ghTripDetails.getStartTime());
        details.setEndTime(ghTripDetails.getEndTime());
        details.setPosition(ghTripDetails.getPosition());
        details.setTraffic(ghTripDetails.getTraffic());
        details.setCreatType(ghTripDetails.getCreatType());
        details.setDayId(ghTripDetails.getDayId());
        details.setDayTab(ghTripDetails.getDayTab());
        // 保存行程详情
        boolean updDetails = ghTripDetailsService.updateById(details);

        String detailId = details.getDetailId();
        List<GhImages> imagesList = ghImagesService.getImgList(detailId);
        //查出和规划关联的图片

        // 添加图片
        List<GhImages> imgList = ghTripDetails.getImgList();
        if (imgList != null && !imgList.isEmpty()) {
            // 将每个图片信息设置为对应的 detailId 后保存
            for (GhImages images : imgList) {
                GhImages ghImages = new GhImages();
                ghImages.setImageId(UUID.randomUUID().toString());
                ghImages.setDetailId(detailId);
                ghImages.setUrl(images.getUrl());
                ghImages.setFileName(images.getFileName());
                ghImagesService.save(ghImages);
            }
            // 如果保存图片成功，返回 true；否则返回 false
        }
        return updDetails;
    }

    @Override
    public GhImgesInfo getOne(String detailId, String dayTab) {
        return ghTripDetailsMapper.getOne(detailId, dayTab);
    }

    /**
     * 实现 GhTripDetails 到 DateArr 的转换
     *
     * @param tripDetails
     * @param dateArr
     */
    private void convertToDataArr(GhTripDetails tripDetails, DateArr dateArr) {
        // 将 GhTripDetails 的属性赋值给 DateArr
        dateArr.setDetailId(tripDetails.getDetailId());
        dateArr.setTitle(tripDetails.getTitle());
        dateArr.setMoney(String.valueOf(tripDetails.getMoney()));
        dateArr.setTraffic(tripDetails.getTraffic());
        dateArr.setStartCity(tripDetails.getStartCity());
        dateArr.setEndCity(tripDetails.getEndCity());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        dateArr.setStartTime(
            Optional.ofNullable(tripDetails.getStartTime())
                .map(time -> LocalTime.parse(time.format(formatter), formatter))
                .orElse(null)
        );

        dateArr.setEndTime(
            Optional.ofNullable(tripDetails.getEndTime())
                .map(time -> LocalTime.parse(time.format(formatter), formatter))
                .orElse(null)
        );

        dateArr.setDescription(tripDetails.getDescription());
        dateArr.setPosition(tripDetails.getPosition());
        dateArr.setCreatType(tripDetails.getCreatType());
        dateArr.setDayTab(tripDetails.getDayTab());

        QueryWrapper<GhImages> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("detail_Id", tripDetails.getDetailId());
        List<GhImages> ghImagesList = ghImagesMapper.selectList(queryWrapper);
        for (GhImages ghImages : ghImagesList) {
            if (ghImages.getFileName() != null) {
                String fileUrl = minioUtils.getFileUrl(ghImages.getFileName());
                ghImages.setUrl(fileUrl);
                ghImagesService.updateById(ghImages);
            }

        }
        dateArr.setImgList(ghImagesList);
    }
}
