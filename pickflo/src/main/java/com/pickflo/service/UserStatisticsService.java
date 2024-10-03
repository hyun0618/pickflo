package com.pickflo.service;

import com.pickflo.domain.UserStatistics;
import com.pickflo.repository.UserStatisticsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserStatisticsService {

    private final UserStatisticsRepository userStatisticsRepo;
    
    public void saveUserData(UserStatistics userStatistics) {
        // 기존 통계를 업데이트하지 않고 새로운 활동 기록을 저장
        UserStatistics newStatistics = UserStatistics.builder()
                .userId(userStatistics.getUserId())
                .userGroup(userStatistics.getUserGroup())
                .pageName(userStatistics.getPageName())
                .timeSpentSeconds(userStatistics.getTimeSpentSeconds())
                .scrollCount(userStatistics.getScrollCount()) // 전달된 scrollCount 사용
                .likeCount(userStatistics.getLikeCount())
                .unlikeCount(userStatistics.getUnlikeCount())
                .activityTimestamp(userStatistics.getActivityTimestamp()) // 클라이언트에서 전달된 시간 사용
                .build();

        // DB에 새로운 활동 기록 저장
        userStatisticsRepo.save(newStatistics);
    }

    public List<UserStatistics> getUserStatistics() {
        return userStatisticsRepo.findAll();
    }
    
}
