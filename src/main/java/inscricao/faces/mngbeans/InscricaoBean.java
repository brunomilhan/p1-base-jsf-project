package inscricao.faces.mngbeans;

import inscricao.entity.Candidato;
import inscricao.entity.Idioma;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.ArrayDataModel;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;
import utfpr.faces.support.PageBean;

/**
 *
 * @author Wilson
 */
@Named
@RequestScoped
public class InscricaoBean extends PageBean {

    @Inject
    private RegistroBean registroBean = new RegistroBean();
    
    private static final Idioma[] IDIOMAS = {
        new Idioma(1, "Inglês"),
        new Idioma(2, "Alemão"),
        new Idioma(3, "Francês")
    };
    
    private Candidato candidato = new Candidato(IDIOMAS[0]); // inicialmente ingles
    private List<SelectItem> idiomaItemList;
    private ArrayDataModel<Idioma> idiomasDataModel;

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public Idioma[] getIdiomas() {
        return IDIOMAS;
    }
    
    public List<SelectItem> getIdiomaItemList() {
        if (idiomaItemList != null) return idiomaItemList;
        idiomaItemList = new ArrayList<>();
        for (Idioma id: IDIOMAS) {
            idiomaItemList.add(new SelectItem(id.getCodigo(), id.getDescricao()));
        }
        return idiomaItemList;
    }
    
    public ArrayDataModel<Idioma> getIdiomasDataModel() {
        if (idiomasDataModel == null) {
            idiomasDataModel = new ArrayDataModel<>(IDIOMAS);
        }
        return idiomasDataModel;
    }

    public String confirmaAction() {
        candidato.setDataHora(new Date());
        candidato.setIdioma(IDIOMAS[candidato.getIdioma().getCodigo()-1]);
        registroBean.save(candidato);
        return "confirma";
    }
}
