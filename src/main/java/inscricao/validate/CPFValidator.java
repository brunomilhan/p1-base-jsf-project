package inscricao.validate;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.regex.Pattern;

/**
 * Created by bruno on 01/11/16.
 */
@FacesValidator("cpfValidator")
public class CPFValidator implements Validator {

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        String cpf = o.toString();
        if (!Pattern.matches("^\\d{11}|\\d{9}-\\d{2}|\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$", cpf)) {
            throw new ValidatorException(new FacesMessage("CPF " + cpf + " inválido"));
        }
    }
}
