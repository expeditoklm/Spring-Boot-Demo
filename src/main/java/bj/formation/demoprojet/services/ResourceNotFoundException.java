package bj.formation.demoprojet.services;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String agent, String id, String matricule) {
    }
}