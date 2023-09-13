package test;

import org.example.controller.UsuarioController;
import org.exemple.data.request.UsuarioDTORequest;
import org.exemple.ports.api.UsuarioServicePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


public class DemoTest {


    @Test
    void name() {

        System.out.println("prueba");
    }
}
