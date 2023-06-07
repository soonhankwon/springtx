package com.soon.springtx.propagation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MemberFacade {

    private final MemberService memberService;
    private final LogRepository logRepository;

    public void facadeJoin(String username) {
        memberService.joinV3(username);
        try {
            Log logMessage = new Log(username);
            logRepository.save2(logMessage);
        } catch (RuntimeException e) {
            log.info("recover facadeJoin");
        }

    }
}
