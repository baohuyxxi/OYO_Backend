package com.mascara.oyo_booking_backend.dtos.response.booking;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mascara.oyo_booking_backend.enums.BookingStatusEnum;
import com.mascara.oyo_booking_backend.enums.PaymentMethodEnum;
import com.mascara.oyo_booking_backend.enums.PaymentPolicyEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Created by: IntelliJ IDEA
 * User      : boyng
 * Date      : 29/11/2023
 * Time      : 2:35 SA
 * Filename  : GetOrderResponse
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetBookingResponse {
    private String bookingCode;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate checkIn;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate checkOut;
    private String nameCustomer;
    private String phoneNumberCustomer;
    private Double originPay;
    private Double surcharge;
    private Double totalBill;
    private Double totalTransfer;
    private PaymentPolicyEnum paymentPolicy;
    private PaymentMethodEnum paymentMethod;
    private Integer numAdult;
    private Integer numChild;
    private Integer numBornChild;
    private BookingStatusEnum bookingStatusEnum;
    private Long accomId;
    private Double commisionMoney;
    private Double totalRevenue;
    private String nameAccom;
}
