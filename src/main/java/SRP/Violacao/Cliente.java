package SRP.Violacao;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;

public class Cliente {

    private Integer clientId;
    private String nome;
    private String email;
    private String CPF;
    private Date dataCadastro;
    private DriverManager PostgreSQL;

    public String adicionarCliente() throws SQLException {

        if (!email.contains("@")) {
            return "Cliente com e-mail inválido";
        }

        if (CPF.length() != 11) {
            return "Cliente com CPF inválido";
        }

        Connection conn = PostgreSQL.getConnection("jdbc:postgresql://127.0.0.1:5432/test");
        try {

            String sql = "INSERT INTO CLIENTE (ID, NOME, EMAIL, CPF, DATA_CADASTRO) VALUES (?,?,?,?,?)";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, clientId);
            stmt.setString(2, nome);
            stmt.setString(3, email);
            stmt.setString(4, CPF);
            stmt.setDate(5, (java.sql.Date) dataCadastro);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        final String password = "123456";

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(email, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("pantinha@domain.com"));
            message.setSubject("Testing Subject");
            message.setText("Dear Mail Crawler,"
                    + "\n\n No spam to my email, please!");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

        return "Cliente adicionado com sucesso";
    }

}
