package com.atribus.Atribus.twittersTweets.dao;

import com.atribus.Atribus.twittersTweets.entity.Search;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface SearchRepository extends JpaRepository<Search, Long> {

    //FUNCIONES DINÁMICAS:
    @Query("select sea from Search sea where sea.searchId = ?1")
    List<Search> getSearchBySearchId(int search);
    //Show by search_id

}
