import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CartorioTest {
    @Test
    void deveNotificarNovoDocumento()
    {
        Documento documento = new Documento("Certidão de Nascimento");
        Cartorio cartorio = new Cartorio("Juiz de Fora");

        documento.addObserver(cartorio);
        documento.atualizarDocumento();

        assertEquals("Documento Certidão de Nascimento novo", cartorio.getUltimaAtualizacao());
    }

    @Test
    void deveNotificarDocumentoEmAnalise()
    {
        Documento documento = new Documento("Certidão de Casamento");
        Cartorio cartorio = new Cartorio("Juiz de Fora");
        documento.addObserver(cartorio);

        assertTrue(documento.analisar());
        documento.atualizarDocumento();

        assertEquals("Documento Certidão de Casamento em análise", cartorio.getUltimaAtualizacao());
    }

    @Test
    void deveNotificarDocumentoAprovado()
    {
        Documento documento = new Documento("Certidão de Óbito");
        Cartorio cartorio = new Cartorio("Juiz de Fora");
        documento.addObserver(cartorio);

        assertTrue(documento.analisar());
        assertTrue(documento.aprovar());
        documento.atualizarDocumento();

        assertEquals("Documento Certidão de Óbito aprovado", cartorio.getUltimaAtualizacao());
    }

    @Test
    void deveNotificarDocumentoReprovado()
    {
        Documento documento = new Documento("Certidão de Óbito");
        Cartorio cartorio = new Cartorio("Juiz de Fora");
        documento.addObserver(cartorio);    

        assertTrue(documento.analisar());
        assertTrue(documento.reprovar());
        documento.atualizarDocumento();

        assertEquals("Documento Certidão de Óbito reprovado", cartorio.getUltimaAtualizacao());
    }

    @Test
    void deveNotificarDocumentoCorrigido()
    {
        Documento documento = new Documento("Certidão de Óbito");
        Cartorio cartorio = new Cartorio("Juiz de Fora");
        documento.addObserver(cartorio);    

        assertTrue(documento.analisar());
        assertTrue(documento.corrigir());
        documento.atualizarDocumento();

        assertEquals("Documento Certidão de Óbito corrigido", cartorio.getUltimaAtualizacao());
    }
}
