package API_ViaCep;
import javax.swing.JOptionPane;

public class Erro extends RuntimeException {
  public Erro(String mensagemDeErro){
    JOptionPane.showMessageDialog(
      null,
      mensagemDeErro,
      "⚠",
      JOptionPane.ERROR_MESSAGE);
  }
}
