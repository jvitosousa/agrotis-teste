package io.github.jvitosousa.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import io.github.jvitosousa.controller.dto.UserDTO;
import io.github.jvitosousa.domain.entity.Laboratorio;
import io.github.jvitosousa.domain.entity.Propriedade;
import io.github.jvitosousa.domain.entity.User;
import io.github.jvitosousa.service.UserService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = UserController.class)
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	UserService userService;

	@Test
	public void getUsers() throws Exception {
		Propriedade proriedade = new Propriedade(1L, "teste");
		Laboratorio laboratorio = new Laboratorio(1L, "teste");
		User user = new User(1, "teste", "00.00.000/0001-00", "teste observacoes", new Date(),
				new Date(), proriedade, laboratorio);
		List<User> userList = List.of(user);
		when(userService.getUsers()).thenReturn(userList);
		this.mockMvc.perform(get("/user")).andExpect(status().isOk()).andExpect(content().string(containsString("00.00.000/0001-00")));
	}
	
	@Test
	public void getUser() throws Exception {
		Propriedade proriedade = new Propriedade(1L, "teste");
		Laboratorio laboratorio = new Laboratorio(1L, "teste");
		Optional<User> user = Optional.ofNullable(new User(1, "teste", "00.00.000/0001-00", "teste observacoes", new Date(),
				new Date(), proriedade, laboratorio));
		when(userService.getUser(1)).thenReturn(user);
		this.mockMvc.perform(get("/user/1")).andExpect(status().isOk()).andExpect(content().string(containsString("00.00.000/0001-00")));
	}

}
