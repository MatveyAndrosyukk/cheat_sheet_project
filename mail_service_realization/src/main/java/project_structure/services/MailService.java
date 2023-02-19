package project_structure.services;

public interface MailService {
    public void send(String to, String subject, String text);
}
