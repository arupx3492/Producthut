package com.producthut.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cartId;

	private Integer cartValue;

	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private User user;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "cart_product", joinColumns = @JoinColumn(name = "cart_id"))
	@Column(name = "quantity")
	@MapKeyJoinColumn(name = "product_id", referencedColumnName = "productId")
	@JsonIgnore
	private Map<Product, Integer> products;
}
