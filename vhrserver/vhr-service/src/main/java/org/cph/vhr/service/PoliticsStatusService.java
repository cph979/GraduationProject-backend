package org.cph.vhr.service;

import org.cph.vhr.mapper.PoliticsStatusMapper;
import org.cph.vhr.model.PoliticsStatus;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author cph
 * @create 2020-12-14 13:54
 */
@Service
public class PoliticsStatusService {
    @Resource
    PoliticsStatusMapper politicsstatusMapper;

    public List<PoliticsStatus> getAllPoliticsStatus() {
        return politicsstatusMapper.getAllPoliticsStatus();
    }
}
