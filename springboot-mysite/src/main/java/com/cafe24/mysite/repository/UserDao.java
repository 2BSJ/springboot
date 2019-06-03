package com.cafe24.mysite.repository;

import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.mysite.exception.UserDaoException;
import com.cafe24.mysite.vo.UserVo;

@Repository
public class UserDao {
	@Autowired
	private SqlSession sqlSession;
	
	public UserVo get(Long no){
		return sqlSession.selectOne("user.getByNo", no);
	}
	
	public UserVo get(String email) {
		return sqlSession.selectOne("user.getByEmail", email);
	}
	
	public UserVo get(String email, String password) throws UserDaoException {
		Map<String, String> map = new HashMap<String, String>();
		map.put("email", email);
		map.put("password", password);
		UserVo userVo = sqlSession.selectOne("user.getByEmailAndPassword", map);
		
		return userVo;
	}	
	
	public Boolean insert(UserVo vo) {
		
		int count = sqlSession.insert("user.insert", vo);
		
		return 1 == count;
	}	
}