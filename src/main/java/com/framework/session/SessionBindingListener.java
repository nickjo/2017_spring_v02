package com.framework.session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SessionBindingListener implements HttpSessionBindingListener {
    private static final Logger log = LoggerFactory.getLogger(SessionBindingListener.class);
    private static Map<String, HttpSession> sessionMap = new ConcurrentHashMap<>();

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        sessionMap.put(event.getName(), event.getSession());
        log.info("###valueBound getName: " + event.getName());
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        sessionMap.remove(event.getSession());
        log.info("###event getName: " + event.getName() + " Logout###");
    }
}
