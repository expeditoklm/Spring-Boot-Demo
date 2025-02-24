package bj.formation.demoprojet.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HttpResponse<T> {
    private int statusCode;
    private String message;
    private T data;
    private long timestamp;
    private boolean success;
    private Map<String, Object> meta;
    private List<String> errors;
    private String path;
}