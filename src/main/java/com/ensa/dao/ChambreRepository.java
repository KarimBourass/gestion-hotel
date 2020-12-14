package com.ensa.dao;

import com.ensa.beans.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre,Long> {


    @Query(value = "SELECT c FROM Chambre c where c.disponibilite like '1' ")
    List<Chambre> findByDisponibilite(@Param("dis")String disponibilite);


}
