package com.huang.serviceloader.impl;

import com.huang.serviceloader.SayHi;

/**
 * Created by fenfanxiadewunai on 14-6-5.
 */
public class Hello implements SayHi {

    @Override
    public String say() {
        return "你好123";
    }
}
