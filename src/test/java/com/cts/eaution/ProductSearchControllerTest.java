package com.cts.eaution;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.cts.eaution.controller.ProductSearchController;
import com.cts.eaution.dao.ProductIdAndName;
import com.cts.eaution.service.ProductSearchService;
import com.cts.eaution.vo.Category;
import com.cts.eaution.vo.ProductVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductSearchController.class)
public class ProductSearchControllerTest {

	@MockBean
	ProductSearchService mockProductSearchService;

	@Autowired
	private transient MockMvc mvc;

	private static String token = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzZWxsZXJAZ21haWwuY29tIiwicm9sZXMiOnsic3ViIjoic2VsbGVyQGdtYWlsLmNvbSIsInNjb3BlcyI6IlNFTExFUiIsInVzZXJFbWFpbCI6InNlbGxlckBnbWFpbC5jb20iLCJ1c2VySUQiOjF9LCJpYXQiOjE2NjUzMDQ3MzUsImV4cCI6MTY2NTMzNDczNX0.wS9z4lGO0ol4uo5eSvomtNxW2WQQBQAOi4FeAS1YHVs";
	ProductVO product1, product2 = null;
	List<ProductVO> productList, productListA = null;
	ProductIdAndName productDetails = null;
	List<ProductIdAndName> prodIdNname = new ArrayList<ProductIdAndName>();

	void setUp() {
		product1 = new ProductVO();
		product1.setId(1l);
		product1.setName("ProductA");
		product1.setShortDescription("productA -oranamental product");
		product1.setCreatedBy(21l);
		product1.setCategory(Category.ORNAMENT);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 7);
		product1.setBidEndDate(cal.getTime());

		product2 = new ProductVO();
		product2.setId(2l);
		product2.setName("ProductB");
		product2.setShortDescription("productB -oranamental product");
		product2.setCreatedBy(21l);
		product2.setCategory(Category.ORNAMENT);
		product2.setBidEndDate(cal.getTime());

		productList = new ArrayList<ProductVO>();
		productList.add(product1);
		productList.add(product2);

		productListA.add(product1);

		ProductIdAndName productDetails = new ProductIdAndName() {

			@Override
			public String getId() {
				// TODO Auto-generated method stub
				return "1";
			}

			@Override
			public String getName() {
				// TODO Auto-generated method stub
				return "ProductA";
			}

		};
		prodIdNname.add(productDetails);

	}

	@Test
	void getAllproductsTest() throws Exception {
		when(mockProductSearchService.getAllProducts()).thenReturn(productList);

		mvc.perform(get("/product/all/").header("authorization", token)).andExpect(status().isOk());

		verify(mockProductSearchService, times(1)).getAllProducts();
	}

	@Test
	void getProductByNameTest() throws Exception {
		when(mockProductSearchService.getProductByName("ProductA")).thenReturn(productList);

		mvc.perform(get("/product?name=ProductA").header("authorization", token)).andExpect(status().isOk());
		verify(mockProductSearchService, times(1)).getProductByName(Mockito.any(String.class));

	}

	@Test
	void getAllProductNamesTest() throws Exception {
		when(mockProductSearchService.getAllProductNames()).thenReturn(prodIdNname);

		mvc.perform(get("/product/names/").header("authorization", token)).andExpect(status().isOk());
		verify(mockProductSearchService, times(1)).getAllProductNames();

	}

	@Test
	void getProductsByCategoryTest() throws Exception {
		when(mockProductSearchService.getProducts(Category.ORNAMENT)).thenReturn(productList);

		mvc.perform(get("/product/category/ORNAMENT").header("authorization", token)).andExpect(status().isOk());
		verify(mockProductSearchService, times(1)).getProducts(Mockito.any(Category.class));

	}

	@Test
	void getProductsByIdTest() throws Exception {
		
		when(mockProductSearchService.getProducts(Category.ORNAMENT)).thenReturn(productList);

		mvc.perform(get("/product/1").header("authorization", token)).andExpect(status().isOk());
		verify(mockProductSearchService, times(1)).getProductById(Mockito.any(Long.class));

	}

	private static String jsonToString(final Object obj) throws JsonProcessingException {
		// TODO Auto-generated method stub
		String result;
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			result = jsonContent;
		} catch (JsonProcessingException e) {
			// TODO: handle exception
			result = "Json Processing error";
		}
		return result;
	}
}
