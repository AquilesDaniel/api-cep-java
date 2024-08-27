package API_ViaCep;
public class FormatJson {
  // Algoritmo para formatar o JSON
  public static String formatJson(String json) {
    StringBuilder formattedJson = new StringBuilder();
    String indent = "";
    boolean inQuote = false;

    for (char charFromJson : json.toCharArray()) {
      switch (charFromJson) {
        case '"':
          formattedJson.append(charFromJson);
          inQuote = !inQuote;
          break;
        case ' ':
          if (inQuote) {
            formattedJson.append(charFromJson);
          }
          break;
        case '{':
        case '[':
          formattedJson.append(charFromJson);
          if (!inQuote) {
            formattedJson.append("\n");
            indent += "  ";
            formattedJson.append(indent);
          }
          break;
        case '}':
        case ']':
          if (!inQuote) {
            formattedJson.append("\n");
            indent = indent.substring(0, indent.length() - 2);
            formattedJson.append(indent);
          }
          formattedJson.append(charFromJson);
          break;
        case ',':
          formattedJson.append(charFromJson);
          if (!inQuote) {
            formattedJson.append("\n");
            formattedJson.append(indent);
          }
          break;
        case ':':
          formattedJson.append(charFromJson);
          if (!inQuote) {
            formattedJson.append(" ");
          }
          break;
        default:
          formattedJson.append(charFromJson);
          break;
      }
    }
    return formattedJson.toString();
  }
}
