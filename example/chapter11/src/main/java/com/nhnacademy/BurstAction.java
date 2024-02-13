package com.nhnacademy;

@FunctionalInterface
interface BurstAction {
    void burst(Regionable obstacle);
}
