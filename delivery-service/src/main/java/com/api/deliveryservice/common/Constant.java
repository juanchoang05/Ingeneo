package com.api.deliveryservice.common;

public interface Constant {
    interface DESCUENTO{
        double P03 = 0.03;
        double P05 = 0.05;
        int LIMIT10 = 10;
    }

    interface PATTERN{
        String TRUCK = "^[A-Za-z]{3}\\\\d{3}$";
        String MARITIMO = "^[A-Za-z]{3}\\d{4}[A-Za-z]$";
    }
}
