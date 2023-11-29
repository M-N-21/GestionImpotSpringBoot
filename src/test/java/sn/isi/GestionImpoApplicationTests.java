package sn.isi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GestionImpoApplicationTests {

	@Test
    void contextLoads() {
        Assertions.assertDoesNotThrow(() -> {
        }, "Le chargement du contexte a échoué");
    }

}
