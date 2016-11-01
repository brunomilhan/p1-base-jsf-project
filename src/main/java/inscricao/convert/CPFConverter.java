package inscricao.convert;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import java.util.regex.Pattern;

/**
 * Created by bruno on 01/11/16.
 */
@FacesConverter("cpfConverter")
public class CPFConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        String cpf = s;
        if (!Pattern.matches("^\\d{11}|\\d{9}-\\d{2}|\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$", cpf)) {
            throw new ConverterException(new FacesMessage("CPF " + cpf + " inválido"));
        }

        return cpf == null || cpf.trim().isEmpty() ? null : Long.valueOf((cpf.replace("-", "")).replace(".", ""));
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        String cpf = o.toString();
        return String.format("%s.%s.%s-%s", cpf.substring(0, 3), cpf.substring(3, 6), cpf.substring(6, 9), cpf.substring(9));
    }
}
