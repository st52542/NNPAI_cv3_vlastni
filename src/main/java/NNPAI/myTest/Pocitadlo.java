package NNPAI.myTest;

import org.springframework.stereotype.Service;

@Service
public class Pocitadlo implements IPocitadlo {
    private int aktPocet = 0;

    public void pridani() {
        aktPocet++;
    }

    public int getAktPocet() {
        return aktPocet;
    }
}
