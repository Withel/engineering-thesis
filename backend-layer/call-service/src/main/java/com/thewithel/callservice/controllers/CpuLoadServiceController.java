package com.thewithel.callservice.controllers;

import com.thewithel.callservice.feignservice.CpuLoadServiceFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
public class CpuLoadServiceController {

    private CpuLoadServiceFeign cpuLoadServiceFeign;

    public CpuLoadServiceController(CpuLoadServiceFeign cpuLoadServiceFeign) {
        this.cpuLoadServiceFeign = cpuLoadServiceFeign;
    }

    @GetMapping("/callme")
    public String callMe(){
        log.info("ENDPOINT: /callme in function callMe().");
        return "Hello, you have called /callme in cpu-load application.";
    }

    @GetMapping("/md5/{word}")
    public String md5(@PathVariable String word){
        log.info("ENDPOINT: /md5/{word} in function md5. Arguments given: {}", word);
        return cpuLoadServiceFeign.hashMd5(word);
    }

    @GetMapping("/sha256/{word}")
    public String sha256(@PathVariable String word){
        log.info("ENDPOINT: /sha256/{word} in function sha256(). Arguments given: {}", word);
        return cpuLoadServiceFeign.hashSha256(word);
    }

    @GetMapping("/sha512/{word}")
    public String sha512(@PathVariable String word){
        log.info("ENDPOINT: /sha512/{word} in function sha512(). Arguments given: {}", word);
        return cpuLoadServiceFeign.hashSha512(word);
    }

    @GetMapping("/md5/{word}/{n}")
    public String md5WithParam(@PathVariable String word, @PathVariable Long n){
        log.info("ENDPOINT: /md5/{word}/{n} in function md5WithParam(). Arguments given: {}, {}", word, n);
        return cpuLoadServiceFeign.hashMd5(word, n);
    }

    @GetMapping("/sha256/{word}/{n}")
    public String sha256WithParam(@PathVariable String word, @PathVariable Long n){
        log.info("ENDPOINT: /sha256/{word}/{n} in function sha2565WithParam(). Arguments given: {}, {}", word, n);
        return cpuLoadServiceFeign.hashSha256(word, n);
    }

    @GetMapping("/sha512/{word}/{n}")
    public String sha512WithParam(@PathVariable String word, @PathVariable Long n){
        log.info("ENDPOINT: /sha512/{word}/{n} in function sha512WithParam(). Arguments given: {}, {}", word, n);
        return cpuLoadServiceFeign.hashSha512(word, n);
    }
}
