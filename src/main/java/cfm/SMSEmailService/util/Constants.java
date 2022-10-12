package cfm.SMSEmailService.util;

public class Constants {

  public static final int SECRET_SIZE = 10;

  // Replace with your email here:
  public static final String MY_EMAIL = "soisotaqbu@gmail.com";

  // Replace password!!
  public static final String MY_PASSWORD = "fmbatcubyabvkqeh";

  // And receiver!
  public static final String FRIEND_EMAIL = "nhanqbu@gmail.com";

  public interface RSA_KEY {

    public static final String PUBLIC_KEY =
        "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA1EM01HjIufZ5fWsVRlGmgm8Mz1/7ex8OsPic2+48Qt"
            + "+MZWvRkfgq9Ysbd0OJeuMBBfjc/BnXF7cr1FP3sIeh3DxWGXi4lKaiwR17yv02"
            + "/233nzPtmLotempfHjpwdn0rgdnQ107t9cCgf8Lgoo05A2JDbKF5qfVN8Qd8hP8us1LUR0LXfczaSvw045DBahO3DKYOF/Ik66MdusODgmVD7gmdP2hvG9dCmT4XcSVBHFn/ESngh0P14GGqUAbEMzNeFmVjM+4j7FU275KuDwTWNRymMGo7a66hgedZdxuyB62TcThDBffddGc/bcNnA6uWFljc+hnB2bTOt0Hs34DBPwIDAQAB";
    public static final String PRIVATE_KEY =
        "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDUQzTUeMi59nl9axVGUaaCbwzPX/t7Hw6w+Jzb7jxC34xla9GR"
            + "+Cr1ixt3Q4l64wEF+Nz8GdcXtyvUU/ewh6HcPFYZeLiUpqLBHXvK/Tb/bfefM+2Yui16al8eOnB2fSuB2dDXTu31wKB"
            + "/wuCijTkDYkNsoXmp9U3xB3yE/y6zUtRHQtd9zNpK/DTjkMFqE7cMpg4X8iTrox26w4OCZUPuCZ0"
            + "/aG8b10KZPhdxJUEcWf8RKeCHQ"
            + "/XgYapQBsQzM14WZWMz7iPsVTbvkq4PBNY1HKYwajtrrqGB51l3G7IHrZNxOEMF9910Zz9tw2cDq5YWWNz6GcHZtM63QezfgME/AgMBAAECggEBAKYmxV/b/CO1D3xhKhIVL+XBz6E0XMIPmYxlz0NIxNsD6f4p264LOHVkImfE8gTDVLW8DB86iugBdcmKwMPqJ4UhpbPij3msxpGr5o8KjtZ62e5A06dNdPPx9+rNi+L0L+5A9fzTx+kqk3fur7AOI6bGcEjETVwArLYTSiFBLukma+PMPgG1n7+d+V2/0IXJAg1B/AETxnvSkwngheHBr0K99qUCAW5AwKF2p2FrGWSlBlog8Nl4U7/bqbFmCifLa9xmA+07V4cmbJbJvF1YZt+HyeRzO40j8qKCTnoh7Z87b49MxwjwVPZuo/H/M28rjmV2u5j0AjFOQUMnzYVl3QECgYEA8UIGV6Dw1oq3Rw+E0PXQPtECOrAdypGXMSPNy1eouHZ27eFKpbdkUgB9aXxT5UCc86Oa4zthcw6vdlMHAbMYRWMvUxWK9NL6dDr/u+PVnIDSC1arK336b4n0fcZs6iIzz+Lxc5ad7Dmi4y5FrQvxnEcgzzxUKOQUR5HnJyM6xp8CgYEA4TucBhxbdVzqKVBCFQjiuC0/dJ2LsnETiPZGn2JKSGp48sf3Y7Wt7iFjrUwYTmLNdSVNn0m5IDDaarI027jTwe4vxgwRHtadeLlLDPYBJ4AKSIzUuEw94yuQKn56kGYjmSUZr87jTfRi8FDNNDytRdX66GVTmrq9ZhBAHv6/IWECgYEA2sitR7pDrcuN+XsxTu4cM1sHUoF0AseU/JMjhUuxTdbgc0jjkPSGnXakRIzi5/t4Wdn8FCU9ckHXDM6ug/QOBp6zw/y9TtglGFKIp7MtfAe2c2HdSEuuWIgamBThoFHz+oorvE7SV+7MsIi91vgF21sFfemPyKVNXroJjYx9OLECgYAj/+4ZP/ESWi6HOe/GAuyR+ZF55zCL7ezsaEizcvdiiboZPAL7qe9J74ZKDa6Y4MvsHHFCs3rmfUh74031jJ40EgkKw6T849q5kAxB3xQiJyH9pJzfdDg0FiNt11dpuxmXgcmQQyYrsJMbzB5waf5b+i6ndIKfaZeaN6C4E4mjIQKBgQDS3msCwe0E1ybF4fQhrrzXRccQxbvcMWElf4PXNrFHaCv98wAXVA1jcTxuP87bfQCq5/gvM0Ue7BwbfHg2ftnnKbPaelIvIhah1XVmI02YA+8fqOHtc3LvRr1rF08bD/PyCexYjt02PnR+8D6ScZMdlzlZEZenbnQByyqc71S1KQ==";
  }

