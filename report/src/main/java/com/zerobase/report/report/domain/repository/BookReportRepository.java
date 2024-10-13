package com.zerobase.report.report.domain.repository;

import com.zerobase.report.report.domain.model.BookReportEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookReportRepository extends JpaRepository<BookReportEntity, Long> {

    Optional<BookReportEntity> findTopByUserIdOrderByBookReportSeqDesc(Long userId);
}
