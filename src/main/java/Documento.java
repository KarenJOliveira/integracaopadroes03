import java.util.Observable;

public class Documento extends Observable {
    private String descricao;
    private DocumentoEstado estado;

    public Documento(String descricao)
    {
        this.descricao = descricao;
        this.estado = DocumentoEstadoNovo.getInstance();
    }

    public void atualizarDocumento()
    {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString()
    {
        return "Documento "+descricao+" "+estado.getEstado();
    }

    public DocumentoEstado getEstado()
    {
        return estado;
    }

    public void setEstado(DocumentoEstado estado)
    {
        this.estado = estado;
    }

    public boolean novo()
    {
        boolean result = estado.novo(this);
        if (result) atualizarDocumento();
        return result;
    }

    public boolean analisar()
    {
        boolean result = estado.analisar(this);
        if (result) atualizarDocumento();
        return result;
    }

    public boolean corrigir()
    {
        boolean result = estado.corrigir(this);
        if (result) atualizarDocumento();
        return result;
    }

    public boolean aprovar()
    {
        boolean result = estado.aprovar(this);
        if (result) atualizarDocumento();
        return result;
    }

    public boolean reprovar()
    {
        boolean result = estado.reprovar(this);
        if (result) atualizarDocumento();
        return result;
    }
}
