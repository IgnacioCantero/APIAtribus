package com.atribus.Atribus.controller.facebook.facebooksFeeds;

import com.atribus.Atribus.entity.facebook.facebooksFeeds.FacebooksFeed;
import com.atribus.Atribus.service.facebook.facebooksFeeds.FacebooksFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/facebooksfeeds")
@CrossOrigin(origins = "*")
public class FacebooksFeedController {

    @Autowired
    FacebooksFeedService facebooksFeedService;

    //MOSTRAR FACEBOOKSFEED -> GET ALL (READ):
    @GetMapping("/list")
    public ResponseEntity<List<FacebooksFeed>> List() {
        List<FacebooksFeed> list = facebooksFeedService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //PAGINACIÓN -> GET:
    @GetMapping("/list/pagina={page}&resultadosporpagina={size}")
    public ResponseEntity<Slice<FacebooksFeed>> ListPage(@PathVariable("page") int page, @PathVariable("size") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Slice<FacebooksFeed> list = facebooksFeedService.listPage(pageable);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //MÉTODO findByCategoryIdAndSearchIdAndDateCreated:
    @GetMapping("/listByCategoryAndSearchAndDate")
    public ResponseEntity<List<FacebooksFeed>> listByCategoryAndSearchAndDate(
            @RequestParam("category") int category,
            @RequestParam("search") int search,
            @RequestParam("dateCreated") Date dateCreated) {
        if (category == -1 && search != -1) {
            List<FacebooksFeed> tweets = facebooksFeedService.findBySearchAndDateCreated(search, dateCreated);
            return new ResponseEntity<>(tweets, HttpStatus.OK);
        }
        if (search == -1 && category != -1) {
            List<FacebooksFeed> tweets = facebooksFeedService.findByCategoryIdAndDateCreated(category, dateCreated);
            return new ResponseEntity<>(tweets, HttpStatus.OK);
        } else if (category == -1) {
            List<FacebooksFeed> tweets = facebooksFeedService.findByDateCreated(dateCreated);
            return new ResponseEntity<>(tweets, HttpStatus.OK);
        }
        List<FacebooksFeed> tweets = facebooksFeedService.findByCategoryIdAndSearchAndDateCreated(category, search, dateCreated);
        return new ResponseEntity<>(tweets, HttpStatus.OK);
    }

}
