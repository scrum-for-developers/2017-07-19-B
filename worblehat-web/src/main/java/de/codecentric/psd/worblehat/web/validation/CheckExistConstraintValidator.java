package de.codecentric.psd.worblehat.web.validation;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import de.codecentric.psd.worblehat.domain.BookService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckExistConstraintValidator implements ConstraintValidator<CheckExist, String> {

	private BookService bookService;
	
	@Override
	public void initialize(CheckExist constraintAnnotation) {
	}

	@Autowired
	public CheckExistConstraintValidator(BookService bookService) {
		this.bookService = bookService;
	}
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// Don't validate null, empty and blank strings, since these are validated by @NotNull, @NotEmpty and @NotBlank
		if(StringUtils.isNotBlank(value)) {
			//return StringUtils.isNumeric(value);
			boolean test = bookService.bookExists(value);
			return test;
			//return false;
		}
		return true;
	}

}
