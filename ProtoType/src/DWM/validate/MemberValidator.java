package DWM.validate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import DWM.dao.MemberDao;
import DWM.vo.MemberVO;

@Service("memberValidator")
public class MemberValidator implements Validator {
	@Autowired
	private MemberDao memberdao;

	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}

	@Override
	public void validate(Object member, Errors errors) {
		MemberVO member02 = (MemberVO) member;
		System.out.println(member02.getId() + "   id");
		System.out.println(member02.getPassword() + "   pw");

		if (member02 != null) {
			if (member02.getId().isEmpty()) {
				errors.rejectValue("id", "no id", "ID를 입력하세요");
			}
		}
		if (member02.getPassword().isEmpty()) {
			errors.rejectValue("password", "no password", "Password를 입력하세요");
		}
	}
}
