package com.zerobase.report.report.domain.repository;

import com.zerobase.report.report.domain.model.BookReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookReportRepository extends JpaRepository<BookReport, Long> {

}
