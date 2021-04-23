package pp.TourDetail;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TDSvc {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<?> selectLocalName(){
		return sqlSession.selectList("selectLocalName");
	}
}
