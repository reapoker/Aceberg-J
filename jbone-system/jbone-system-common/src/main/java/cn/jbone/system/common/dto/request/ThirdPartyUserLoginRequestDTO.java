package cn.jbone.system.common.dto.request;

import cn.jbone.system.common.dto.ThirdPartyName;
import lombok.Data;

@Data
public class ThirdPartyUserLoginRequestDTO {
    private String id;

    private ThirdPartyName thirdPartyName;

}
