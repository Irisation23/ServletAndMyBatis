package com.example.globalcontroller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Getter
public class ForwardController {
    private final String path;
    private final boolean redirect;
}
