package com.atribus.Atribus.dao;

import com.atribus.Atribus.entity.TwittersTweetsMaxId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface TwittersTweetsMaxIdRepository extends JpaRepository<TwittersTweetsMaxId, Long> {

    //FUNCIONES DINÁMICAS:
    @Query("select maxid from TwittersTweetsMaxId maxid where maxid.searchId = ?1")
    List<TwittersTweetsMaxId> getTwittersTweetsMaxIdBySearchId(int search);
    //Show by search_id

}
