package com.atribus.Atribus.controller.twitter.twittersProfiles;

import com.atribus.Atribus.entity.twitter.twittersProfiles.TwittersProfilesTweetsStatistic;
import com.atribus.Atribus.service.twitter.twittersProfiles.TwittersProfilesTweetsStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/twittersprofilestweetsstatistics")
@CrossOrigin(origins = "*")
public class TwittersProfilesTweetsStatisticController {

    @Autowired
    TwittersProfilesTweetsStatisticService twittersProfilesTweetsStatisticService;

    //MOSTRAR TWITTERSPROFILESTWEETSSTATISTICS -> GET ALL (READ):
    @GetMapping("/list")
    public ResponseEntity<List<TwittersProfilesTweetsStatistic>> List() {
        List<TwittersProfilesTweetsStatistic> list = twittersProfilesTweetsStatisticService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //PAGINACIÓN -> GET:
    @GetMapping("/list/pagina={page}&resultadosporpagina={size}")
    public ResponseEntity<Slice<TwittersProfilesTweetsStatistic>> ListPage(@PathVariable("page") int page, @PathVariable("size") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Slice<TwittersProfilesTweetsStatistic> list = twittersProfilesTweetsStatisticService.listPage(pageable);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //MÉTODO findByTwittersProfileTweetsId:
    @GetMapping("/listByTwittersProfileTweetsId")
    public ResponseEntity<List<TwittersProfilesTweetsStatistic>> listByTwittersProfileTweetsId(@RequestParam("id") Long id) {
        List<TwittersProfilesTweetsStatistic> tweets = twittersProfilesTweetsStatisticService.findByTwittersProfileTweetsId(id);
        return new ResponseEntity<>(tweets, HttpStatus.OK);
    }

}
