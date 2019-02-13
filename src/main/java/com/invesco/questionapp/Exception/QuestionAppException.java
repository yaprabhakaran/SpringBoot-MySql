package com.invesco.questionapp.Exception;

/**
 *
 * @author Prabhakaran Karuppiah
 *
 *
 */

public class QuestionAppException extends RuntimeException{

    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    public QuestionAppException( String resourceName, String fieldName, Object fieldValue) {
        super(resourceName+ " not found with "+fieldName);
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}
