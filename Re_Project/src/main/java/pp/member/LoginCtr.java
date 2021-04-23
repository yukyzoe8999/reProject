package pp.member;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginCtr {    
    private static final Integer cookieExpire = 60 * 60 * 24 * 30; // 1 month
    
    @Autowired
    private MemberSvc memberSvc;
    
    /**
     * 로그인화면.
     * @throws UnsupportedEncodingException 
     */
    @RequestMapping(value = "memberLogin")
    public String memberLogin(HttpServletRequest request, ModelMap modelMap) throws UnsupportedEncodingException {
        String  ID = get_cookie("sid", request);       
        modelMap.addAttribute("ID", ID);
        
        //네이버 로그인 URL send
        SecureRandom random = new SecureRandom();
		String state = new BigInteger(130, random).toString();
		String N_clientId = "36KLoyiUCNzwXRgdpCIW";
		String N_redirectURI = URLEncoder.encode("http://13.125.166.164:8080/Personal_Project/N_callback", "UTF-8");
//ex) http://localhost:8080/Trade_Project/N_callback/////////////////http://localhost:8080/N_callback
		String N_apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
		N_apiURL += "&client_id=" + N_clientId;
		N_apiURL += "&redirect_uri=" + N_redirectURI;
		N_apiURL += "&state=" + state;
		HttpSession session = request.getSession();
		session.setAttribute("state", state);

		modelMap.addAttribute("N_apiURL", N_apiURL);
		
		//카카오 로그인 URL send
		String K_clientId = "cebe5cc9aa9c3612a2ca79a4402a4d75";
		String K_redirectURI = URLEncoder.encode("http://13.125.166.164:8080/Re_Project/KK_callback", "UTF-8");
		String K_apiURL = "https://kauth.kakao.com/oauth/authorize?response_type=code";
		K_apiURL += "&client_id=" + K_clientId;
		K_apiURL += "&redirect_uri=" + K_redirectURI;
		modelMap.addAttribute("K_apiURL", K_apiURL);

        return "member/memberLogin";
    }
    
    /**
     * 로그인 처리.
     */
    @RequestMapping(value = "memberLoginChk")
    public String memberLoginChk(HttpServletRequest request,HttpServletResponse response, LoginVO loginInfo, ModelMap modelMap) {

        UserVO mdo = memberSvc.selectMember4Login(loginInfo);
        
        if (mdo  ==  null) {
            modelMap.addAttribute("msg", "로그인 할 수 없습니다.");
            return "common/message";
        }
        
        
//        memberSvc.insertLogIn(mdo.getUSERNO());
        
        HttpSession session = request.getSession();
        
        session.setAttribute("USERNO",  mdo.getUSERNO());
        session.setAttribute("id", mdo.getId());
        session.setAttribute("password", mdo.getPass());
        session.setAttribute("name",  mdo.getName());
        session.setAttribute("email",mdo.getEmail());
 
       
     
        
        if ("Y".equals(loginInfo.getRemember())) {
            set_cookie("sid", loginInfo.getId(), response);
        } else { 
            set_cookie("sid", "", response);       
        }
        
        return "redirect:/index";
    }   
//    
//    /**
//     * 로그아웃.
//     */
    @RequestMapping(value = "memberLogout")
    public String memberLogout(HttpServletRequest request, ModelMap modelMap) {
        HttpSession session = request.getSession();
        
//        String userno = session.getAttribute("USERNO").toString();
        
//        memberSvc.insertLogOut(userno);
        
        session.removeAttribute("USERNO");        
        session.removeAttribute("id"); 
        session.removeAttribute("password"); 
        session.removeAttribute("name");
        session.removeAttribute("email");        
        
        return "redirect:/memberLogin";
    }
//    //사용자 조회
//    @RequestMapping(value ="searchMember")
//    public String searchMember(HttpServletRequest request, BoardSearchVO bo,ModelMap modelMap) {
//    	HttpSession session = request.getSession();
//    	return "redirect:/searchMember";
//    }
    
    /** 
     * 사용자가 관리자페이지에 접근하면 오류 출력.
     */
//    @RequestMapping(value = "noAuthMessage")
//    public String noAuthMessage(HttpServletRequest request) {
//        return "common/noAuth";
//    }
  
    /*
     * -------------------------------------------------------------------------
     */
    /**
     * 회원가입 처리.
     */
    @RequestMapping(value = "memberSignUpChk")
    public String memberLoginChk(HttpServletRequest request,HttpServletResponse response, UserVO userInfo, ModelMap modelMap) {

        UserVO mdo = memberSvc.insertMember4Signup(userInfo);
        
        if (mdo  ==  null) {
            modelMap.addAttribute("msgs", "다시 작성해주세요");
            return "common/message";
        }

   
        
//        memberSvc.insertLogIn(mdo.getUSERNO());
        
        HttpSession session = request.getSession();
        
        session.setAttribute("USERNO",  mdo.getUSERNO());
        session.setAttribute("id", mdo.getId());
        session.setAttribute("pass", mdo.getPass());
        session.setAttribute("name",  mdo.getName());
        session.setAttribute("email",mdo.getEmail());
 
        
        return "redirect:/index";
    }   
    
    @RequestMapping(value = "N_callback")
	public String NaverCallback(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		String clientId = "36KLoyiUCNzwXRgdpCIW";
		String clientSecret = "cR93CfVVzY";
		String code = request.getParameter("code");
		String redirectURI = URLEncoder.encode("http://localhost:8080/index", "UTF-8");
		String state = request.getParameter("state");
		
		String apiURL;
		apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
		apiURL += "client_id=" + clientId;
		apiURL += "&client_secret=" + clientSecret;
		apiURL += "&redirect_uri=" + redirectURI;
		apiURL += "&code=" + code;
		apiURL += "&state=" + state;
		String access_token = "";
		String refresh_token = "";
		System.out.println("apiURL=" + apiURL);

		try {
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();
			BufferedReader br;
			System.out.print("responseCode=" + responseCode);
			if (responseCode == 200) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer res = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				res.append(inputLine);
			}
			br.close();
			if (responseCode == 200) {
				System.out.println(res.toString());
				JSONParser parsing = new JSONParser();
				Object obj = parsing.parse(res.toString());
				JSONObject jsonObj = (JSONObject) obj;

				access_token = (String) jsonObj.get("access_token");
				refresh_token = (String) jsonObj.get("refresh_token");

				System.out.println("acc_to: " + access_token);
				System.out.println("refresh_token : " + refresh_token);

				Naverinfo(request, response, access_token); //Naverinfo라는 메소드에 값들을 전달하여 정보값을 받아올꺼임!
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return "redirect:/index";
    }
    
    
    private void Naverinfo(HttpServletRequest request, HttpServletResponse response, String access_token) {
    	String reqURL = "https://openapi.naver.com/v1/nid/me";
		String name = "";
		String email = "";
		String id = "";

		try {
			URL url = new URL(reqURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Authorization", "Bearer " + access_token);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			System.out.print("responseCode=" + responseCode);
			if (responseCode == 200) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer res = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				res.append(inputLine);
			}
			br.close();

			System.out.println(inputLine);
            //여기서 사용자 정보들이 json형태로 받아와짐

			if (responseCode == 200) {
				System.out.println(res.toString());
				JSONParser parsing = new JSONParser();
				Object obj = parsing.parse(res.toString());
				JSONObject jsonObj = (JSONObject) obj;
				JSONObject naver_account = (JSONObject) obj;

				naver_account = (JSONObject) jsonObj.get("response");

				id = (String) naver_account.get("id");
				name = (String) naver_account.get("name");
				email = (String) naver_account.get("email");
                //받아오는 정보 값들
                
				 HttpSession session = request.getSession();
				 session.setAttribute("name", name);
				
				System.out.println("id : " + id);
				System.out.println("이름 : " + name);
				System.out.println("메일 : " + email);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
    
    @RequestMapping(value = "KK_callback")
	public String KakaoCallback(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		String clientId = "cebe5cc9aa9c3612a2ca79a4402a4d75";  // ﻿REST API키!
		String code = request.getParameter("code");
		System.out.println("code : " + code);
		String redirectURI = URLEncoder.encode("http://13.125.166.164:8080/Re_Project/KK_callback", "UTF-8");

		String apiURL;
		apiURL = "https://kauth.kakao.com/oauth/token?grant_type=authorization_code&";
		apiURL += "client_id=" + clientId;
		apiURL += "&redirect_uri=" + redirectURI;
		apiURL += "&code=" + code;
		String access_token = "";
		String refresh_token = "";
		System.out.println("apiURL=" + apiURL);

		try {
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();
			BufferedReader br;
			System.out.print("responseCode=" + responseCode);
			if (responseCode == 200) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer res = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				res.append(inputLine);
			}
			br.close();
			if (responseCode == 200) {
				System.out.println(res.toString());
				JSONParser parsing = new JSONParser();
				Object obj = parsing.parse(res.toString());
				JSONObject jsonObj = (JSONObject) obj;

				access_token = (String) jsonObj.get("access_token");
				refresh_token = (String) jsonObj.get("refresh_token");

				System.out.println("acc_to: " + access_token);
				System.out.println("refresh_token : " + refresh_token);

				Kakaoinfo(request, response, access_token); //kakaoinfo에 값들을 전달하여 본인 정보를 받아오는 곳
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return "redirect:/index";
	}
    
    public void Kakaoinfo(HttpServletRequest request, HttpServletResponse response, String access_token) {
		String reqURL = "https://kapi.kakao.com/v2/user/me";
		String name = "";
		String email = "";
		long id = 0;  //id값이 long형태임 (String이나 int는 안됨)

		try {
			URL url = new URL(reqURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Authorization", "Bearer " + access_token);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			System.out.print("responseCode=" + responseCode);
			if (responseCode == 200) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer res = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				res.append(inputLine);
			}
			br.close();
            System.out.println(inputLine); //여기서 json형태로 정보값들을 받아옴

			if (responseCode == 200) {
				System.out.println(res.toString());
				JSONParser parsing = new JSONParser();
				Object obj = parsing.parse(res.toString());
				JSONObject jsonObj = (JSONObject) obj;
				JSONObject properties = (JSONObject) obj;
				JSONObject kakao_account = (JSONObject) obj;

				properties = (JSONObject) jsonObj.get("properties");
				kakao_account = (JSONObject) jsonObj.get("kakao_account");

				
				
				id = (Long)jsonObj.get("id");
				name = (String) properties.get("nickname");
				email = (String) kakao_account.get("email");

				 HttpSession session = request.getSession();
				 session.setAttribute("name", name);
				
				System.out.println("properties" + properties);
				System.out.println("id : " + id);
				System.out.println("이름 : " + name);
				System.out.println("메일 : " + email);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
     * 쿠키 저장.     
     */
    public static void set_cookie(String cid, String value, HttpServletResponse res) {

        Cookie ck = new Cookie(cid, value);
        ck.setPath("/");
        ck.setMaxAge(cookieExpire);
        res.addCookie(ck);        
    }

    /**
     * 쿠키 가져오기.     
     */
    public static String get_cookie(String cid, HttpServletRequest request) {
        String ret = "";

        if (request == null) {
            return ret;
        }
        
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return ret;
        }
        
      for (Cookie ck : cookies) {
           if (ck.getName().equals(cid)) {
                ret = ck.getValue();
                
               ck.setMaxAge(cookieExpire);
                break; 
            }
          }
        return ret; 
    }
    
    @RequestMapping(value = "idCheck")
    public String overlap(HttpServletRequest request, ModelMap modelMap,
          @RequestParam(value = "id", defaultValue = "") String id) {

    	System.out.println("id값::::"+id);
       int check = memberSvc.idCheck(id);
       modelMap.addAttribute("check", check);
       modelMap.addAttribute("id", id);
       return "member/idCheck";
    }
}
