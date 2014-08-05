package com.springmvc.test.common;

import com.springmvc.test.common.service.ICommonService;
import com.springmvc.test.common.util.SpringContextUtil;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;

public abstract class AbstractEntity implements Serializable {
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public void save(){
        ICommonService commonService = SpringContextUtil.getBean("CommonService");
        commonService.save(this);
    }
}
