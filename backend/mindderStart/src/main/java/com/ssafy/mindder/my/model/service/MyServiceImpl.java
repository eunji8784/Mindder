package com.ssafy.mindder.my.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.mindder.feeds.model.FeedListDto;
import com.ssafy.mindder.my.model.CalendarDto;
import com.ssafy.mindder.my.model.FollowsDto;
import com.ssafy.mindder.my.model.UserInformationDto;
import com.ssafy.mindder.my.model.mapper.MyMapper;

@Service
public class MyServiceImpl implements MyService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public UserInformationDto findUser(int userIdx) throws Exception {
		return sqlSession.getMapper(MyMapper.class).selectUser(userIdx);
	}
	
	@Override
	public List<FeedListDto> findMyFeeds(int userIdx) throws Exception {
		return sqlSession.getMapper(MyMapper.class).selectMyFeeds(userIdx);
	}
	
	@Override
	public List<FollowsDto> findMyFollowers(int userIdx) throws Exception {
		return sqlSession.getMapper(MyMapper.class).selectMyFollowers(userIdx);
	}
	
	@Override
	public List<FollowsDto> findMyFollowings(int userIdx) throws Exception {
		return sqlSession.getMapper(MyMapper.class).selectMyFollowings(userIdx);
	}
	
	@Override
	public List<CalendarDto> findMyCalendars(int month, int userIdx) throws Exception {
		return sqlSession.getMapper(MyMapper.class).selectMyCalendars(month, userIdx);
	}
	
	@Override
	public void addMyFollow(int userIdx, int targetUserIdx) throws Exception {
		sqlSession.getMapper(MyMapper.class).insertMyFollow(userIdx, targetUserIdx);
	}
	
	@Override
	public void removeMyFollow(int userIdx, int targetUserIdx) throws Exception {
		sqlSession.getMapper(MyMapper.class).deleteMyFollow(userIdx, targetUserIdx);
	}
	
}
