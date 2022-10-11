package cfm.SoisotaService.services;

import java.util.Date;

public class BaseService {

  public String generateCode(Long id, String key) {
    String result = "";
    Date currentDate = new Date();

    //UTC + 7
    Integer hours = currentDate.getHours() + 7;
    Integer date = currentDate.getDate();
    Integer month = currentDate.getMonth() + 1;
    Integer year = currentDate.getYear() + 1900;

    if (key == null) {
      key = "SBILL";
    }

    result = key + year + month + date + hours + id;

    return result;
  }
}
