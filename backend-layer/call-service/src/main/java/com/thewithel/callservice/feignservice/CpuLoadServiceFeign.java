package com.thewithel.callservice.feignservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cpu-load-service")
public interface CpuLoadServiceFeign {

    @GetMapping("/api/callme")
    String callMe();

    @GetMapping("/api/md5/{word}")
    String hashMd5(@PathVariable  String word);

    @GetMapping("/api/sha256/{word}")
    String hashSha256(@PathVariable String word);

    @GetMapping("/api/sha512/{word}")
    String hashSha512(@PathVariable String word);

    @GetMapping("/api/md5/{word}/{n}")
    String hashMd5(@PathVariable String word, @PathVariable Long n);

    @GetMapping("/api/sha256/{word}/{n}")
    String hashSha256(@PathVariable String word, @PathVariable Long n);

    @GetMapping("/api/sha512/{word}/{n}")
    String hashSha512(@PathVariable String word, @PathVariable Long n);

}
