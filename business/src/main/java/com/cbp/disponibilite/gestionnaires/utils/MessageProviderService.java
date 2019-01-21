package com.cbp.disponibilite.gestionnaires.utils;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Locale;

/**
 * Created by BRAUD on 29/01/2018.
 */
@Service
public class MessageProviderService {

    @Resource(name = "messageSource")
    private MessageSource messageSource;

    public String getMessage(final String code) {
        return getMessage(code, null);
    }

    public String getMessage(final String code, final Object... params) {
        return messageSource.getMessage(code, params, Locale.getDefault());
    }
}
