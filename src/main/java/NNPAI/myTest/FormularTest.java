package NNPAI.myTest;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service
@Scope(value = "session",proxyMode = ScopedProxyMode.TARGET_CLASS)
public class FormularTest implements IFormularTest{
    private String jmeno;
    private String text;
    private String mail;

    @Override
    public String getJmeno() {
        return jmeno;
    }
    @Override
    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }
    @Override
    public String getText() {
        return text;
    }
    @Override
    public void setText(String text) {
        this.text = text;
    }
    @Override
    public String getMail() {
        return mail;
    }
    @Override
    public void setMail(String mail) {
        this.mail = mail;
    }
}
