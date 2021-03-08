package org.cph.vhr.service;

import org.cph.vhr.mapper.PositionMapper;
import org.cph.vhr.model.Position;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author cph
 * @create 2020-12-11 11:20
 */
@Service
public class PositionService {
    @Resource
    PositionMapper positionMapper;

    public List<Position> getAllPositions() {
        return positionMapper.getAllPositions(null);
    }

    public List<Position> getAllEnabledPositions(Boolean enabled) {
        return positionMapper.getAllPositions(enabled);
    }

    public Integer addPosition(Position position) {
        position.setCreateDate(new Date());
        position.setEnabled(true);
        return positionMapper.insertSelective(position);
    }

    public Integer updatePosition(Position position) {
        return positionMapper.updateByPrimaryKeySelective(position);
    }

    public Integer deletePosition(Integer id) {
        return positionMapper.deleteByPrimaryKey(id);
    }

    public Integer deletePositions(Integer[] ids) {
        return positionMapper.deletePositions(ids);
    }

    public Position getPositionByName(Position position) {
        return positionMapper.getPosition(position);
    }

    public Position getPositionByNameAndStatus(Position position) {
        return positionMapper.getPosition(position);
    }
}
