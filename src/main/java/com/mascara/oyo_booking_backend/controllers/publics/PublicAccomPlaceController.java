package com.mascara.oyo_booking_backend.controllers.publics;

import com.mascara.oyo_booking_backend.dtos.request.accom_place.GetAccomPlaceFilterRequest;
import com.mascara.oyo_booking_backend.dtos.response.BaseResponse;
import com.mascara.oyo_booking_backend.dtos.response.accom_category.GetAccomCategoryResponse;
import com.mascara.oyo_booking_backend.dtos.response.accommodation.GetAccomPlaceResponse;
import com.mascara.oyo_booking_backend.dtos.response.paging.BasePagingData;
import com.mascara.oyo_booking_backend.dtos.response.review.GetReviewResponse;
import com.mascara.oyo_booking_backend.services.accom_category.AccomCategoryService;
import com.mascara.oyo_booking_backend.services.accom_place.AccomPlaceService;
import com.mascara.oyo_booking_backend.services.review.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by: IntelliJ IDEA
 * User      : boyng
 * Date      : 27/10/2023
 * Time      : 4:48 CH
 * Filename  : PublicAccomPlaceController
 */
@Tag(name = "Public AccomPlace Category Data", description = "Get Data Accom Category with Info")
@RestController
@RequestMapping("/api/v1/public/accom")
@RequiredArgsConstructor
public class PublicAccomPlaceController {

    @Autowired
    private AccomCategoryService accomCategoryService;

    @Autowired
    private AccomPlaceService accomPlaceService;

    @Autowired
    private ReviewService reviewService;

    @Operation(summary = "Get all data province", description = "Public Api get all data province")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = BaseResponse.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @GetMapping("/cate-info")
    public ResponseEntity<?> getAllAccomCategoryInfo() {
        List<GetAccomCategoryResponse> response = accomCategoryService.getAllAccomCategory();
        return ResponseEntity.ok(new BaseResponse<>(true, 200, response));
    }

    @Operation(summary = "Filter Accom Place", description = "Public Api filter accom place")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = BaseResponse.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @GetMapping("/filter")
    public ResponseEntity<?> getAllAccomCategoryInfo(@ParameterObject @Valid GetAccomPlaceFilterRequest filter,
                                                     @RequestParam(value = "pageNum", defaultValue = "0") Integer pageNum) {
        BasePagingData<GetAccomPlaceResponse> response = accomPlaceService.getAccomPlaceFilterWithPaging(filter, pageNum);
        return ResponseEntity.ok(new BaseResponse<>(true,200,response));
    }

    @Operation(summary = "Info Detail Accom Place", description = "Public Api detail of accom place")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = BaseResponse.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @GetMapping("/detail/{id}")
    public ResponseEntity<?> getInfoAccomPlaceDetails(@PathVariable("id") Long id) {
        GetAccomPlaceResponse response = accomPlaceService.getAccomPlaceDetails(id);
        return ResponseEntity.ok(new BaseResponse<>(true, 200, response));
    }

    @Operation(summary = "Reviews Accom Place", description = "Public Api reviews of accom place")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = BaseResponse.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @GetMapping("/reviews/{id}")
    public ResponseEntity<?> getReviewsAccomPlaceDetails(@PathVariable("id") Long id) {
        List<GetReviewResponse> response = reviewService.getReviewListOfAccomPlace(id);
        return ResponseEntity.ok(new BaseResponse<>(true, 200, response));
    }
}
