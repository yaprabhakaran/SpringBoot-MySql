package com.invesco.questionapp.util;

import com.invesco.questionapp.constant.Constants;
import com.invesco.questionapp.model.response.Data;

public class QuestionUtil {

    public static Data getDataWithError(){
        Data data = new Data();
        data.setSuccess(Constants.FALSE);

        return data;
    }
}
