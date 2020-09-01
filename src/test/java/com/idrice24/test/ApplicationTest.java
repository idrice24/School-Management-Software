package com.idrice24.test;

public class ApplicationTest
{

}

/*
 * import static org.junit.Assert.assertEquals; //import static
 * org.junit.AssertTrue;
 * 
 * import org.aspectj.lang.annotation.Before; import org.junit.jupiter.api.Test;
 * import org.springframework.http.MediaType; import
 * org.springframework.test.web.servlet.MvcResult; import
 * org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
 * 
 * import com.idrice24.entities.User;
 * 
 * public class ApplicationTest extends AbstractTest {
 * 
 * @Override
 * 
 * @Before public void setUp() { super.setUp(); }
 * 
 * @Test public void getUserList() throws Exception { String uri = "/users";
 * MvcResult mvcResult =
 * mvc.perform(MockMvcRquestBuilders.get(uri)).accept(MediaType.
 * APPLICATION_JSON_VALUE).andReturn(); int status =
 * mvcResult.getResponse().getStatus(); assertEques(200, status); String content
 * = mvcResult.getResponse().getContentAsString(); User[] userlist =
 * super.mapFromJson(content, User[].class); assertTrue(userlist.length > 0); }
 * 
 * @Test public void createProduct() throws Exception { String uri = "/users";
 * User user = new User(); user.setId("3"); user.setName("Idrice"); String
 * inputJson = super.mapToJson(user); MvcResult mvcResult =
 * mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.
 * APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
 * 
 * int status = mvcResult.getResponse().getStatus(); assertEquals(201, status);
 * String content = mvcResult.getResponse().getContentAsString();
 * assertEquals(content, "User is created successfully"); }
 * 
 * @Test public void updateUser() throws Exception { String uri = "/users/2";
 * User user = new User(); user.setName("PAUL"); String inputJson =
 * super.mapToJson(user); MvcResult mvcResult =
 * mvc.perform(MockMvcRequestBuilders.put(uri).contentType(MediaType.
 * APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
 * 
 * int status = mvcResult.getResponse().getStatus(); assertEquals(200, status);
 * String content = mvcResult.getResponse().getContentAsString();
 * assertEquals(content, "User is updated successsfully"); }
 * 
 * @Test public void deleteUser() throws Exception { String uri = "/users/2";
 * MvcResult mvcResult =
 * mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn(); int status =
 * mvcResult.getResponse().getStatus(); assertEquals(200, status); String
 * content = mvcResult.getResponse().getContentAsString(); assertEquals(content,
 * "User is deleted successsfully"); } }
 */
