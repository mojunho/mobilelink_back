package kr.co.erst.mobilelink_back.service.impl;

import kr.co.erst.mobilelink_back.mapper.MemberMapper;
import kr.co.erst.mobilelink_back.service.MemberService;
import kr.co.erst.mobilelink_back.vo.MemberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("MemberService")
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberMapper memberMapper;

    @Override
    public List<MemberVo> searchMember(Map<String, Object> map) {
        List<MemberVo> memberVoList = memberMapper.searchMember(map);
        return memberVoList;
    }

    @Override
    public int countSearchMember(Map<String, Object> map) {
        int memberCount = memberMapper.countSearchMember(map);
        return memberCount;
    }

    @Override
    public boolean insertNewMember(MemberVo memberVo) {
        return memberMapper.insertNewMember(memberVo);
    }

    @Override
    public MemberVo selectOneMember(int id) {
        MemberVo member = memberMapper.selectOneMember(id);
        return member;
    }

    @Override
    public boolean updateOneMember(Map<String, Object> map) {
        return memberMapper.updateOneMember(map);
    }

    @Override
    public boolean deleteOneMember(Map<String, Object> map) {
        return memberMapper.deleteOneMember(map);
    }

    @Override
    public boolean realDeleteOneMember(Map<String, Object> map) {
        return memberMapper.realDeleteOneMember(map);
    }

}
