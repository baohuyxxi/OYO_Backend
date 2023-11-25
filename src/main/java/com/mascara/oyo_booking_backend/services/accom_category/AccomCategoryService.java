package com.mascara.oyo_booking_backend.services.accom_category;

import com.mascara.oyo_booking_backend.dtos.request.accom_category.AddAccomCategoryRequest;
import com.mascara.oyo_booking_backend.dtos.request.accom_category.UpdateAccomCategoryRequest;
import com.mascara.oyo_booking_backend.dtos.response.accom_category.GetAccomCategoryResponse;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by: IntelliJ IDEA
 * User      : boyng
 * Date      : 22/10/2023
 * Time      : 7:39 CH
 * Filename  : AccomCategoryService
 */
public interface AccomCategoryService {
    @Transactional
    List<GetAccomCategoryResponse> getAllAccomCategory();

    String addAccomCategory(AddAccomCategoryRequest request);

    String updateAccomCategory(UpdateAccomCategoryRequest request, Long id);

    @Transactional
    String deleteAccomCategory(Long id);
}
