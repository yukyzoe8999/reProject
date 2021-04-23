package pp.member;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MemberSvc {

    @Autowired
    private SqlSessionTemplate sqlSession;    
        
    
    public UserVO selectMember4Login(LoginVO param) {
        return sqlSession.selectOne("selectMember4Login", param);
    }

    public UserVO insertMember4Signup(UserVO param) {
        return sqlSession.selectOne("insertMember4Signup", param);
    }
    public int idCheck(String param) {
        return sqlSession.selectOne("idCheck", param);
    }
    
//    public void insertLogIn(String param) {
//        sqlSession.insert("insertLogIn", param);
//    }

//    public void insertLogOut(String param) {
//        sqlSession.insert("insertLogOut", param);
//    }
//    
//    public UserVO searchMember(String usernm) {
//    	return sqlSession.selectOne("searchMember",usernm);
//    }
}
