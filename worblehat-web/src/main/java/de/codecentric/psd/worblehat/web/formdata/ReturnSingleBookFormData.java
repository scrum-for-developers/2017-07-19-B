package de.codecentric.psd.worblehat.web.formdata;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * This class represent the form data of the return book form.
 */
public class ReturnSingleBookFormData {

	@NotEmpty(message = "{empty.returnSingleBookFormData.isbn}")
	private String isbn;
	
	@NotEmpty(message = "{empty.returnSingleBookFormData.emailAddress}") 
	@Email(message = "{notvalid.returnSingleBookFormData.emailAddress}")
	private String emailAddress;

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

}
