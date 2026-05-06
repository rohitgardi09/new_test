package com.epay.merchant.service;

import com.epay.merchant.annotation.TrackException;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @TrackException
    public void payment() {

        int x = 10 / 0;
    }
}