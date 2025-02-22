package manage;

import entities.Custvend;
import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtils {

    final static Logger logger = Logger.getLogger(SallesManage.class);

    @PostConstruct
    public void init() {
        if (logger.isDebugEnabled()) {  logger.debug("Init Session Utils"); }
    }

    public static HttpSession getSession() {
        return (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
    }

    public static HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance()
                .getExternalContext().getRequest();
    }

    public static String getUserName() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        return session.getAttribute("username").toString();
    }

    public static Custvend getCustvend() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        return (Custvend) session.getAttribute("Custvend");
    }

    public static String getName() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        return session.getAttribute("name").toString();
    }

    public static String getRole() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        return session.getAttribute("role").toString();
    }

    public static String getUserId() {
        HttpSession session = getSession();
        if (session != null)
            return (String) session.getAttribute("userid");
        else
            return null;
    }
}