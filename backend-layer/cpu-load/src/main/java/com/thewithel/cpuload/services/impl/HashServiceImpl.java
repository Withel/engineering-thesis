package com.thewithel.cpuload.services.impl;

import com.google.common.hash.Hashing;
import com.thewithel.cpuload.services.HashService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class HashServiceImpl implements HashService {

    @Override
    public String hashMd5(String word) {
        return Hashing.md5()
                .hashString(word).toString();
    }

    @Override
    public String hashSha256(String word) {
        return Hashing.sha256()
                .hashString(word).toString();
    }

    @Override
    public String hashSha512(String word) {
        return Hashing.sha512()
                .hashString(word).toString();
    }
}
