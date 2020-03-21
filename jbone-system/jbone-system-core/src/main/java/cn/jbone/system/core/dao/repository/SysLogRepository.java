package cn.jbone.system.core.dao.repository;

import cn.jbone.system.core.dao.domain.SysLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SysLogRepository extends JpaRepository<SysLogEntity,Integer>,JpaSpecificationExecutor<SysLogEntity>{
}
