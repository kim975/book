package com.zerobase.report.report.service;

import com.zerobase.report.aop.ReportSeqLock;
import com.zerobase.report.report.domain.model.BookEntity;
import com.zerobase.report.report.domain.model.BookReportEntity;
import com.zerobase.report.report.domain.repository.BookReader;
import com.zerobase.report.report.domain.repository.ReportReader;
import com.zerobase.report.report.domain.repository.ReportStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final ReportReader reportReader;
    private final ReportStore reportStore;
    private final BookReader bookReader;

    @ReportSeqLock
    public ReportInfo.Main createReport(ReportCommand.CreateReport command) {
        BookEntity book = bookReader.getBookById(command.getBookId());
        Long reportSeq = reportReader.getTopSeqByUserId(command.getUserId());

        BookReportEntity report = command.toEntity(book);
        report.setBookReportSeq(reportSeq + 1);

        return ReportInfo.Main.fromEntity(reportStore.store(report));
    }

}