  public interface CDATA {

    public static final String START_TAG = "<![CDATA[";
    public static final String END_TAG = "]]>";
  }

  public interface ENVELOP_TAG_ENCODE {

    public static final String OPEN_TAG = "&amp;lt;Envelope&amp;gt;";
    public static final String CLOSE_TAG = "&amp;lt;/Envelope&amp;gt;";
  }

  public interface TAG_ENCODE {

    public final static String OPEN_TAG = "&amp;lt;";
    public static final String CLOSE_TAG = "&amp;gt;";
    public static final String UNKNOW_TAG = "";
    public static final String AND_TAG = "&amp;";
  }

  public interface TAG_NO_ENCODE {

    public final static String OPEN_TAG = "<";
    public static final String CLOSE_TAG = ">";
    public static final String AND_TAG = "&";
  }

  public interface OPERATOR {

    public final static int INSERT = 1;
    public final static int UPDATE = 2;

  }

  public interface STATUSTRANS {

    public final static int GUI_SECRETKEY_LOI = 0;
    public final static int DA_GUI_SECRETKEY = 1;
  }

  public interface RESPONSE_MESSAGE {

    public final static String SUCCESS_CODE_TOTP_CREATE = "Tiếp nhận yêu cầu và tạo Secret Key thành công";
    public final static String SUCCESS_PUBLICKEY_CREATE = "Tiếp nhận yêu cầu và tạo Publics Key thành công";
    public final static String SUCCESS_CODE_TOTP_AUTH = "Mã OTP hợp lệ";
    public final static String SUCCESS_CODE_JWT_AUTH = "Tạo JWT thành công";

    public final static String ERROR_CODE_TOTP_CREATE = "Tiếp nhận yêu cầu và tạo Secret Key không thành công";
    public final static String ERROR_CODE_JWT_AUTH = "Quyền truy cập không hợp lệ";
    public final static String ERROR_CODE_JWT_VERIRY = "JWT truy cập không hợp lệ";
    public final static String ERROR_CODE_SYSTEM = "Hệ thống đang bảo trì";
    public final static String ERROR_CODE_TOTP_AUTH = "Mã OTP không hợp lệ";
    public final static String ERROR_USER_JWT_AUTH = "Tài khoản nhận JWT không tồn tại trong hệ thống";
    public final static String ERROR_USER_TOTP_AUTH = "Tài khoản xác thực không tồn tại trong hệ thống";
  }
}
