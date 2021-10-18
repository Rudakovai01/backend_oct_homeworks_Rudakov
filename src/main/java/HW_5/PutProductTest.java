package HW_5;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.*;
import value.api.MiniMarketService;
import value.api.RetrofitUtils;
import value.model.ProductDto;
import retrofit2.Response;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;

public class PutProductTest {
    static MiniMarketService miniMarketService;
    ProductDto updateProduct;

    @BeforeAll
    static void setUp() {
        miniMarketService = RetrofitUtils.getRetrofit().create(MiniMarketService.class);
    }

    @BeforeEach
    void setUpPutProduct() {
        updateProduct = ProductDto.builder()
                .id((long) 2)
                .title("Bread")
                .price(35)
                .categoryTitle("Food")
                .build();
    }

    @Test
    @DisplayName("Update Product")
    void PutProduct() throws IOException {
        Response<ProductDto> responsePostProduct = miniMarketService.updateProduct(updateProduct).execute();
        assertThat(responsePostProduct.isSuccessful(), CoreMatchers.is(true));
    }

    @AfterEach
    void tearDown() throws IOException {
        ProductDto returnProduct = ProductDto.builder()
                .id((long) 2)
                .title("Bread")
                .price(25)
                .categoryTitle("Food")
                .build();
        Response<ProductDto> responseUpdateProduct = miniMarketService.updateProduct(returnProduct).execute();
        assertThat(responseUpdateProduct.isSuccessful(),CoreMatchers.is(true));
    }
}
