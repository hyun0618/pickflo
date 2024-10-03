package com.pickflo.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_statistics")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor(access = AccessLevel.PRIVATE) @Builder
public class UserStatistics {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "statistics_id")
    private Long statisticsId; // 활동 ID

    @Basic(optional = false)
    @Column(name = "user_id")
    private Long userId; // 사용자 ID (외래 키)

    @Basic(optional = false)
    @Column(name = "user_group")
    private String userGroup; // 유저 그룹 (A/B)

    @Column(name = "page_name")
    private String pageName; // 페이지 이름 (예: 'home', 'search', 'like')

    @Basic(optional = false)
    @Column(name = "time_spent_seconds")
    private int timeSpentSeconds; // 해당 페이지에서 머무른 시간(초)

    @Basic(optional = false)
    @Column(name = "scroll_count")
    private int scrollCount; // 스크롤한 횟수 (홈 화면에서만 기록)

    @Basic(optional = false)
    @Column(name = "like_count")
    private int likeCount; // 좋아요 클릭 수

    @Basic(optional = false)
    @Column(name = "unlike_count")
    private int unlikeCount; // 좋아요 해제 수

    @Basic(optional = false)
    @Column(name = "activity_timestamp")
    private LocalDateTime activityTimestamp; // 활동 기록 시간
}
