package org.zerock.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.zerock.domain.MemberVO;
import org.zerock.service.MemberServiceImpl;

@SessionAttributes("id")
@Controller
@RequestMapping("/member/")
public class MemberController {
	@Autowired
	MemberServiceImpl service;

//	회원 가입 폼
	@GetMapping("/register")
	public String register() {
		return "member/register";
	}

//	회원 가입
	@PostMapping("/register")
	public String register(MemberVO member) {
		service.register(member);
		return "redirect:/";
	}

//	도로명주소 API 팝업
	@RequestMapping("/popup")
	public String popup() {
		return "/member/popup/jusoPopup";
	}

//	아이디 중복 체크
	@GetMapping("/idcheck")
	@ResponseBody
	public String idcheck(String id) {
		String chkId = service.idcheck(id);
//		System.out.println(chkId);

		if (chkId == null) {
//			System.out.println("yes");
			return "yes";
		} else {
//			System.out.println("no");
			return "no";
		}

	}

//	로그인 폼
	@GetMapping("/loginForm")
	public String login() {
		return "member/login";
	}

//	로그인
	@GetMapping("/login")
	public String login(Model model, String id) {
		model.addAttribute("id", id);
		return "redirect:/";
	}
//	로그아웃
	@GetMapping("/logout")
	public String logout(SessionStatus session) {
		session.setComplete();
		return "redirect:/";
	}
	
	
//	로그인 체크
	@GetMapping("/loginCheck")
	@ResponseBody	
	public String login(String id, String password) {
		String chkId = service.idcheck(id);

		if (chkId == null) {
			return "no";
		} else {
			MemberVO member = service.get(id);
			if (member.getPassword().equals(password)) {
				return "success";
			} else {
				return "fail";
			}
		}

	}

}
