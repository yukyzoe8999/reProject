package pp.main;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class indexSvc {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<?> selectMainInfo(){
		return sqlSession.selectList("selectMainInfo");
	}
}
