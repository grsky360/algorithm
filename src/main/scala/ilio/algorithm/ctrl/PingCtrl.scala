package ilio.algorithm.ctrl

import org.springframework.web.bind.annotation.{RequestMapping, RestController}

@RestController
class PingCtrl {

    @RequestMapping(Array("/ping"))
    def ping() = "pong"
}
