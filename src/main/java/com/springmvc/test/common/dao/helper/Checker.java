package com.springmvc.test.common.dao.helper;

import java.util.List;

public class Checker {
    public static void ensureNotEmpty(List result, String message) {
        if (result.isEmpty()) {
            throw new RecordNotFound(message);
        }
    }
}
