package com.mysuperscore.validator;

import com.mysuperscore.model.Song;
import com.mysuperscore.model.User;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class FileValidator implements Validator {

	private static final int MAX_FILE_SIZE = 5 * 1024 * 1024;

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object uploadedFile, Errors errors) {

		Song song = (Song) uploadedFile;

		if (0 == song.getFile().getSize()) {
			errors.rejectValue("file", "uploadForm.selectFile",
					"Please select a file!");
		}
		if (MAX_FILE_SIZE < song.getFile().getSize()) { // 5 MB
			errors.rejectValue("file", "uploadForm.selectFile",
					"File is too big  max  5 MB!");
		}

		if (!song.getFile().getContentType().equals("image/jpeg") && !song.getFile().getContentType().equals("image/png")
				&& !song.getFile().getContentType().equals("image/svg+xml")) {
			errors.rejectValue("file", "uploadForm.selectFile",
					"File has another type.Please select jpeg, png or svg+xml");
		}
	}

	public void validateUser(Object newUser, Errors errors) {
		User user = (User) newUser;
		String password = user.getPassword();
		String passwordConfirm = user.getPasswordConfirm();

		if (!password.equals(passwordConfirm)) {
			user.setPassword("");
			user.setPasswordConfirm("");
			errors.rejectValue("passwordConfirm", "password",
					"Passwords are not equal!");
		}
	}
}
