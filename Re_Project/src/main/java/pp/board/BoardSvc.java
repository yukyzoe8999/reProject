package pp.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import pp.common.FileVO;

@Service
public class BoardSvc {

	@Autowired
	private DataSourceTransactionManager dtm;

	@Autowired
	private SqlSessionTemplate sqlSession;

	public Integer selectBoardCount(BoardSearchVO param) { // board row 카운트

		return sqlSession.selectOne("selectBoardCount", param);
	}

	public List<?> selectBoardList(BoardSearchVO param) { // board list 출력

		return sqlSession.selectList("selectBoardList", param);
	}

	public BoardVO selectBoardRead(String brdno) {

		return sqlSession.selectOne("selectBoardRead", brdno);
	}

	public CommentVO insertBoardComment(CommentVO param) {
		return sqlSession.selectOne("insertBoardComment", param);
	}

	public List<?> selectBoardComment(String param) {
		return sqlSession.selectList("selectBoardComment", param);
	}

	public BoardVO deleteBoard(String param) {

		return sqlSession.selectOne("deleteBoard", param);
	}

	public void insertContent(BoardVO bv, List<FileVO> fl, String[] fileno) {
		DefaultTransactionDefinition dtd = new DefaultTransactionDefinition();
		TransactionStatus ts = dtm.getTransaction(dtd);
		String number = Integer.toString(bv.getBid());

		sqlSession.insert("insertContent", bv);

		for (FileVO f : fl) {
			f.setParentPK(number);
			sqlSession.insert("insertFile");
		}

	}
	public Integer CountBoardComment(String param) { // board comment 카운트

		return sqlSession.selectOne("CountBoardComment", param);
	}
}
