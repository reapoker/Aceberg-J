package cn.jbone.system.common;

import cn.jbone.system.common.dto.response.MenuInfoResponseDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class UserAuthInfoDO implements Serializable {
    private Set<String> permissions;
    private Set<String> roles;
    private Map<String,List<MenuInfoResponseDTO>> menus;
}
