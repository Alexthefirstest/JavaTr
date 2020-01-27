package by.javaTr.financeAccounting.service.impl;

import by.javaTr.financeAccounting.service.exceptions.ServiceException;

import java.math.BigInteger;
import java.util.Base64;

public class TextEncodeServiceImpl implements by.javaTr.financeAccounting.service.TextEncodeService {


    @Override
    public String encode(String text) throws ServiceException {

        if (text == null) {
            throw new ServiceException("Text is null");
        }

        Base64.Encoder encoder = Base64.getEncoder();
        byte bytes[] = encoder.encode(text.getBytes());

        BigInteger bigInteger = new BigInteger(1, bytes);
        return bigInteger.toString(16);
    }

}
