package com.framework.service;

import com.framework.dao.MybatisDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseService {

    protected static final Log log = LogFactory.getLog(BaseService.class);

    @Autowired
    protected MybatisDao mtDao = null;
}