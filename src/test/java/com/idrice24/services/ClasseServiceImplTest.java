package com.idrice24.services;

import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.idrice24.entities.Classe;
import com.idrice24.repositories.ClasseRepository;

@SpringBootTest()
public class ClasseServiceImplTest {

    // @Mock annotation is used to create the mock object to be injected
    @MockBean
    private ClasseRepository classeRepository;

    @BeforeEach
    public void setUpMocks() {
	Iterable<Classe> items = new ArrayList<>();
	when(classeRepository.findAll()).thenReturn(items);
    }

    // TODO@Idrice: Update this test until works!!
    @Test
    void emptyListAllClasses() {

	// Arrange
	ClasseService classeService = new ClasseServiceImpl();

	classeService.setClasseRepository(classeRepository);

    }

}
