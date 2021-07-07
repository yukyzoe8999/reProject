package pp.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pp.common.FileUtil;
import pp.common.FileVO;



@Controller
public class BoardCtr {

	@Autowired
	private BoardSvc boardSvc;
	
	@Autowired
	private UtilSvc us;
	
	@RequestMapping(value="board")
	public String BoardList(HttpServletRequest req, BoardSearchVO bo, ModelMap modelMap) {
		
		
//		String userno = req.getSession().getAttribute("userid").toString();
//		System.out.println("userno : " + userno);
		
		bo.pageCalculate(boardSvc.selectBoardCount(bo));
	
		List<?> listView = boardSvc.selectBoardList(bo);
	
		
		modelMap.addAttribute("bo",bo);
		modelMap.addAttribute("list",listView);
		
		
		return "board/board";
	}
	@RequestMapping(value = "/write")
	public String BoardWrite() {
		
		System.out.println("컨트롤러 들어옴ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ");
		
		return "board/write";
	}
	@RequestMapping(value = "/boardSave")
	public String BoardSave(HttpServletRequest req, BoardVO bv) {
		
		String userno = req.getSession().getAttribute("bid").toString();
		bv.setWriter_id(userno);
		
		String fileno[] =req.getParameterValues("fileno");
		FileUtil fs = new FileUtil(); 
		List<FileVO> fl = fs.saveAllFiles(bv.getUploadfile());
		

		for(int i=0; i<fl.size(); i++) {
			System.out.println("filelist : "+fl.toString());
		}
		
		boardSvc.insertContent(bv, fl, fileno)
;		
		
		return "board/board";
	}
	
	@RequestMapping(value = "boardRead")
	public String boardRead(HttpServletRequest request, ModelMap modelMap) {

//        String userno = request.getSession().getAttribute("userno").toString();
//        String bgno = request.getParameter("bgno");
		String bid = request.getParameter("bid");
		System.out.println("bbbbbbb아이디아이디아이디: " + bid);

		List<?> co = boardSvc.selectBoardComment(bid);
		BoardVO bo = boardSvc.selectBoardRead(bid);

		modelMap.addAttribute("bo", bo);
		modelMap.addAttribute("co", co);
		

		return "board/boardRead";
	}
	@RequestMapping(value = "boardComment")
    public String boardComment(HttpServletRequest request, ModelMap modelMap, BoardVO bv, CommentVO co) {
		
//        String userno = request.getSession().getAttribute("userno").toString();
//        String bgno = request.getParameter("bgno");
		String cid = request.getParameter("mid");
		String bid = request.getParameter("bid");
		
       System.out.println("brbrbrbrbr아이디아이디아이디: "+cid);
       System.out.println("brbrbrbrbridididididididid: "+bid);
       
        boardSvc.insertBoardComment(co);
//        int count = boardSvc.CountBoardComment(bid);
         
        modelMap.addAttribute("co", co);
//        modelMap.addAttribute("count", count);
       
        return "redirect:boardRead?bid="+cid;
    }
	@RequestMapping(value = "boarddelete")
	public String boardDelete(HttpServletRequest request, ModelMap modelMap) {

//        String userno = request.getSession().getAttribute("userno").toString();
//        String bgno = request.getParameter("bgno");
		String bid = request.getParameter("bid");
		System.out.println("deletedelete아이디아이디아이디: " + bid);

		boardSvc.deleteBoard(bid);

		return "redirect:board";
	}
	@RequestMapping(value = "Reg")
	public String boardReg(HttpServletRequest request, ModelMap modelMap) {

//        String userno = request.getSession().getAttribute("userno").toString();
//        String bgno = request.getParameter("bgno");


		return "board/Reg";
	}
	// 글 쓰기(Post)
	@RequestMapping(value="/boardReg", method=RequestMethod.POST)
	public String boardwritepost(HttpServletRequest req, BoardVO view) {
		view.setTitle(us.html2text(view.getTitle()));
		
		boardSvc.insertBoard(view);
		return "redirect:board";
	}
}
