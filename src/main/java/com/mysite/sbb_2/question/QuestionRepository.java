package com.mysite.sbb_2.question;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> { //<엔티티 타입, 엔티티의 PK 속성 타입>
    Question findBySubject(String subject); //JPA가 메서드명을 분석하여 쿼리를 만들고 실행
    Question findBySubjectAndContent(String subject, String content);
    List<Question> findBySubjectLike(String subject);
    Page<Question> findAll(Pageable pageable);
    Page<Question> findAll(Specification<Question> spec, Pageable pageable);

    @Transactional
    @Modifying // @Modifying - 만약 아래 쿼리가 SELECT가 아니라면 이걸 붙여야 한다.
    @Query(value = "ALTER TABLE question AUTO_INCREMENT = 1", nativeQuery = true) // nativeQuery = true 여야 MySQL 쿼리문법 사용 가능
    void clearAutoIncrement();
}