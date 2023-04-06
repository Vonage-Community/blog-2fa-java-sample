package two.factor.auth;

import static spark.Spark.*;
import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.ModelAndView;
import com.vonage.client.VonageClient;
import com.vonage.client.verify.*;

public class App {
  static final String API_KEY = "YOUR_API_KEY", API_SECRET = "YOUR_API_SECRET";
  static String number, requestId;

  public static void main(String[] args) {
    port(3000);
    staticFiles.location("/public");

    VonageClient client = VonageClient.builder().apiKey(API_KEY).apiSecret(API_SECRET).build();

    get("/", (request, response) -> {
      return new ModelAndView(null, "register.hbs");
    }, new HandlebarsTemplateEngine());

    post("/register", (request, response) -> {
      number = request.queryParams("number");

      VerifyResponse verifyResponse = client.getVerifyClient().verify(number, "VONAGE");
      if (verifyResponse.getStatus() == VerifyStatus.OK) {
        requestId = verifyResponse.getRequestId();
        System.out.printf("RequestID: %s", requestId);
      }
      else {
        System.out.printf("ERROR! %s: %s", verifyResponse.getStatus(), verifyResponse.getErrorText());
      }

      return new ModelAndView(null, "verify.hbs");
    }, new HandlebarsTemplateEngine());

    post("/check", (request, response) -> {
      String code = request.queryParams("code");
      CheckResponse checkResponse = client.getVerifyClient().check(requestId, code);
      return new ModelAndView(null, checkResponse.getStatus() == VerifyStatus.OK ? "success.hbs" : "failed.hbs");

    }, new HandlebarsTemplateEngine());

  }
}
