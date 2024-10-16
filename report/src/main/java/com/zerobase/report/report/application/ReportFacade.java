package com.zerobase.report.report.application;

import com.zerobase.report.api.user.UserApi;
import com.zerobase.report.api.user.UserApiDto.UserDetail;
import com.zerobase.report.api.user.UserApiDto.UserListResponse;
import com.zerobase.report.api.user.UserApiDto.UserResponse;
import com.zerobase.report.api.user.UserSearchType;
import com.zerobase.report.report.service.ReportInfo.Main;
import com.zerobase.report.report.service.ReportService;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportFacade {

    private final ReportService reportService;
    private final UserApi userApi;

    public ReportFacadeDto.GetReportResponse getMyReport(String userUuid, Long reportSeq) {
        UserResponse user = userApi.getUser(userUuid, UserSearchType.USER_UUID);
        Main myReport = reportService.getMyReport(user.getData().getId(), reportSeq);

        return ReportFacadeDto.GetReportResponse.from(myReport, user.getData());
    }

    public Page<ReportFacadeDto.GetReportResponse> getMyReports(String userUuid, Pageable pageable) {
        UserResponse user = userApi.getUser(userUuid, UserSearchType.USER_UUID);
        Page<Main> myReports = reportService.getMyReports(user.getData().getId(), pageable);

        return myReports.map(report -> ReportFacadeDto.GetReportResponse.from(report, user.getData()));
    }

    public ReportFacadeDto.GetReportResponse getReport(String nickname, Long reportSeq) {
        UserResponse user = userApi.getUser(nickname, UserSearchType.NICKNAME);
        Main report = reportService.getReport(user.getData().getId(), reportSeq);

        return ReportFacadeDto.GetReportResponse.from(report, user.getData());
    }

    public Page<ReportFacadeDto.GetReportResponse> getReports(List<String> nickname, Pageable pageable) {
        UserListResponse usersResponse = userApi.getUsers(nickname, UserSearchType.NICKNAME);

        Page<Main> reports = reportService.getReports(
            usersResponse.getData().stream()
                .map(UserDetail::getId)
                .toList()
            , pageable
        );

        Set<Long> pageIdSet = reports.stream().map(Main::getUserId).collect(Collectors.toSet());

        List<UserDetail> filterUserList = usersResponse.getData().stream()
            .filter(userDetail -> pageIdSet.stream().anyMatch(id -> id.equals(userDetail.getId()))).toList();

        return reports.map(report -> ReportFacadeDto.GetReportResponse.from(report,
                filterUserList
                    .stream()
                    .filter(
                        user -> report.getUserId().equals(user.getId())
                    )
                    .findFirst()
                    .get()
            )
        );
    }
}
