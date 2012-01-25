package mmorpg.web;

import java.io.Serializable;
import java.util.ArrayList;
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
import mmorpg.project.Character;
import mmorpg.services.*;


@SessionScoped
@Named("characterBean")
public class CharacterFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Character character = new Character(null, JobClass.Priest , 0);

	private ListDataModel<Character> characters = new ListDataModel<Character>();

	@Inject
	private CharacterDBManager characterDBManager;

	public Character getCharacter() {
		return character;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}
	
	public String addCharacter() {
		character.setJobClass(JobClass.valueOf(character.getJobClassString()));
		characterDBManager.addCharacter(character);
		return "showCharacters";
	}
		
	public ListDataModel<Character> getAllCharacters() {
		characters.setWrappedData(characterDBManager.getAllCharacters());
		return characters;
	}


	public void deleteCharacter() {
		Character characterToDelete = characters.getRowData();
		characterDBManager.deleteCharacter(characterDBManager.findCharacterByName(characterToDelete.getName()));
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
