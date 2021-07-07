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

import org.springframework.stereotype.Service;

@Service
public class UtilSvc {
    public String html2text(String txt) {
        txt = txt.replaceAll(" ", "&nbsp");
    	txt = txt.replace("<","&lt;");
    	txt = txt.replace(">","&gt;");
    	return txt.replaceAll("\n", "<br>");
    } 
}
