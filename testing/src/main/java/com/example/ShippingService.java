package com.example;

public class ShippingService {
    public double calculateFee(double weight, int distance, boolean isFragile) {
        if (weight <= 0 || distance <= 0 || distance > 500 || weight > 50) {
            throw new IllegalArgumentException("Invalid input");
        }

        double fee = 50000;
        
        // Phụ phí khối lượng
        if (weight <= 10) {
            fee += 20000;
        } else {
            fee += 50000;
        }

        // Hệ số dễ vỡ
        if (isFragile) {
            fee *= 1.5;
        }

        // Phụ phí khoảng cách
        fee += 20000.0 * distance;

        return fee;
    }
}