package com.lwj.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("")
    public String test(){
        return "{\"result\":{\"totalCount\":2,\"pageSize\":10,\"totalPage\":1,\"currPage\":1,\"list\":[{\"id\":21,\"sceneId\":123,\"linwjName\":\"测试linwj\",\"linwjContent\":\"测试content\",\"lang\":\"all\",\"resName\":null,\"resPriority\":0,\"resType\":0,\"apiLevel\":null,\"eCode\":null,\"gmtCreated\":null,\"gmtModified\":null,\"platform\":3,\"isEnable\":0,\"country\":\"all\",\"shareUrl\":null,\"areaId\":11,\"url\":null,\"gifUrl\":null,\"startDate\":\"2018-08-01 08:00:00\",\"endDate\":\"2018-08-15 08:00:00\"},{\"id\":47,\"sceneId\":456,\"linwjName\":\"测试小明\",\"linwjContent\":\"测试content\",\"lang\":\"fr\",\"resName\":null,\"resPriority\":0,\"resType\":0,\"apiLevel\":null,\"eCode\":null,\"gmtCreated\":null,\"gmtModified\":null,\"platform\":3,\"isEnable\":0,\"country\":\"all\",\"shareUrl\":null,\"areaId\":11,\"url\":\"http://res.ufotosoft.com/res/1547703871796_UF190117333d149a-aacf-4ec9-ab3c-c92dc1b850df.png\",\"gifUrl\":\"http://res.ufotosoft.com/res/1547703871796_UF190117333d149a-aacf-4ec9-ab3c-c92dc1b850df.png\",\"startDate\":null,\"endDate\":null}]},\"errorCode\":0,\"errorMsg\":null,\"successful\":true}";
    }
}
