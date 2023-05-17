package com.atribus.Atribus.twittersTweets.dao;

import com.atribus.Atribus.twittersTweets.entity.TwittersTweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface TwittersTweetRepository extends JpaRepository<TwittersTweet, Long> {

    //QUERY JPQL
    @Query("select tt from TwittersTweet tt where tt.categories.categoryId = ?1")
    List<TwittersTweet> getTwittersTweetByCategoryId(int category);
    //Show by category_id

    @Query("select tt from TwittersTweet tt where tt.searchs.searchId = ?1")
    List<TwittersTweet> getTwittersTweetBySearchId(int search);
    //Show by search_id

    @Query("select tt from TwittersTweet tt where tt.categories.categoryId = ?1 and tt.searchs.searchId = ?2")
    List<TwittersTweet> getTwittersTweetByCategoryIdAndSearchId(int category, int search);
    //Show by category_id and search_id

    @Query("select tt from TwittersTweet tt where tt.dateCreated = ?1")
    List<TwittersTweet> getTwittersTweetByDateCreated(Date dateCreated);
    //Show by dateCreated

    @Query("select tt from TwittersTweet tt where tt.dateCreated between ?1 and ?2")
    List<TwittersTweet> getTwittersTweetByDateCreatedBetween(Date start, Date end);
    //Show between dateCreated

    @Query("select tt from TwittersTweet tt where tt.datetimeCreated = ?1")
    List<TwittersTweet> getTwittersTweetByDatetimeCreated(Timestamp datetimeCreated);
    //Show by datetimeCreated

    @Query("select tt from TwittersTweet tt where tt.datetimeCreated > ?1 and tt.datetimeCreated < ?2")
    List<TwittersTweet> getTwittersTweetByDatetimeCreatedBetween(Date start, Date end);
    //Show between datetimeCreated

    @Query("select tt from TwittersTweet tt where tt.categories.categoryId = ?1 and tt.searchs.searchId = ?2 and tt.datetimeCreated >= ?3")
    List<TwittersTweet> getTwittersTweetByCategoryIdAndSearchIdAndDatetimeCreated(int category, int search, Date datetimeCreated);
    //Show by category_id and search_id and datetimeCreated

    @Query("select tt from TwittersTweet tt where tt.categories.categoryId = ?1 and tt.searchs.searchId = ?2 and tt.dateCreated = ?3")
    List<TwittersTweet> getTwittersTweetByCategoryIdAndSearchIdAndDateCreated(int category, int search, Date dateCreated);
    //Show by category_id and search_id and dateCreated

    //SERVICE -> CONTROLLER
    List<TwittersTweet> findBySearchsSearchIdAndDateCreated(int search, Date dateCreated);
    List<TwittersTweet> findByCategoriesCategoryIdAndDateCreated(int category, Date dateCreated);
    List<TwittersTweet> findByDateCreated(Date dateCreated);
    List<TwittersTweet> findByCategoriesCategoryIdAndSearchsSearchIdAndDateCreated(int category, int search, Date dateCreated);
}

