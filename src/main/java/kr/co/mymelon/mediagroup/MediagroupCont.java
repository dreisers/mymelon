package kr.co.mymelon.mediagroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.utility.Utility;

@Controller
public class MediagroupCont {
	// 자동으로 생성된 객체를 서로 연결 스프링 컨터이너에 이미 객체가 생성되어
	// 있으므로 별도로 new MediaGroipDAO() 하지 않아도 된다
	@Autowired
	MediagroupDAO dao;
	
	public MediagroupCont() {
		System.out.println("----MediagroupCont() 객체 생성");
	}

// mymelon 프로젝트의 첫 페이지 호출 
// http://localhost:9090/mymelon/mediagroup/list.do

// 미디어그룹 쓰기 페이지 호출
// http://localhost:9090/mymelon/mediagroup/create.do
	@RequestMapping(value="/mediagroup/create.do", method=RequestMethod.GET)
	public String createForm() {
		return "mediagroup/createForm";
	}
	
	@RequestMapping(value="/mediagroup/create.do", method=RequestMethod.POST)
	public ModelAndView createProc(MediagroupDTO dto) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mediagroup/msgView");
		
		int cnt = 0;
		cnt=dao.create(dto);
		if(cnt==0) {
			mav.addObject("msg1", "<p>미디어 그룹 등록 실패</p>");
			mav.addObject("img", "<img src='../images/fail.png'>");
			mav.addObject("link1", "<input type='button' value='다시시도' onclick='javascrip:thistory.back()'>");
			mav.addObject("link2", "<input type='button' value='그룹목록' onclick='location.href=\"./list.do\"'>");
			
		}else {
			mav.addObject("msg1", "<p>미디어 그룹 등록 성공</p>");
			mav.addObject("img", "<img src='../images/sound.png'>");
			mav.addObject("link1", "<input type='button' value='계속등록' onclick='location.href\"./create.do\"'>");
			mav.addObject("link2", "<input type='button' value='그룹목록' onclick='location.href=\"./list.do\"'>");
		}//if end
		return mav;
		
	}
	
	@RequestMapping("/mediagroup/list.do")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mediagroup/list");
		mav.addObject("root", Utility.getRoot());
		mav.addObject("list", dao.list());
		return mav;
		
	}
	@RequestMapping(value="/mediagroup/delete.do", method=RequestMethod.GET)
	public ModelAndView deleteForm(MediagroupDTO dto) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mediagroup/deleteForm");
		mav.addObject("root", Utility.getRoot());
		mav.addObject("dto", dto);
		return mav;
	}
	
	@RequestMapping(value="/mediagroup/delete.do", method=RequestMethod.POST)
	public ModelAndView deleteProc(MediagroupDTO dto) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mediagroup/msgView");
		
		int cnt = dao.delete(dto);
		if(cnt==0) {
			mav.addObject("msg1", "<p>미디어 그룹 삭제 실패</p>");
			mav.addObject("img", "<img src='../images/fail.png'>");
			mav.addObject("link1", "<input type='button' value='다시시도' onclick='javascrip:thistory.back()'>");
			mav.addObject("link2", "<input type='button' value='그룹목록' onclick='location.href=\"./list.do\"'>");
			
		}else {
			mav.addObject("msg1", "<p>미디어 그룹 삭제 성공</p>");
			mav.addObject("img", "<img src='../images/sound.png'>");
			mav.addObject("link2", "<input type='button' value='그룹목록' onclick='location.href=\"./list.do\"'>");
		}//if end
		return mav;
		
	}
	
	
	@RequestMapping(value="/mediagroup/update.do", method=RequestMethod.GET)
		public ModelAndView updateForm(MediagroupDTO dto) {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("mediagroup/updateForm");
			mav.addObject("root", Utility.getRoot());
			mav.addObject("dto", dto);
			return mav;
	}
	
	@RequestMapping(value="/mediagroup/update.do", method=RequestMethod.POST)
	public ModelAndView updateProc(MediagroupDTO dto) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mediagroup/msgView");
		
		int cnt = dao.update(dto);
		if(cnt==0) {
			mav.addObject("msg1", "<p>미디어 그룹 수정 실패</p>");
			mav.addObject("img", "<img src='../images/fail.png'>");
			mav.addObject("link1", "<input type='button' value='다시시도' onclick='javascrip:thistory.back()'>");
			mav.addObject("link2", "<input type='button' value='그룹목록' onclick='location.href=\"./list.do\"'>");
			
		}else {
			mav.addObject("msg1", "<p>미디어 그룹 수정 성공</p>");
			mav.addObject("img", "<img src='../images/sound.png'>");
			mav.addObject("link2", "<input type='button' value='그룹목록' onclick='location.href=\"./list.do\"'>");
		}//if end
		return mav;
		
	}
	
}//class end