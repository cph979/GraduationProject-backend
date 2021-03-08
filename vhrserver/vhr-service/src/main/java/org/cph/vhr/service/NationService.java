package org.cph.vhr.service;

import org.cph.vhr.mapper.NationMapper;
import org.cph.vhr.model.Nation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author cph
 * @create 2020-12-14 13:55
 */
@Service
public class NationService {
    @Resource
    NationMapper nationMapper;

    public List<Nation> getAllNations() {
        return nationMapper.getAllNations();
    }
}
