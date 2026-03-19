package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ShippingServiceTest {
    ShippingService service = new ShippingService();

    @Test
    void test1() {
        assertThrows(IllegalArgumentException.class, () -> service.calculateFee(0.0, 1, true));
    }

    @Test
    void test2() {
        assertThrows(IllegalArgumentException.class, () -> service.calculateFee(0.0, 0, true));
    }

    @Test
    void test3() {
        assertThrows(IllegalArgumentException.class, () -> service.calculateFee(0.0, 1, false));
    }

    @Test
    void test4() {
        assertThrows(IllegalArgumentException.class, () -> service.calculateFee(-1.0, 0, false));
    }

    @Test
    void test5() {
        assertEquals(125000.0, service.calculateFee(1.0, 1, true));
    }

    @Test
    void test6() {
        assertThrows(IllegalArgumentException.class, () -> service.calculateFee(1.0, 0, true));
    }

    @Test
    void test7() {
        assertEquals(90000.0, service.calculateFee(1.0, 1, false));
    }

    @Test
    void test8() {
        assertThrows(IllegalArgumentException.class, () -> service.calculateFee(1.0, 0, false));
    }

    @Test
    void test9() {
        assertEquals(170000.0, service.calculateFee(11.0, 1, true));
    }

    @Test
    void test10() {
        assertThrows(IllegalArgumentException.class, () -> service.calculateFee(11.0, 0, true));
    }

    @Test
    void test11() {
        assertEquals(120000.0, service.calculateFee(11.0, 1, false));
    }

    @Test
    void test12() {
        assertThrows(IllegalArgumentException.class, () -> service.calculateFee(11.0, 0, false));
    }

    // kiểm thử biên cho weight và distance
    @Test
    void test13() { // weight=min- (0)
        assertThrows(IllegalArgumentException.class, () -> service.calculateFee(0, 250, false));
    }

    @Test
    void test14() { // weight=min (0.01)
        assertEquals(5070000.0, service.calculateFee(0.01, 250, false));
    }

    @Test
    void test15() { // weight=min+ (0.02)
        assertEquals(5070000.0, service.calculateFee(0.02, 250, false));
    }

    @Test
    void test16() { // weight=max- (49.99)
        assertEquals(5100000.0, service.calculateFee(49.99, 250, false));
    }

    @Test
    void test17() { // weight=max (50)
        assertEquals(5100000.0, service.calculateFee(50, 250, false));
    }

    @Test
    void test18() { // weight=max+ (50.01)
        assertThrows(IllegalArgumentException.class, () -> service.calculateFee(50.01, 250, false));
    }

    @Test
    void test19() { // distance=min- (-1)
        assertThrows(IllegalArgumentException.class, () -> service.calculateFee(25, -1, false));
    }

    @Test
    void test20() { // distance=min (0)
        assertThrows(IllegalArgumentException.class, () -> service.calculateFee(25, 0, false));
    }

    @Test
    void test21() { // distance=min+ (1)
        assertEquals(120000.0, service.calculateFee(25, 1, false));
    }

    @Test
    void test22() { // distance=max- (499)
        assertEquals(10080000.0, service.calculateFee(25, 499, false));
    }

    @Test
    void test23() { // distance=max (500)
        assertEquals(10100000.0, service.calculateFee(25, 500, false));
    }

    @Test
    void test24() { // distance=max+ (501)
        assertThrows(IllegalArgumentException.class, () -> service.calculateFee(25, 501, false));
    }

    @Test
    void test25() { // nom (Trung bình)
        assertEquals(5100000.0, service.calculateFee(25, 250, false));
    }
    
}