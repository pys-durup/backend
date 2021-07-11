package com.daib.backend.validation;

import com.daib.backend.dto.PostDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class BoardValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {

        return PostDTO.class.isAssignableFrom(aClass);

    }

    @Override
    public void validate(Object o, Errors errors) {
        PostDTO post = (PostDTO) o;

//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "itemName",
//                "required");
//        if (item.getPrice() == null || item.getPrice() < 1000 ||
//                item.getPrice() > 1000000) {
//            errors.rejectValue("price", "range", new Object[]{1000, 1000000},
//                    null);
//        } if (item.getQuantity() == null || item.getQuantity() > 10000) {
//            errors.rejectValue("quantity", "max", new Object[]{9999}, null);
//        }
//        //특정 필드 예외가 아닌 전체 예외
//        if (item.getPrice() != null && item.getQuantity() != null) {
//            int resultPrice = item.getPrice() * item.getQuantity();
//            if (resultPrice < 10000) {
//                errors.reject("totalPriceMin", new Object[]{10000,
//                        resultPrice}, null);
//            }
//        }
    }
}
