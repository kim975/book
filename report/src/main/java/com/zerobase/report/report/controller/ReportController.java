package com.zerobase.report.report.controller;

import com.zerobase.report.common.response.CommonResponse;
import com.zerobase.report.report.application.BookFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReportController {

    private final BookFacade bookFacade;

    @PostMapping("/report")
    @PreAuthorize("hasRole('USER')")
    public CommonResponse<ReportDto.CreateReportResponse> createReport(
        Authentication authentication,
        @RequestBody ReportDto.CreateReportRequest request
    ) {
        return CommonResponse.success(
            ReportDto.CreateReportResponse.from(
                bookFacade.createReport(request.toFacadeDto(authentication.getName()))
            )
        );
    }

    @GetMapping("/my-report/{reportSeq}")
    @PreAuthorize("hasRole('USER')")
    public CommonResponse<ReportDto.CreateReportResponse> getReport(
        Authentication authentication,
        @PathVariable long reportSeq
    ) {

    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/my-reports")
    public CommonResponse<ReportDto.CreateReportResponse> getReport(
        Authentication authentication,
        @PathVariable long reportSeq
    ) {

    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/follow-reports")


}
