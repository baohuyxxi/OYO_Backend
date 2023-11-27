package com.mascara.oyo_booking_backend.services.user;

import com.mascara.oyo_booking_backend.dtos.BaseMessageData;
import com.mascara.oyo_booking_backend.dtos.request.auth.RegisterRequest;
import com.mascara.oyo_booking_backend.dtos.request.auth.TokenRefreshRequest;
import com.mascara.oyo_booking_backend.dtos.request.user.ChangePasswordRequest;
import com.mascara.oyo_booking_backend.dtos.request.user.UpdateInfoPersonalRequest;
import com.mascara.oyo_booking_backend.dtos.response.auth.TokenRefreshResponse;
import com.mascara.oyo_booking_backend.dtos.response.paging.BasePagingData;
import com.mascara.oyo_booking_backend.dtos.response.user.InfoUserResponse;
import com.mascara.oyo_booking_backend.entities.User;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by: IntelliJ IDEA
 * User      : boyng
 * Date      : 09/10/2023
 * Time      : 6:01 CH
 * Filename  : IUserService
 */
public interface UserService {
    User addUser(RegisterRequest request, String passwordEncode);

    @Transactional
    TokenRefreshResponse refreshJwtToken(TokenRefreshRequest tokenRefreshRequest);

    @Transactional
    InfoUserResponse updateInfoPersonal(UpdateInfoPersonalRequest request, String email);

    @Transactional
    InfoUserResponse updateAvatar(MultipartFile file, String mail);

    BaseMessageData changePassword(ChangePasswordRequest request);

    BasePagingData<InfoUserResponse> getAllUserWithPaging(Integer pageNumber, Integer pageSize, String sortType, String field);

    @Transactional
    BaseMessageData changeStatusUser(String email, String status);

    @Transactional
    BaseMessageData deleteUser(String email);
}
