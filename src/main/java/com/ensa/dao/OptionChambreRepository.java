package com.ensa.dao;

import com.ensa.beans.Chambre;
import com.ensa.beans.OptionChambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OptionChambreRepository extends JpaRepository<OptionChambre,Long> {

    @Query(value = "SELECT op.chambre FROM OptionChambre op where op.optionName like :cat")
    List<Chambre> findByOption(@Param("cat") String option);
}
