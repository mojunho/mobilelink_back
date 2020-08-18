package kr.co.erst.mobilelink_back.mapper;

import kr.co.erst.mobilelink_back.vo.MemberVo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface MemberMapper {

    List<MemberVo> searchMember(Map<String, Object> map);

    int countSearchMember(Map<String, Object> map);

    boolean insertNewMember(MemberVo memberVo);

    MemberVo selectOneMember(int id);

    boolean updateOneMember(Map<String, Object> map);

    boolean deleteOneMember(Map<String, Object> map);

    boolean realDeleteOneMember(Map<String, Object> map);

}
