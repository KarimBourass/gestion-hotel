package com.ensa.dao;

import com.ensa.beans.CategorieChambre;
import com.ensa.beans.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategorieChambreRepository extends JpaRepository<CategorieChambre,Long> {

    @Query(value = "SELECT ch.chambre FROM CategorieChambre ch where ch.categorieName like :cat")
    List<Chambre> findByCategorie(@Param("cat")String categorie);

    

}
