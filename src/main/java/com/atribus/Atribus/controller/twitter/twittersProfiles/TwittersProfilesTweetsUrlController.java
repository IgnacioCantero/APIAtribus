package com.atribus.Atribus.controller.twitter.twittersProfiles;

import com.atribus.Atribus.entity.twitter.twittersProfiles.TwittersProfilesTweetsUrl;
import com.atribus.Atribus.service.twitter.twittersProfiles.TwittersProfilesTweetsUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/twittersprofilestweetsurls")
@CrossOrigin(origins = "*")
public class TwittersProfilesTweetsUrlController {

    @Autowired
    TwittersProfilesTweetsUrlService twittersProfilesTweetsUrlService;

    //MOSTRAR TWITTERSPROFILESTWEETSURLS -> GET ALL (READ):
    @GetMapping("/list")
    public ResponseEntity<List<TwittersProfilesTweetsUrl>> List() {
        List<TwittersProfilesTweetsUrl> list = twittersProfilesTweetsUrlService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //PAGINACIÓN -> GET:
    @GetMapping("/list/pagina={page}&resultadosporpagina={size}")
    public ResponseEntity<Slice<TwittersProfilesTweetsUrl>> ListPage(@PathVariable("page") int page, @PathVariable("size") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Slice<TwittersProfilesTweetsUrl> list = twittersProfilesTweetsUrlService.listPage(pageable);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //MÉTODO findByTwittersProfileTweetsId:
    @GetMapping("/listByTwittersProfileTweetsId")
    public ResponseEntity<List<TwittersProfilesTweetsUrl>> listByTwittersProfileTweetsId(
            @RequestParam("id") Long id) {
        List<TwittersProfilesTweetsUrl> tweets = twittersProfilesTweetsUrlService.findByTwittersProfileTweetsId(id);
        return new ResponseEntity<>(tweets, HttpStatus.OK);
    }

}
