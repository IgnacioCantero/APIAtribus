package com.atribus.Atribus.controller.facebook.facebooksFeeds;

import com.atribus.Atribus.entity.facebook.facebooksFeeds.FacebooksFeedsStatistic;
import com.atribus.Atribus.service.facebook.facebooksFeeds.FacebooksFeedsStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/facebooksfeedsstatistics")
@CrossOrigin(origins = "*")
public class FacebooksFeedsStatisticController {

    @Autowired
    FacebooksFeedsStatisticService facebooksFeedsStatisticService;


    //MOSTRAR FACEBOOKSFEED -> GET ALL (READ):
    @GetMapping("/list")
    public ResponseEntity<List<FacebooksFeedsStatistic>> List() {
        List<FacebooksFeedsStatistic> list = facebooksFeedsStatisticService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //PAGINACIÓN -> GET:
    @GetMapping("/list/pagina={page}&resultadosporpagina={size}")
    public ResponseEntity<Slice<FacebooksFeedsStatistic>> ListPage(@PathVariable("page") int page, @PathVariable("size") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Slice<FacebooksFeedsStatistic> list = facebooksFeedsStatisticService.listPage(pageable);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //MÉTODO findByFacebooksFeedsId:
    @GetMapping("/listByFacebooksFeedsId")
    public ResponseEntity<List<FacebooksFeedsStatistic>> listByFacebooksFeedsId(
            @RequestParam("facebooksFeedsId") Long id) {
        List<FacebooksFeedsStatistic> tweets = facebooksFeedsStatisticService.findByFacebooksFeedsId(id);
        return new ResponseEntity<>(tweets, HttpStatus.OK);
    }

}
