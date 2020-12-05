package com.thewithel.cpuload.services;

public interface HashService {

    String hashMd5(String word);
    String hashSha256(String word);
    String hashSha512(String word);
}
