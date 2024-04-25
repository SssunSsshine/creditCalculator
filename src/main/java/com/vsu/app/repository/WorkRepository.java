package com.vsu.app.repository;

import com.vsu.app.entity.LoanDecision;
import com.vsu.app.entity.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface WorkRepository extends JpaRepository<Work, Long> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO work (is_working, total_seniority, salary) " +
            "VALUES (:#{#work.isWorking}, :#{#work.totalSeniority}, " +
            ":#{#work.salary})", nativeQuery = true)
    Work saveUnemployed(Work work);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO work (is_working, work_address, seniority, total_seniority, salary) " +
            "VALUES (:#{#work.isWorking},:#{#work.workAddress}, :#{#work.seniority}, " +
            ":#{#work.totalSeniority}, :#{#work.salary})", nativeQuery = true)
    Work saveEmployed(Work work);
}
