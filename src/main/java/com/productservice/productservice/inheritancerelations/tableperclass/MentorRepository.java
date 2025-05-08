package com.productservice.productservice.inheritancerelations.tableperclass;

import com.productservice.productservice.inheritancerelations.tableperclass.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("tpc_mentorrepository")
public interface MentorRepository extends JpaRepository<Mentor, Long> {

    @Override
    Mentor save(Mentor mentor);
}
