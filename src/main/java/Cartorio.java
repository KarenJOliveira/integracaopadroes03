import java.util.Observable;
import java.util.Observer;

public class Cartorio implements Observer {
    private String cidade;
    private String ultimaAtualizacao;

    public Cartorio(String cidade)
    {
        this.cidade = cidade;
    }

    public String getUltimaAtualizacao()
    {
        return ultimaAtualizacao;
    }

    public void registrarDocumento(Documento documento)
    {
        documento.addObserver(this);
    }

    public void update(Observable documento, Object arg1) {
        this.ultimaAtualizacao = documento.toString();
    }
}
