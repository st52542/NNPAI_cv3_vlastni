package NNPAI.myTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.util.Locale;

@SpringBootApplication
public class MyTestApplication {


    public static void main(String[] args) {
        SpringApplication.run(MyTestApplication.class, args);
    }

    @Controller
    public class mujTest {

        private final IFormularTest IFormularTest;
        private final IPocitadlo IPocitadlo;

        @Autowired
        public mujTest(@Qualifier("formularTest") IFormularTest IFormularTest, IPocitadlo IPocitadlo) {
            this.IFormularTest = IFormularTest;
            this.IPocitadlo = IPocitadlo;
        }

        @GetMapping(value = "mujTest")
        public String formularSub(Model model) {
            IPocitadlo.pridani();
            model.addAttribute("pocitadlo", IPocitadlo.getAktPocet());
            return "mujTest";
        }

        @PostMapping(value = "mujTest")
        public String formularSub(@RequestParam String jmeno, @RequestParam String text, @RequestParam String mail, Model model) {
            IFormularTest.setJmeno(jmeno);
            IFormularTest.setText(text);
            IFormularTest.setMail(mail);
            model.addAttribute("jmenoOut", IFormularTest.getJmeno());
            model.addAttribute("textOut", IFormularTest.getText());
            model.addAttribute("mailOut", IFormularTest.getMail());
            model.addAttribute("pocitadlo", IPocitadlo.getAktPocet());
            return "mujTest";
        }

/*        @RequestMapping(value = "/mujTest", method = {RequestMethod.POST, RequestMethod.GET})
        public String formularSub(@RequestParam(required = false) String jmeno, @RequestParam(required = false) String text, @RequestParam(required = false) String mail, Model model) {
            if (jmeno != null && text != null && mail != null) {
                IFormularTest.setJmeno(jmeno);
                IFormularTest.setText(text);
                IFormularTest.setMail(mail);
                model.addAttribute("jmenoOut", IFormularTest.getJmeno());
                model.addAttribute("textOut", IFormularTest.getText());
                model.addAttribute("mailOut", IFormularTest.getMail());
            }
            IPocitadlo.pridani();
            model.addAttribute("pocitadlo", IPocitadlo.getAktPocet());
            return "mujTest";
        }*/

    }

}
