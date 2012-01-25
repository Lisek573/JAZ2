package mmorpg.web;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.model.ListDataModel;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;

import mmorpg.project.*;
import mmorpg.services.*;


@SessionScoped
@Named("accountBean")
public class AccountFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	Account account = new Account(null, null);

	ListDataModel<Account> accounts = new ListDataModel<Account>();

	@Inject
	AccountDBManager accountDBManager = new AccountDBManager();

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	public String addAccount() {
		accountDBManager.addAccount(account);
		return "showAccounts";
	}
		
	public ListDataModel<Account> getAllAccounts() {
		accounts.setWrappedData(accountDBManager.getAllAccounts());
		return accounts;
	}


	public void deleteAccount() {
		Account accountToDelete = accounts.getRowData();
		accountDBManager.deleteAccount(accountDBManager.findAccountByName(accountToDelete.getName()));
	}

/*
	// Validators

	// Business logic validation
	public void uniquePin(FacesContext context, UIComponent component,
			Object value) {

		String pin = (String) value;

		for (Account account : pm.getAllAccounts()) {
			if (account.getPin().equalsIgnoreCase(pin)) {
				FacesMessage message = new FacesMessage(
						"Account with this PIN already exists in database");
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(message);
			}
		}
	}

	// Multi field validation with <f:event>
	// Rule: first two digits of PIN must match last two digits of the year of
	// birth
	public void validatePinDob(ComponentSystemEvent event) {

		UIForm form = (UIForm) event.getComponent();
		UIInput pin = (UIInput) form.findComponent("pin");
		UIInput dob = (UIInput) form.findComponent("dob");

		if (pin.getValue() != null && dob.getValue() != null
				&& pin.getValue().toString().length() >= 2) {
			String twoDigitsOfPin = pin.getValue().toString().substring(0, 2);
			Calendar cal = Calendar.getInstance();
			cal.setTime(((Date) dob.getValue()));

			String lastDigitsOfDob = ((Integer) cal.get(Calendar.YEAR))
					.toString().substring(2);

			if (!twoDigitsOfPin.equals(lastDigitsOfDob)) {
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(form.getClientId(), new FacesMessage(
						"PIN doesn't match date of birth"));
				context.renderResponse();
			}
		}
	}
*/

}
