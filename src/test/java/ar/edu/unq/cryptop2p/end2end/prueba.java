//package ar.edu.unq.cryptop2p.end2end;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class prueba
//{
//    @Test
//    public void getOptionByIDCaseTheIDDoesNotExists(@Autowired MockMvc mvc) throws Exception {
//        String  uri = "/api/option/111";
//
//        mvc.perform(get(uri)).andExpect(status().isNotFound());
//    }
//
//    @Test
//    public void getOptionByIDCaseBadRequest(@Autowired MockMvc mvc) throws Exception {
//        String  uri = "/api/option/foo";
//
//        mvc.perform(get(uri)).andExpect(status().isBadRequest());
//    }
//}
