package com.khoders.smartchurch.enums;

import com.khoders.resource.utilities.MsgResolver;

public enum Reason implements MsgResolver {
    VISITOR("VISITOR", "Visitor"),
    TO_STAY("TO_STAY", "To Stay"),
    ATTEND_PROGRAM("ATTEND_PROGRAM", "Attend Program");

    private final String code;
    private final String label;

    private Reason(String code, String label)
    {
        this.code = code;
        this.label = label;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return label;
    }
}
