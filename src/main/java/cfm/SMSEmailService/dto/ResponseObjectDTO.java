package cfm.SoisotaService.dto;

import lombok.Data;

@Data
public class ResponseObjectDTO {

  private boolean success;
  private String message;
  private Object data;

  public ResponseObjectDTO(boolean success, String message, Object data) {
    this.success = success;
    this.message = message;
    this.data = data;
  }
}
