package com.khoders.smartchurch.mapper;

import com.khoders.smartchurch.dto.UserAccountDto;
import com.khoders.smartchurch.entities.UserAccount;
import com.khoders.smartchurch.entities.Country;
import com.khoders.smartchurch.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthMapper {
    @Autowired private CountryService countryService;

    public UserAccount toEntity(UserAccountDto dto){
        UserAccount userAccount = new UserAccount();
        userAccount.setChurchName(dto.getChurchName());
        userAccount.setEmailAddress(dto.getEmailAddress());
        userAccount.setHeadPastorName(dto.getHeadPastorName());
        userAccount.setDiscountCode(dto.getDiscountCode());
        userAccount.setPassword(dto.getPassword());

        if(dto.getCountryId() == null)
        {
            new Throwable("Please country value cannot be null");
        }
        try {
            Optional<Country> country = countryService.findEntityById(dto.getCountryId());
            country.ifPresent(userAccount::setCountry);

        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return userAccount;
    }

    public UserAccountDto toDto(UserAccount userAccount){
        UserAccountDto dto = new UserAccountDto();
        dto.setChurchName(userAccount.getChurchName());
        dto.setEmailAddress(userAccount.getEmailAddress());
        dto.setHeadPastorName(userAccount.getHeadPastorName());
        dto.setDiscountCode(userAccount.getDiscountCode());

        if(userAccount.getCountry() != null)
        {
            dto.setCountryId(userAccount.getCountry().getId());
            dto.setCountryName(userAccount.getCountry().getCountryName());
        }
        return dto;
    }
}
