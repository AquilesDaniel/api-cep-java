package API_ViaCep;
import java.io.BufferedReader; // Importa a classe BufferedReader dpara ler o fluxo de entrada de daos.
import java.io.InputStreamReader; // Importa a classe InputStreamReader para converter o fluxo de entrada de bytes em caracteres.
import java.net.HttpURLConnection; // Importa a classe HttpURLConnection para fazer a conexão HTTP.
import java.net.URL; // Importa a classe URL para representar uma URL.
import javax.swing.JOptionPane; // Importa a classe JOptionPane para criar diálogos de entrada e saída de dados.

public class ViaCEP {
  public static void main(String[] args) {
    try {
      // Cria uma caixa de diálogo para o usuário inserir o CEP.
      String cep = JOptionPane.showInputDialog(
          null,
          "Coloque o cep",
          null,
          JOptionPane.QUESTION_MESSAGE);

      // Cria a URL para acessar a API ViaCEP com o CEP inserido pelo usuário.
      URL url = new URL("http://viacep.com.br/ws/" + cep + "/json/");

      // Abre a conexão HTTP.
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();

      // Define o método de requisição como GET.
      connection.setRequestMethod("GET");

      // Cria um BufferedReader para ler a resposta da API.
      BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      // StringBuilder para construir a resposta.
      StringBuilder response = new StringBuilder();
      // Variável para armazenar cada linha lida.
      String line;

      // Lê cada linha da resposta da API e adiciona ao StringBuilder.
      while ((line = reader.readLine()) != null) {
        response.append(line);
      }

      reader.close(); // Fecha o BufferedReader.
      connection.disconnect(); // Fecha a conexão HTTP.

      String formattedJson = FormatJson.formatJson(response.toString());

      // Exibe a resposta da API em uma caixa de diálogo.
      JOptionPane.showMessageDialog(
          null,
          formattedJson,
          "Cep em json formatado",
          JOptionPane.INFORMATION_MESSAGE);

    } catch (Exception e) {
      e.printStackTrace(); // Imprime a pilha de erros.
      throw new Error("Erro na conexão"); // Erro personalizado
    }
  }
}
