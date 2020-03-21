package cn.jbone.system.admin.controller;

import cn.jbone.configuration.JboneConfiguration;
import cn.jbone.sso.client.utils.SessionUtil;
import cn.jbone.system.core.service.UserService;
import org.springframework.ui.ModelMap;

public class CommonController {

    public void setCurrentUser(UserService userService, ModelMap modelMap, JboneConfiguration jboneConfiguration){
        modelMap.put("user", SessionUtil.getCurrentUser());
    }
}
