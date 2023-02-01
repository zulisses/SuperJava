package baseClasses;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contato {

    private String email;
    private String telefone;

    public Contato() {
    }

    public Contato(String email, String telefone) {
        this.email = email;
        this.telefone = telefone;
    }

    public void set(String email, String telefone) {
        this.email = email;
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public static String validaTelefone(String telefone) throws IOException {
        if (telefone.isEmpty()) {
            throw new IOException("Insira o telefone!");
        }

        //[0-9]{2})?(\s|-)?(9?[0-9]{4})-?([0-9]{4}
        Pattern pattern = Pattern.compile("\\(?[1-9]{2}\\)? ?9[1-9][0-9]{3}\\-?[0-9]{4}");
        Matcher matcher = pattern.matcher(telefone);
        if (matcher.find()) {
            if (telefone.charAt(0) != '(') {
                telefone = "(" + telefone.substring(0);
            }
            if (telefone.charAt(3) != ')') {
                telefone = telefone.substring(0, 3) + ")" + telefone.substring(3);
            }
            if (telefone.charAt(4) != ' ') {
                telefone = telefone.substring(0, 4) + " " + telefone.substring(4);
            }
            if (telefone.charAt(10) != '-') {
                telefone = telefone.substring(0, 10) + "-" + telefone.substring(10);
            }
        } else {
            throw new IOException("Telefone invalido!");
        }
        return telefone;
    }

    public static String validaEmail(String email) throws IOException {
        if (email.isEmpty()) {
            throw new IOException("Insira o email!");
        }

        Pattern pattern = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
        Matcher matcher = pattern.matcher(email);
        if (!matcher.find()) {
            throw new IOException("Email invalido!");
        }
        return email;
    }

}
