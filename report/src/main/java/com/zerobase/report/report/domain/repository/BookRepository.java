package com.zerobase.report.report.domain.repository;

import com.zerobase.report.report.domain.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
