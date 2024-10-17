package com.zerobase.order.order.service;

import com.zerobase.order.order.domain.model.BookProductRelationEntity;
import com.zerobase.order.order.domain.model.ProductEntity;
import com.zerobase.order.order.domain.repository.ProductReader;
import com.zerobase.order.order.domain.repository.ProductStore;
import com.zerobase.order.order.service.ProductCommand.ModifyProduct;
import com.zerobase.order.order.service.ProductInfo.Main;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductReader productReader;
    private final ProductStore productStore;

    public void registerProduct(ProductCommand.RegisterProduct command) {

        ProductEntity product = productStore.store(command.toEntity());

        productStore.store(BookProductRelationEntity.builder()
            .productId(product.getId())
            .bookId(command.getBookId())
            .build()
        );

    }

    //TODO redis를 이용하여 동시성 해결하기
    @Transactional
    public void modifyProduct(ModifyProduct command) {

        ProductEntity product = productReader.getProductByProductId(command.getProductId());

        product.setName(command.getName());
        product.setPrice(command.getPrice());
        product.setQuantity(command.getQuantity());

    }

    public Main getProduct(Long productId) {
        return Main.from(productReader.getProductByProductId(productId));
    }
}
