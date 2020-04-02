package org.zerock.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.AuthVO;
import org.zerock.domain.MemberVO;
import org.zerock.service.MemberService;

@Controller
@RequestMapping("/member/")
public class MemberController {
	@Autowired
	private MemberService service;

//	ȸ�� ���� ��
	@GetMapping("/register")
	public String register() {
		return "member/register";
	}

//	ȸ�� ����
	@PostMapping("/register")
	public String register(MemberVO member, AuthVO auth) {
		service.register(member, auth);
		return "redirect:/";
	}

//	���θ��ּ� API �˾�
	@GetMapping("/popup")
	public String popup() {
		return "/member/popup/jusoPopup";
	}

	@PostMapping("/popup")
	public String popupPost() {
		return "/member/popup/jusoPopup";
	}

//	���̵� �ߺ� üũ
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

//	�������� ��
	@GetMapping("/modify")
	@PreAuthorize("isAuthenticated()")
	public void modify(String userid, Model model) {
		MemberVO member = service.get(userid);
		model.addAttribute("member", member);
	}

//	���� ����
	@PostMapping("/modify")
	@PreAuthorize("isAuthenticated()")
	public String modfiy(MemberVO member, AuthVO auth) {
		service.modify(member, auth);
		return "redirect:/";
	}

//	ȸ�� Ż��
	@GetMapping("/delete")
	public String delete(String id, Model model) {
		MemberVO member = service.get(id);
		service.delete(member);
		model.addAttribute("tmp","yes");
		return "redirect:/customLogout";
	}

//	�α��� üũ	
	@GetMapping("/loginCheck")
	@ResponseBody
	public String login(String userid, String password) {
		String chkId = service.idcheck(userid);

		if (chkId == null) {
			return "no";
		} else {
			MemberVO member = service.get(userid);
			if (member.getUserpw().equals(password)) {
				return "success";
			} else {
				return "fail";
			}
		}

	}

}