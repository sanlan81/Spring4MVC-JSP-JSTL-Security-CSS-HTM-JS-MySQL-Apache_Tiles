package com.mysuperscore.validator;

import com.mysuperscore.model.Song;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class FileValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void validate(Object uploadedFile, Errors errors) {

		Song song = (Song) uploadedFile;

		if (song.getFile().getSize() == 0) {
			errors.rejectValue("file", "uploadForm.salectFile",
					"Please select a file!");
		}
		if (song.getFile().getSize() > 5 * 1024 * 1024) { // 5 MB
			errors.rejectValue("file", "uploadForm.salectFile",
					"File is too big  max  5 MB!");
		}
	}
}
